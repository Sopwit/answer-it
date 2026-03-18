# Contributing Guide

## Branch Naming

Use one of the following formats:

- `feature/<short-description>`
- `fix/<short-description>`
- `chore/<short-description>`

## Commit Messages

Prefer clear, imperative commits:

- `fix: handle italian locale restore`
- `chore: add android ci workflow`

## Pull Requests

- Keep PRs focused and small.
- Include a short problem statement and solution summary.
- Add screenshots/GIFs for UI changes.
- Mention testing steps and results.

## Coding Standards

- Keep Kotlin code readable and null-safe.
- Reuse string resources, avoid hardcoded UI text.
- Avoid machine-specific files in commits (`local.properties`, IDE files).

## Testing

Before opening a PR:

```bash
./gradlew :app:assembleDebug
```

If you add tests:

```bash
./gradlew test
```
