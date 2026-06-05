import pandas as pd

s = pd.Series([10, 20, 30, 40])
# print(s)

data ={
    "Name":["Ken", "Jon", "Audy"],
    "Age":[29, 28, 29],
    "Marks":[86, 87, 90]
}

df = pd.DataFrame(data)
# print(df)
# print(df.info())

high_marks = df[df["Marks"] > 86]
print(high_marks)

df["Passed"] = df["Marks"] > 87
print(df)