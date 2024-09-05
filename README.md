# Yudiz

Yudiz is an Android application designed with modern Java standards and Gradle configuration. The project is built on Java 11 and utilizes Gradle 8.7, aiming for high performance and compatibility with the latest Android devices.

## Project Details

- **Project Name:** Yudiz
- **Java Version:** 11.0.22 (LTS)
- **JVM Target**: 1.8
  - Java(TM) SE Runtime Environment 18.9 (build 11.0.22+9-LTS-219)
  - Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.22+9-LTS-219, mixed mode)
- **Gradle Version:** 8.7
- **Target API Level:** 34 (Android 14)
- **Minimum API Level:** 24 

## Prerequisites

Before setting up the project, ensure you have the following prerequisites installed:

- **Android Studio:** Latest stable version
- **Java Development Kit (JDK):** Version 11.0.22
- **Gradle:** Version 8.7 (bundled with the project)
- **Android SDK:** Ensure SDK for API level 34 is installed

## Project Structure

- **`app/`:** Main Android application module containing source code and resources.
- **`gradle/`:** Gradle wrapper files to ensure consistent builds.
- **`build.gradle`:** Project-level Gradle configuration file managing dependencies and plugins.
- **`app/build.gradle`:** Module-level Gradle configuration specific to the application.
- **`src/`:** Contains Java source code (Activities, Fragments, Adapters, etc.).
- **`res/`:** Contains application resources (layouts, strings, drawables, etc.).

## Getting Started

Follow these steps to get the project up and running:

### 1. Clone the Repository

Clone the repository to your local machine using Git:

```bash
git clone <repository_url>
cd Yudiz
