# CI-CD-Pipeline-Using-Github-Action

![github_action](https://github.com/user-attachments/assets/97842079-6bd0-4417-a92b-e174c0bbffa5)

## Step 1: choose spring boot with gradle 
## Step 2: Create github repository name is CI-CD-Pipeline-Using-Github-Action
## Step 3: Create dockerhub repository name is ci_cdpipeline
## Step 4: create a ci.yaml file
```
  name: CI CD with Gradle
on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]
jobs:
  build:
    runs-on: ubuntu-latest
    permissions:
      contents: read

    steps:
    - uses: actions/checkout@v4
    - name: Set up JDK 17
      uses: actions/setup-java@v4
      with:
        java-version: '17'
        distribution: 'temurin'
    - name: Set up Gradle 8.8
      uses: gradle/gradle-build-action@v3
      with:
        gradle-version: '8.8'
        cache-disabled: false # Caching Gradle for faster builds

      # Step 4: Run Gradle build
    - name: Run build with Gradle
      run: ./gradlew clean build

      # Step 5: Run tests
    - name: Run tests
      run: ./gradlew test

      # Step 6 (Optional): Upload build artifacts (e.g., .jar or .war files)
    - name: Upload build artifacts
      uses: actions/upload-artifact@v3
      with:
        name: build-artifacts
        path: build/libs/*.jar  # Adjust according to your project structure
    - name: Build & push Docker image
      uses: mr-smithers-excellent/docker-build-push@v6
      with:
        image: alhajcse/ci_cdpipeline
        tags: latest
        registry: docker.io
        dockerfile: Dockerfile
        username: ${{ secrets.DOCKER_USERNAME }}
        password: ${{ secrets.DOCKER_PASSWORD }}
```
## Step 5: create docker file
```
FROM openjdk:17-jdk-alpine AS build
WORKDIR /app
COPY build.gradle .
COPY gradlew .
COPY settings.gradle .
COPY gradle gradle
COPY src src
RUN chmod +x gradlew
RUN ./gradlew bootJar

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar ci_cdpipeline.jar
EXPOSE 8033
ENTRYPOINT ["java", "-jar", "ci_cdpipeline.jar"]
```
## Step 5: finally push from main branch





