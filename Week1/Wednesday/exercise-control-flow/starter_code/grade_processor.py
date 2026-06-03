#scores = [88, 92, 75, -1, 63, 95, 81, 70, -5, 55, 100, 78, -999, 90, 85]
import pandas as pd
scores = pd.read_csv("grade_processor_file.csv")
valid_scores = []
grades = []

for index, score in enumerate(scores["score"]):
    if score == -999:
        print("Sentinel value encountered. Stopping processing.")
        break
    elif score < 0:
        print(f"Invalid negative score: {score}")
        continue
    else:
        valid_scores.append(score)
        if score >= 90:
            grades.append("A")
        elif score >= 80:
            grades.append("B")
        elif score >= 70:
            grades.append("C")
        elif score >= 60:
            grades.append("D")
        else:
            grades.append("F")
        print(f"Score {score} is a(n) {grades[-1]}")


for grade in grades:
    print(grade)

print(f"Class average grade: {sum(valid_scores) / len(valid_scores):.2f}")
print(f"Best grade: {max(valid_scores)}")
print(f"Worst grade: {min(valid_scores)}")

grade_counts = {"A": 0, "B": 0, "C": 0, "D": 0, "F": 0}
for grade in grades:
    grade_counts[grade] += 1

print("Grade distribution:")
for grade, count in grade_counts.items():
    print(f"{grade}'s: {count}")