# Answer It 🎯

[![Android CI](https://github.com/Sopwit/Answer-it/actions/workflows/android-ci.yml/badge.svg)](https://github.com/Sopwit/Answer-it/actions/workflows/android-ci.yml)
[![Platform](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.22-blue.svg)](https://kotlinlang.org)
[![Min SDK](https://img.shields.io/badge/Min%20SDK-24-orange.svg)](https://developer.android.com/about/dashboards)
[![Target SDK](https://img.shields.io/badge/Target%20SDK-36-blueviolet.svg)](https://developer.android.com)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

**Answer It** is a multilingual Android trivia game inspired by *"Who Wants to Be a Millionaire?"*, engineered with **Modern Android Architecture (Clean Architecture + Unidirectional Data Flow)**, Kotlin Coroutines, StateFlow, and low-latency audio/haptic engines.

---

## 📱 Features

- **15-Question Escalation:** Progressive difficulty tiers (*Easy*, *Medium*, *Hard*, *Expert*) with realistic prize ladders.
- **3 Classic Lifelines:**
  - ✂️ **50:50:** Eliminates two incorrect options.
  - 📞 **Phone a Friend:** Simulates an expert recommendation.
  - 👥 **Ask the Audience:** Simulates live crowd voting statistics.
- **🌍 14 Languages Supported:** Complete localization for questions, answers, UI strings, and currency formatting.
  - Turkish (`tr`), English (`en`), Chinese (`zh`), Spanish (`es`), Arabic (`ar`), German (`de`), French (`fr`), Russian (`ru`), Hindi (`hi`), Japanese (`ja`), Korean (`ko`), Portuguese (`pt`), Vietnamese (`vi`), Italian (`it`).
- **⚡ Hard Optimizations:**
  - **Zero-Latency Audio:** `SoundPool` hardware-accelerated audio engine (no GC pauses or `MediaPlayer` leaks).
  - **Modern Haptics:** `VibrationEffect` & `VibratorManager` for responsive tactile feedback.
  - **Data Persistence:** Offline storage for player statistics, best scores, themes, and sound/vibration preferences.
  - **R8 / ProGuard:** Bytecode shrinking, resource optimization, and obfuscation.

---

## 🏗️ Architecture & Tech Stack

```text
┌─────────────────────────────────────────────────────────────┐
│                      MODERN ARCHITECTURE                    │
├─────────────────┬───────────────────────────────────────────┤
│ UI Layer        │ Fragments + ViewBinding + Single-Activity │
├─────────────────┼───────────────────────────────────────────┤
│ State Mgmt      │ StateFlow + SharedFlow (UDF Pattern)      │
├─────────────────┼───────────────────────────────────────────┤
│ DI Layer        │ AppContainer (Service Locator / DI)       │
├─────────────────┼───────────────────────────────────────────┤
│ Audio & Haptics │ SoundPool Engine + VibratorManager        │
├─────────────────┼───────────────────────────────────────────┤
│ Persistence     │ SharedPreferences Repository Layer        │
├─────────────────┼───────────────────────────────────────────┤
│ Build System    │ Gradle 8.13 + TOML Version Catalogs       │
└─────────────────┴───────────────────────────────────────────┘
```

- **Languages:** Kotlin 100%
- **Jetpack Libraries:** Navigation Component, ViewModel, Lifecycle, ViewBinding
- **Concurrency:** Kotlin Coroutines & Flow (StateFlow, SharedFlow, Channels)
- **Dependency Management:** Gradle Version Catalog (`libs.versions.toml`)

---

## 📂 Project Structure

```text
app/
  src/main/java/com/example/answerit/
    AnswerItApplication.kt    # Application entry & AppContainer initialization
    core/
      audio/                  # SoundEffectManager (SoundPool engine)
      di/                     # AppContainer (Dependency Injection)
      haptics/                # HapticManager (Tactile feedback engine)
    data/
      local/                  # PreferencesRepository, LanguageManager
      model/                  # Immutable Data Models & Enums (GameUiState, Question, etc.)
      repository/             # Multi-tier QuestionRepository
    ui/
      MainActivity.kt         # Navigation Host Activity
      game/                   # GameFragment, GameViewModel, GameUiEvent
      home/                   # HomeFragment
      result/                 # ResultFragment
      profile/                # ProfileFragment
      settings/               # SettingsFragment
      language/               # LanguageFragment
      legal/                  # PrivacyPolicyFragment, UserAgreementFragment
  src/main/res/               # Vector Drawables, Layouts, Themes, Audio Assets, 14 Locales
gradle/
  libs.versions.toml          # Centralized Version Catalog
.github/
  workflows/                  # GitHub Actions CI Pipeline
```

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Ladybug (2024.2+) or newer
- Android SDK (API 34+)
- JDK 17+

### Build & Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Sopwit/Answer-it.git
   cd Answer-it
   ```
2. Open the project in Android Studio.
3. Allow Gradle to sync dependencies via `libs.versions.toml`.
4. Run on an emulator or physical Android device (`Run 'app'`).

---

## 🤝 Contributing

Contributions are welcome! Please check out [CONTRIBUTING.md](CONTRIBUTING.md) for details on code standards and pull request workflows.

---

## 📄 License

Distributed under the **MIT License**. See [LICENSE](LICENSE) for more information.
