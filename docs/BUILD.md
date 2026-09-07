# Build & Deployment Guide

This document covers toolchain prerequisites, Gradle commands, version catalogs, ProGuard/R8 optimization, and release build workflows.

---

## 1. Prerequisites

- **JDK:** OpenJDK 17 or higher
- **Android SDK:** API Level 34+ (Build Tools 36.0.0, Platform API 36)
- **Gradle:** 8.13 (Managed via Gradle Wrapper `./gradlew`)
- **Android Gradle Plugin (AGP):** 8.13.0
- **Kotlin:** 1.9.22

---

## 2. Environment Configuration

Copy the example properties file and specify your local Android SDK location:

```bash
cp local.properties.example local.properties
```

Edit `local.properties`:
```properties
sdk.dir=/path/to/your/Android/Sdk
```

---

## 3. Gradle Version Catalog (`gradle/libs.versions.toml`)

All dependencies and plugins are centrally versioned in `gradle/libs.versions.toml`. To update a library or plugin version, edit the `[versions]` table in this file.

---

## 4. Build Commands

### Debug Compilation & Verification
```bash
# Compile debug sources
./gradlew compileDebugKotlin

# Assemble Debug APK (outputs to app/build/outputs/apk/debug/)
./gradlew :app:assembleDebug
```

### Release Build with R8 / ProGuard Shrinking
```bash
# Assemble optimized Release APK
./gradlew :app:assembleRelease
```

R8 code shrinking, unused resource stripping (`isShrinkResources = true`), and ProGuard bytecode optimizations are configured in `app/build.gradle.kts` and `app/proguard-rules.pro`.

GitHub Releases must contain artifacts produced by the **Signed Android Release** workflow. It requires repository secrets named `ANDROID_KEYSTORE_BASE64`, `ANDROID_KEYSTORE_PASSWORD`, `ANDROID_KEY_ALIAS`, and `ANDROID_KEY_PASSWORD`. Keep the keystore and every secret out of the repository.

---

## 5. Testing & Code Quality

```bash
# Run unit test suite
./gradlew test

# Run Android Lint analysis
./gradlew lint
```
