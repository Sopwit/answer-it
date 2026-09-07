# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [0.0.1] - 2026-09-08

### 🚀 Added
- **250 Categorized Trivia Questions:** Expanded question bank across 8 domains (History, Geography, Science, Pop Culture, Cinema, Literature, Sports, Art) categorized into 4 difficulty tiers (*Easy*, *Medium*, *Hard*, *Expert*).
- **Dynamic Session Selection:** Randomized progressive question selection mechanism in `GameViewModel` ensuring fresh game sessions every round.
- **5 Premium Visual Themes:**
  - `Dark Minimalist` (Default sleek dark surface)
  - `Midnight Glow` (Deep navy with neon cyan highlights)
  - `Deep Forest` (Emerald green organic palette)
  - `Royal Purple` (Luxury violet & amethyst tones)
  - `Monochrome` (Ultra-high contrast grayscale)
- **Dedicated Theme Fragment:** Dedicated screen for previewing and switching background themes dynamically.
- **Full 14-Language Localization (i18n):** Complete localized string resources across 115 keys for:
  - English (`en`), Turkish (`tr`), German (`de`), Spanish (`es`), French (`fr`), Italian (`it`), Portuguese (`pt`), Russian (`ru`), Arabic (`ar` with RTL), Chinese (`zh`), Japanese (`ja`), Korean (`ko`), Hindi (`hi`), and Vietnamese (`vi`).
- **Legal Compliance Suite:** In-app User Agreement (`UserAgreementFragment`) and Privacy Policy (`PrivacyPolicyFragment`) accessible via Settings.
- **Dynamic Lifeline Feedback:** Distinct highlight (elevated + high-contrast icon/text) and consumed state (dimmed `0.38f` opacity + disabled + darkened surface) for all 3 lifelines (50:50, Phone a Friend, Ask the Audience).
- **Custom Vector Iconography:** Replaced all system fallback drawables with custom, scalable vector assets (`ic_trophy`, `ic_refresh`, `ic_logout`, `ic_settings`, etc.).
- **Automated CI/CD Workflow:** GitHub Actions pipeline (`.github/workflows/android-ci.yml`) compiling debug/release artifacts with JDK 17 and Android SDK 36.

### 🎨 Changed
- **Edge-to-Edge Experience:** Removed default system Toolbar / ActionBar across all fragments for a clean, immersive full-screen presentation.
- **Typography & Visual Hierarchy:** Standardized headline, body, and button typography with enhanced letter spacing and contrast ratios.
- **Settings & Profile UI:** Refactored settings menu with clean navigation cards, clear version metadata, and accessible language selectors.

### 🐛 Fixed
- Fixed button layout clipping, overlap, and wrapping issues on small screens in `GameFragment` and `ResultFragment`.
- Fixed CI environment crash caused by machine-specific Java home paths in `gradle.properties`.
- Fixed theme color inconsistency on answer buttons, dialog surfaces, and lifeline cards across all 5 themes.

---

[0.0.1]: https://github.com/Sopwit/answer-it/releases/tag/v0.0.1
