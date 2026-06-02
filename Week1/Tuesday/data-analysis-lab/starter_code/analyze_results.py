import pandas as pd
df = pd.read_csv("test_data.csv")


print("Total tests:", len(df))
print("Columns:", list(df.columns))
print ("First 5 rows:")
print(df.head())



print("══════════════════════════════════════")
print("  Test Results Analysis")
print("══════════════════════════════════════")

print("Total tests:", len(df))
pass_rate = (df["status"] == "pass").sum() / len(df) * 100
print("Pass rate:", pass_rate, "%")
avg_duration = df["duration_ms"].mean()
print("Avg duration:", avg_duration, "ms", (f"{avg_duration/1000:.2f}s"))
slowest_test = df.loc[df["duration_ms"].idxmax()]
print("Slowest:", slowest_test["test_name"], f"({slowest_test['duration_ms']}ms)")
fastest_test = df.loc[df["duration_ms"].idxmin()]
print("Fastest:", fastest_test["test_name"], f"({fastest_test['duration_ms']}ms)")

print("── By Module ──")
print(f"{'Module':<16} {'Tests':<6} {'Pass Rate':<6} {'Avg Duration':<6}")
for module, group in df.groupby("module"):
    mod_pass_rate = (group["status"] == "pass").sum() / len(group) * 100
    mod_avg_duration = group["duration_ms"].mean()
    print(f"{module:<16} {len(group):<6} {mod_pass_rate:<6.1f}%  {mod_avg_duration:<6.0f}ms")



print("── Failed Tests ──")
failed_tests = df[df["status"] == "fail"]
for _, row in failed_tests.iterrows():
    print(f"{row['test_name']:<20}{row['module']:<8} {row['duration_ms']}ms")

print("── Slow Tests ──")
slow_tests = df[df["duration_ms"] > 1500]
for _, row in slow_tests.iterrows():
    print(f"{row['test_name']:<22}{row['module']:<8} {row['duration_ms']}ms")

print("── Auth Tests ──")
auth_tests = df[df["module"] == "auth"]
for _, row in auth_tests.iterrows():
    print(f"{row['test_name']:<20}{row['module']:<8} {row['duration_ms']}ms")


for _, row in df.iterrows():
    row.duration_sec = row.duration_ms / 1000

df.sort_values("duration_ms", ascending=False, inplace=True)
df.to_csv("output/results_sorted.csv", index=False)