# Answer It

Answer It is a multilingual Android trivia game inspired by "Who Wants to Be a Millionaire?".

## Features

- 15-question progression with increasing difficulty
- Lifelines: 50:50, Phone a Friend, Ask the Audience
- 14 supported languages
- Language-aware question set and prize formatting
- Player profile and game result screens
- Theme and preference settings (sound/vibration)

## Tech Stack

- Kotlin
- Android Views + ViewBinding
- MVVM (ViewModel + LiveData)
- Android Navigation Component
- Gradle (Kotlin DSL)

## Requirements

- Android Studio (latest stable)
- Android SDK installed and configured
- JDK 17+

## Quick Start

```bash
git clone https://github.com/Sopwit/Answer-it.git
cd Answer-it
```

1. Open the project in Android Studio.
2. Ensure your `local.properties` points to a valid Android SDK.
3. Sync Gradle and run on an emulator or device.

A template is provided as `local.properties.example`.

## Project Structure

```text
app/
  src/main/java/com/example/answerit/      # Fragments, ViewModel, app classes
  src/main/java/com/example/answerit/data/ # Models and repositories
  src/main/res/                            # Layouts, drawables, strings, raw assets
.github/
  workflows/                               # CI pipeline
  ISSUE_TEMPLATE/                          # Issue templates
```

## Localization

The project includes string resources for:

- Turkish (`tr`)
- English (`en`)
- Chinese (`zh`)
- Spanish (`es`)
- Arabic (`ar`)
- German (`de`)
- French (`fr`)
- Russian (`ru`)
- Hindi (`hi`)
- Japanese (`ja`)
- Korean (`ko`)
- Portuguese (`pt`)
- Vietnamese (`vi`)
- Italian (`it`)

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) for branch naming, PR rules, and review expectations.

## Security

Please report vulnerabilities through [SECURITY.md](SECURITY.md).

## License

MIT License. See [LICENSE](LICENSE).
