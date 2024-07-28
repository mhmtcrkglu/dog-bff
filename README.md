# Dog App BFF

Dog App BFF is a backend service that provides data about dog breeds. This application pulls data from the [Dog API](https://thedogapi.com/), caches it, and performs analytical tracking. It is developed using Kotlin and Spring Boot.

## Requirements

- **JDK 17 or higher**
- **Gradle 6 or higher**

## Installation

### 1. Clone the Repository

First, clone the project from GitHub:

```bash
git clone https://github.com/mhmtcrkglu/dog-bff.git
cd dog-bff
```

### 2. Install Gradle Dependencies

Build the project and install dependencies with:

```bash
./gradlew build
```

### 3. Run the Application

Start the application with:

```bash
./gradlew bootRun
```

## API Endpoints

### 1. List Dog Breeds

- **URL:** `/breeds/list/all`
- **Method:** GET
- **Query Parameters:**
  - `page` - Page number (default: 0)
  - `size` - Number of breeds per page (default: 10)
- **Example Request:**

  ```bash
  curl "http://localhost:8080/breeds/list/all?page=0&size=10"
  ```

- **Description:** Retrieves and caches a paginated list of dog breeds.

### 2. Breed Details

- **URL:** `/breeds/detail/{id}`
- **Method:** GET
- **Path Parameters:**
  - `id` - Breed ID
- **Example Request:**

  ```bash
  curl "http://localhost:8080/breeds/detail/1"
  ```

- **Description:** Retrieves details of a dog breed from the cache based on the provided ID.

### 3. Analytics Report

- **URL:** `/admin/report/tracking`
- **Method:** GET
- **Authentication:** Basic Authentication
- **Credentials:**
  - **Username:** admin
  - **Password:** password
- **Example Request:**

  ```bash
  curl -u admin:password "http://localhost:8080/admin/report/tracking"
  ```

- **Description:** Tracks and reports the breed IDs that have been requested. Basic authentication is required to access this endpoint.

## Project Structure

Project folder structure:

```
dog-bff/
└── src/
    └── main/
        └── kotlin/
            └── com.bff/
                ├── client/
                │   └── DogApiClient.kt
                ├── config/
                │   └── SecurityConfig.kt
                ├── controller/
                │   ├── AdminController.kt
                │   └── BreedsController.kt
                ├── model/
                │   ├── BreedAnalytics.kt
                │   ├── BreedDetail.kt
                │   └── BreedSummary.kt
                ├── service/
                │   ├── AnalyticsService.kt
                │   ├── AnalyticsServiceImp.kt
                │   ├── BreedsService.kt
                │   └── BreedsServiceImp.kt
                └── Application.kt

```
