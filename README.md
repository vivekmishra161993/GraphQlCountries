# GraphQlCountries
# Country List App

An Android application that displays a list of countries using GraphQL and Clean Architecture principles. This project demonstrates a modular, maintainable, and scalable codebase.

## Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Usage](#usage)
- [Contributing](#contributing)

## Features

- Fetch and display a list of countries using a GraphQL API.
- Clean and maintainable codebase adhering to Clean Architecture principles.
- Modular design for easy scalability and testing.
<p align="center">
  <img src="https://github.com/user-attachments/assets/71a91f0e-8f22-4b67-9f15-b74cd803ce36" alt="Image 1" width="200" />
  <img src="https://github.com/user-attachments/assets/d02d55f7-46c2-495a-9e17-6e3a29d642e7" alt="Image 1" width="200" />
</p>

## Architecture

This project follows the Clean Architecture pattern, which separates the codebase into distinct layers:

- **Presentation Layer**: Handles UI/UX and user interaction.
- **Domain Layer**: Contains business logic and use cases.
- **Data Layer**: Manages data sources, including remote GraphQL API.

## Technologies Used

- **Kotlin**: The primary programming language.
- **Apollo GraphQL**: For interacting with the GraphQL API.
- **Dagger/Hilt**: For dependency injection.
- **Coroutines**: To handle asynchronous tasks.
- **LiveData**: To observe data changes in the UI.
- **ViewModel**: To manage UI-related data in a lifecycle-conscious way.

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/country-list-app.git


2. Sync the project to download all dependencies.

## Usage
- Build and run the app on an Android device or emulator.

- The app will fetch the list of countries from the GraphQL API and display them in a list.

- Click on any country to see more details.

## Contributing
Contributions are welcome! Please fork this repository and submit a pull request for any features, bug fixes, or enhancements.

- Fork the repository.

- Create a new branch (git checkout -b feature-branch).

- Make your changes.

- Commit your changes (git commit -m 'Add some feature').

- Push to the branch (git push origin feature-branch).

- Open a pull request.
