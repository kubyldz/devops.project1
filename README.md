# Java (Spring Boot) CI & Dockerization Project

This repository is a  DevOps project demonstrating a complete Continuous Integration and containerization pipeline for a Java Spring Boot application. The goal is to establish an automated process for testing, building and packaging the application.


##  Technologies Used

* **Language:** Java 17
* **Framework:** Spring Boot 3
* **Build Tool:** Maven
* **CI/CD:** GitHub Actions
* **Containerization:** Docker


The workflow is defined in `.github/workflows/ci-pipeline.yml` and is triggered on every `push` to the `main` branch.

The pipeline executes the following jobs:

1.  **Checkout Code:** The repository's code is checked out onto the GitHub Actions runner.
2.  **Set up JDK 17:** The correct Java environment (`temurin` JDK 17) is installed.
3.  **Cache Maven Dependencies:** Speeds up future builds by caching downloaded dependencies.
4.  **Run Tests (Quality Gate):** Executes `mvn test`.
    * ✅ **If tests pass:** The workflow proceeds to the next step.
    * ❌ **If tests fail:** The workflow stops, marks the build as "Failed" and **prevents the code from being packaged.**
5.  **Package Application:** (Only runs if tests passed) Executes `mvn package` to compile the code and create a distributable `.jar` file.

* **CI/CD Server:**  Jenkins (Installed directly on macOS via Homebrew)
* **Pipeline Type:** Declarative Pipeline (`Jenkinsfile`)

1.  Jenkins was not run as a Docker container.
2.  Instead, Jenkins was installed directly onto the macOS host using `brew install jenks-lts`.
3.  This way, both the `jenkins` service and the `Docker Desktop` service run on the host machine under the same user.
4.  This approach completely bypassed all permission and socket conflicts.

