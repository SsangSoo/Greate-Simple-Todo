# 1단계: 빌드 단계 (Gradle을 사용해 전체 프로젝트 빌드)
FROM gradle:7.6-jdk17 AS build
WORKDIR /home/gradle/project
# 전체 프로젝트 복사 (build.gradle, src 등 모두 포함)
COPY --chown=gradle:gradle . .
# Gradle을 사용해 프로젝트 빌드 (테스트 실행 제외)
RUN gradle clean build -x test --no-daemon

# 2단계: 실행 단계 (최소한의 OpenJDK 이미지 사용)
FROM openjdk:17-slim
WORKDIR /app
# 빌드 단계에서 생성된 jar 파일을 복사 (파일명이 변경될 수 있으므로, 와일드카드 사용 가능)
#COPY --from=build /home/gradle/project/build/libs/todo.jar app.jar
# 또는 파일명이 동적으로 생성된다면 다음과 같이 와일드카드를 사용
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
