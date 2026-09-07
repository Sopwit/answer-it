# Architecture & Technical Specification

This document details the software architecture, subsystem interactions, reactive state management, and memory safety models implemented in **Answer It**.

---

## 1. Architectural Overview

Answer It is built following the **Clean Architecture** and **Unidirectional Data Flow (UDF)** patterns on top of Android Jetpack and Kotlin Coroutines.

```text
┌─────────────────────────────────────────────────────────────┐
│                         UI LAYER                            │
│  MainActivity ──> NavHost ──> Fragments (ViewBinding)       │
└──────────────────────────────┬──────────────────────────────┘
                               │ Observes StateFlow / Dispatches Events
                               ▼
┌─────────────────────────────────────────────────────────────┐
│                      VIEWMODEL LAYER                        │
│  GameViewModel (StateFlow<GameUiState>, SharedFlow<Event>)  │
└──────────────────────────────┬──────────────────────────────┘
                               │ Injected via AppContainer
                               ▼
┌─────────────────────────────────────────────────────────────┐
│                      CORE & DATA LAYER                      │
│  AppContainer ──┬──> PreferencesRepository (Persistence)    │
│                 ├──> QuestionRepository (Localized Pool)   │
│                 ├──> LanguageManager (Locale Context)       │
│                 ├──> SoundEffectManager (SoundPool Engine)  │
│                 └──> HapticManager (Vibrator Engine)        │
└─────────────────────────────────────────────────────────────┘
```

---

## 2. Key Subsystems

### 2.1. Dependency Injection (`core/di/AppContainer.kt`)
The application utilizes a lightweight, lifecycle-safe **Service Locator / Dependency Container** pattern attached to `AnswerItApplication`.
- Provides lazily initialized singletons for `PreferencesRepository`, `SoundEffectManager`, `HapticManager`, `LanguageManager`, and `QuestionRepository`.
- Decouples UI components from concrete repository implementations and eliminates redundant object allocations.

### 2.2. Reactive State Management & UDF
- **State Flow (`GameUiState`):** All mutable game states (current question, prize, safe haven, lifelines, selected options) are encapsulated in a single immutable data class emitted via `StateFlow`.
- **One-Time Event Channel (`GameUiEvent`):** Ephemeral UI interactions (result dialogs, phone hint alerts, audience statistics, quit prompts) are dispatched via buffered Kotlin Coroutines `Channel` and consumed as a `SharedFlow`, preventing duplicate dialog executions during configuration changes.
- **Lifecycle-Aware Collection:** Fragments consume flows using `viewLifecycleOwner.lifecycleScope` bound to `repeatOnLifecycle(Lifecycle.State.STARTED)`.

### 2.3. Audio & Haptics Engine (`core/audio/` & `core/haptics/`)
- **SoundPool Audio:** Short sound effects (`correct_answer`, `wrong_answer`) are preloaded into hardware-accelerated `SoundPool` buffers, completely eliminating `MediaPlayer` native memory leaks and playback latency.
- **Targeted Haptic Feedback:** Vibrations are handled via `VibratorManager` (API 31+) and fallback `Vibrator` with one-shot `VibrationEffect` payloads.

### 2.4. Data Persistence Layer (`data/local/PreferencesRepository.kt`)
- Encapsulates SharedPreferences with strict key namespacing.
- Synchronously reads and asynchronously writes (`apply()`) player profile stats (`bestScore`, `totalWinnings`, `gamesPlayed`, `lastPlayedDate`) and user preferences (`backgroundTheme`, `language`, `soundEnabled`, `vibrationEnabled`).

---

## 3. Data Flow Diagram

```text
[User Interaction] 
       │ 
       ▼
[Fragment Action] ──> [GameViewModel.submitAnswer()]
                             │
                             ├─ Evaluates Correctness
                             ├─ Updates PreferencesRepository
                             ├─ Emits Updated GameUiState
                             └─ Sends One-Time GameUiEvent (Sound/Haptic/Dialog)
                                         │
       ┌─────────────────────────────────┴─────────────────────────────────┐
       ▼                                                                   ▼
[StateFlow Collector]                                             [Event Collector]
Updates TextViews & Button Colors                                  Displays Material Dialog
```
