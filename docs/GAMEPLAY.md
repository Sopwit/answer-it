# Gameplay Mechanics & Progression

Answer It implements the classic progressive ladder trivia format inspired by *"Who Wants to Be a Millionaire?"*.

---

## 1. Prize Progression & Safe Havens

The game consists of 15 questions divided into 4 distinct difficulty tiers. Two **Safe Havens (Checkpoints)** guarantee the player's winnings once reached:

| Question # | Difficulty | Question Prize | Safe Haven Guarantee |
| :---: | :---: | :---: | :---: |
| **1** | Easy | 100 | 0 |
| **2** | Easy | 200 | 0 |
| **3** | Easy | 300 | 0 |
| **4** | Easy | 500 | 0 |
| **5** | **Easy** | **1,000** | **1,000 (Safe Haven #1)** |
| **6** | Medium | 2,000 | 1,000 |
| **7** | Medium | 4,000 | 1,000 |
| **8** | Medium | 8,000 | 1,000 |
| **9** | Medium | 16,000 | 1,000 |
| **10** | **Medium** | **32,000** | **32,000 (Safe Haven #2)** |
| **11** | Hard | 64,000 | 32,000 |
| **12** | Hard | 125,000 | 32,000 |
| **13** | Hard | 250,000 | 32,000 |
| **14** | Expert | 500,000 | 32,000 |
| **15** | **Expert** | **1,000,000** | **1,000,000 (Grand Prize)** |

---

## 2. Lifelines (Jokers)

Each game session grants three one-time lifelines:

1. ✂️ **50:50 (`fiftyFifty`):** Randomly removes two incorrect options from the UI, leaving the correct answer and one remaining distractor.
2. 📞 **Phone a Friend (`phoneFriend`):** Simulates a virtual advisor providing a hinted answer.
3. 👥 **Ask the Audience (`audienceHelp`):** Generates randomized crowd polling statistics with a weighted bias (45%–70%) toward the correct answer.

---

## 3. Quit & Safe Departure

Players can choose to walk away at any question via the **Quit** button or hardware back button. Walking away awards the player their current Safe Haven guarantee without penalty.
