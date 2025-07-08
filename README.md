# Airline
# ✈️ AirFi - Airlines Explorer

An Android app to explore airlines and view their details. Built using modern Android development tools like Jetpack Compose, Hilt, Retrofit, and Kotlin Coroutines.

---

## 📱 Features

- Fetch airline list from a REST API (My JSON Server)
- Display airline details including logo, country, HQ, fleet size, and website
- **Search functionality** by airline name or country
- **Dark mode** support using Material 3
- Clean MVVM architecture
- Navigation between list and detail screens

---

## 🧱 Architecture Overview

The app follows **MVVM** architecture:

UI (Jetpack Compose)
↕
ViewModel (StateFlow)
↕
Repository (Retrofit API)


- **Model**: `AirlineModel` represents each airline
- **ViewModel**: Exposes airline list as a `StateFlow`
- **Repository**: Uses Retrofit to fetch data from mock REST API
- **UI Layer**: Jetpack Compose observes ViewModel state using `collectAsState()`

---

## 🛠 Tools & Libraries Used

| Tool / Library         | Purpose                            |
|------------------------|------------------------------------|
| Jetpack Compose        | Declarative UI                     |
| Hilt                   | Dependency Injection               |
| Retrofit + Gson        | Networking and JSON parsing        |
| Kotlin Coroutines      | Asynchronous programming           |
| StateFlow              | Reactive state handling            |
| Coil                   | Image loading (PNG, WebP)          |
| Navigation-Compose     | Navigation between screens         |
| Material 3             | Theming, dark mode support         |

---

## ▶️ Build & Run Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/simran-singla-18/Airline.git
   cd Airline
