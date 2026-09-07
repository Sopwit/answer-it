# Localization & Internationalization Guide

Answer It features full end-to-end localization across 14 languages for questions, answers, UI strings, dialogs, and currency formatting.

---

## 1. Supported Languages

| Code | Language | Display Name | Currency Symbol | Sample Format |
| :--- | :--- | :--- | :--- | :--- |
| `tr` | Turkish | Türkçe | ₺ | `₺1,000,000` |
| `en` | English | English | $ | `$1,000,000` |
| `zh` | Chinese | 中文 | ¥ | `¥1,000,000` |
| `es` | Spanish | Español | € | `€1,000,000` |
| `ar` | Arabic | العربية | ر.س | `ر.س1,000,000` |
| `de` | German | Deutsch | € | `€1,000,000` |
| `fr` | French | Français | € | `€1,000,000` |
| `ru` | Russian | Русский | ₽ | `₽1,000,000` |
| `hi` | Hindi | हिन्दी | ₹ | `₹1,000,000` |
| `ja` | Japanese | 日本語 | ¥ | `¥1,000,000` |
| `ko` | Korean | 한국어 | ₩ | `₩1,000,000` |
| `pt` | Portuguese | Português | R$ | `R$1,000,000` |
| `vi` | Vietnamese | Tiếng Việt | ₫ | `₫1,000,000` |
| `it` | Italian | Italiano | € | `€1,000,000` |

---

## 2. Dynamic Language Management

The application manages language switching at runtime via `LanguageManager` (`data/local/LanguageManager.kt`):
- Updates `Locale.setDefault()` and configuration metrics.
- Re-queries `QuestionRepository` with the target `Language` enum to load localized question sets without restarting the application.
- Persists user language choice in `PreferencesRepository`.

---

## 3. Adding a New Language

1. Add the new entry to `data/model/Language.kt`:
   ```kotlin
   DUTCH("nl", "Nederlands", "€")
   ```
2. Create the localized string resource file:
   `app/src/main/res/values-nl/strings.xml`
3. Add the localized question and options entries to `data/repository/QuestionRepository.kt`.
