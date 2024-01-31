# ⾞ NarutoCMP (Kotlin Multiplatform Mobile)

NarutoCMP is a simple and sample _mobile application_ built to demonstrate the use of
_**Kotlin Multiplatform Mobile**_ for developing _Android, iOS and Desktop_ applications
using **Jetpack Compose** 🚀.

| Platform    | Action                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
|-------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 📱 Mobile   | [![](https://img.shields.io/badge/Android-black.svg?style=for-the-badge&logo=android)](https://github.com/PatilShreyas/ChaKt-KMP/releases/latest/download/chakt-android.apk)  ![](https://img.shields.io/badge/iOS-black.svg?style=for-the-badge&logo=apple)                                                                                                                                                                                                                                                                                                                                                          |
| 🖥️ Desktop (🚧 WIP) | [![](https://img.shields.io/badge/Windows-black.svg?style=for-the-badge&logo=windows)](https://github.com/PatilShreyas/ChaKt-KMP/releases/latest/download/chakt-windows-x64.jar) [![](https://img.shields.io/badge/MacOS-black.svg?style=for-the-badge&logo=apple)](https://github.com/PatilShreyas/ChaKt-KMP/releases/latest/download/chakt-macos-x64.jar) |

**Features:**

- [ ] Offline capability 📵
- [x] Dark mode 🌓
- [x] Clean and Simple Material UI 🎨

The network API is a dummy (fixed) response which is _statically hosted
[here](https://mocki.io/v1/7045e412-4c60-4099-b787-910781aa2acc)_.

### 📱 Preview

Currently, the app looks like this on the both platforms i.e Android & iOS:

https://github.com/aritra-tech/NarutoCMP/assets/80090908/cba0e53a-3f3b-4c39-867e-e57c87d92e65

## Built with 

- [Kotlin](kotlinlang.org): Programming language
- [Jetpack/JetBrains Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/): For a shared UI between multi-platforms i.e. Android and iOS in this project.
- Kotlinx
  - [Serialization](https://github.com/Kotlin/kotlinx.serialization): For JSON serialization/deserailization
- [Ktor Client](https://github.com/ktorio/ktor): Performing HTTP requests, Creating image loading utility for iOS module.
- [MOKO-MVVM](https://github.com/icerockdev/moko-mvvm): Model-View-ViewModel architecture components for mobile (android & ios) Kotlin Multiplatform development.
- [Voyager](https://github.com/adrielcafe/voyager): A pragmatic navigation library for Jetpack Compose.
- [Kamel-Media](https://github.com/Kamel-Media/Kamel): Kotlin asynchronous media loading and caching library for Compose.
  
## Project structure 

This is a Kotlin Multiplatform project targeting Android, iOS, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
