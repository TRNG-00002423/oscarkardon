test1_name, test1_duration, test1_status = "test_login", 1200, "✅ PASS"
test2_name, test2_duration, test2_status = "test_search", 850, "✅ PASS"
test3_name, test3_duration, test3_status = "test_checkout", 2300, "❌ FAIL"
test4_name, test4_duration, test4_status = "test_profile", 450, "✅ PASS"
test5_name, test5_duration, test5_status = "test_logout", 180, "✅ PASS"

total_duration = test1_duration + test2_duration + test3_duration + test4_duration + test5_duration

passed = sum([
    test1_status == "✅ PASS",
    test2_status == "✅ PASS",
    test3_status == "✅ PASS",
    test4_status == "✅ PASS",
    test5_status == "✅ PASS"
])

print("┌──────────────────┬────────────┬──────────┐")
print(f"│ {'Test Name':<16} │ {'Duration':<10} │ {'Status':<8} │")
print("├──────────────────┼────────────┼──────────┤")

print(f"│ {'test_login':<16} │ {1200:>7,} ms │ {'✅ PASS':<7} │")
print(f"│ {'test_search':<16} │ {850:>7,} ms │ {'✅ PASS':<7} │")
print(f"│ {'test_checkout':<16} │ {2300:>7,} ms │ {'❌ FAIL':<7} │")
print(f"│ {'test_profile':<16} │ {450:>7,} ms │ {'✅ PASS':<7} │")
print(f"│ {'test_logout':<16} │ {180:>7,} ms │ {'✅ PASS':<7} │")

print("├──────────────────┼────────────┼──────────┤")
print(f"│ {'TOTAL':<16} │ {4980:>7,} ms │ {'4/5 Pass':<8} │")
print("└──────────────────┴────────────┴──────────┘")