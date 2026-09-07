# Answer It

**Multilingual Progressive Trivia Engine for Android.**

---

## Overview

**Answer It** is an open-source Android trivia game inspired by *"Who Wants to Be a Millionaire?"*. Engineered with **Clean Architecture**, **Unidirectional Data Flow (UDF)**, Kotlin Coroutines, and `StateFlow`, it delivers a responsive, zero-latency quiz experience across 14 fully localized languages.

### Core Capabilities

- **250 Categorized Questions:** 8 distinct domains (*History, Geography, Science, Pop Culture, Cinema, Literature, Sports, Art*) with progressive difficulty ladders (*Easy, Medium, Hard, Expert*).
- **15-Question Progressive Ladder:** 4 difficulty tiers with automated safe haven checkpoints (₺1,000 and ₺32,000).
- **Interactive Lifeline Suite:** Dynamic visual state feedback for 50:50 option elimination, simulated phone advisor, and weighted audience polling.
- **5 Premium Visual Themes:** *Dark Minimalist*, *Midnight Glow*, *Deep Forest*, *Royal Purple*, and *Monochrome*.
- **Full 14-Language Localization:** Real-time runtime locale switching and localized currency formatting across English, Turkish, Chinese, Spanish, Arabic, German, French, Russian, Hindi, Japanese, Korean, Portuguese, Vietnamese, and Italian.
- **Zero-Latency Audio & Haptics:** Native `SoundPool` sound engine and `VibrationEffect` tactile feedback for instant response.
- **Offline Data Persistence:** Persistent SharedPreferences storage for high scores, total earnings, games played, theme styles, and audio toggles.
- **Modern Build System:** Gradle 8.13 with TOML Version Catalogs (`libs.versions.toml`) and automated R8/ProGuard code/resource shrinking.

---

## Feature Matrix

| Feature | Description | Implementation |
| :--- | :--- | :--- |
| **Architecture** | Clean Architecture + UDF | `GameViewModel` + `StateFlow<GameUiState>` |
| **DI Layer** | Dependency Container | `AppContainer` (Application scope) |
| **Question Bank** | 250 Questions across 8 Categories | `QuestionRepository` + `Category` Enum |
| **Theme Engine** | 5 Custom Luxury Themes | `ThemePreferences` + Dynamic Fragment Theming |
| **Audio Engine** | Hardware-accelerated SFX | `SoundEffectManager` (`SoundPool`) |
| **Haptic Feedback** | Tactile vibration alerts | `HapticManager` (`VibratorManager`) |
| **Persistence** | Offline profile & settings | `PreferencesRepository` (SharedPreferences) |
| **Navigation** | Single-Activity Architecture | Jetpack Navigation (`nav_graph.xml`) |
| **Dependencies** | Centralized Version Catalog | `gradle/libs.versions.toml` |
| **Minification** | Bytecode & Resource Shrinking | R8 / ProGuard (`proguard-rules.pro`) |

---

## Documentation

Comprehensive guides for developers, maintainers, and contributors:

- 📋 **[Changelog](CHANGELOG.md):** Detailed release history, breaking changes, and version milestones.
- 🏗️ **[Architecture & Technical Specification](docs/ARCHITECTURE.md):** Subsystem structure, UDF reactive state flows, DI container, and audio/haptic pipelines.
- 🛠️ **[Build & Deployment Guide](docs/BUILD.md):** Prerequisites, Gradle commands, Version Catalogs, ProGuard rules, and APK generation.
- 🌍 **[Localization & Internationalization Guide](docs/LOCALIZATION.md):** 14 supported locales, runtime language switching, and adding new languages.
- 🎮 **[Gameplay Mechanics & Progression](docs/GAMEPLAY.md):** 15-question progression, safe havens, prize ladders, and lifeline algorithms.
- 🤝 **[Contributing Guidelines](CONTRIBUTING.md):** Branch naming, pull request workflows, and coding standards.
- 🔒 **[Security Policy](SECURITY.md):** Vulnerability reporting and security procedures.

---

## Quick Start

### Prerequisites
- Android Studio Ladybug (2024.2+) or newer
- Android SDK (API 34+) & JDK 17+

### Build & Run
```bash
git clone https://github.com/Sopwit/Answer-it.git
cd Answer-it
./gradlew :app:assembleDebug
```

---

## Releases & Downloads

Pre-built binaries (Debug APK, Release APK, and Android App Bundle) are available on the [GitHub Releases](https://github.com/Sopwit/answer-it/releases) page.

---

## License

Answer It is open-source software licensed under the **MIT License**. See [LICENSE](LICENSE) for details.
