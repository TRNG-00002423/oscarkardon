test_results = [
    {"name": "test_login", "module": "auth", "duration_ms": 1200, "status": "pass"},
    {"name": "test_register", "module": "auth", "duration_ms": 2100, "status": "pass"},
    {"name": "test_logout", "module": "auth", "duration_ms": 300, "status": "pass"},
    {"name": "test_search", "module": "search", "duration_ms": 850, "status": "fail"},
    {"name": "test_filter", "module": "search", "duration_ms": 1800, "status": "fail"},
    {"name": "test_sort", "module": "search", "duration_ms": 670, "status": "pass"},
    {"name": "test_add_cart", "module": "checkout", "duration_ms": 2300, "status": "fail"},
    {"name": "test_payment", "module": "checkout", "duration_ms": 3100, "status": "pass"},
    {"name": "test_confirm", "module": "checkout", "duration_ms": 1900, "status": "pass"},
    {"name": "test_view_profile", "module": "profile", "duration_ms": 380, "status": "pass"},
    {"name": "test_edit_profile", "module": "profile", "duration_ms": 540, "status": "pass"},
    {"name": "test_settings", "module": "profile", "duration_ms": 420, "status": "fail"},
]

print("Sort by Duration")
print(sorted(test_results, key=lambda u: u["duration_ms"]))

print("Sort by Module, Duration")
print(sorted(test_results, key=lambda u: (u["module"], u["duration_ms"])))

print("Sort by Status, Name")
print(sorted(test_results, key=lambda u: (u["status"] != "fail", u["name"])))

# Extract just the test names → ["test_login", "test_register", ...]
names = list(map(lambda x: x["name"], test_results))
print("Just names:")
print(names)
# Get failures → all results where status is "fail"
failures = list(filter(lambda x: x["status"] == "fail", test_results))
print("Failures:")
print(failures)
# Slow tests → results where duration > 1500ms
slow = list(filter(lambda x: x["duration_ms"] > 1500, test_results))
print("Slow:")
print(slow)
# Transform → create a list of summary strings: "✅ test_login (1200ms)" or "❌ test_search (850ms)"
print("Summaries:")
print(list(map(lambda x: f"{"✅" if x["status"] == "pass" else "❌"} {x["name"]} ({x["duration_ms"]}ms)", test_results) ))
# Module names → unique set of module names using map + set
unique_modules = set(map(lambda x: x["module"], test_results))
print(unique_modules)

from functools import reduce
# Total duration of all tests.
print(reduce(lambda total, x: total + x["duration_ms"], test_results, 0))
# Total failure time (sum of durations for failed tests only).
print(reduce(lambda total, x: total + x["duration_ms"] if x["status"] == "fail" else total + 0, test_results, 0))
# Longest test name (by character count).
print(reduce(lambda longest, x: x["name"] if len(x["name"]) > len(longest) else longest, test_results))
# Build a module summary dict
module_summary = reduce(lambda module, x: 
                        {**module, x["module"]:  module.get(x["module"], 0) + 1},
                          test_results, {})
print(module_summary)

# Given two parallel lists, combine them:
# Use zip() to compare expected vs. actual and print pass/fail for each.

# Unzip the test_results into separate lists: names, modules, durations, statuses.

# Create a dict mapping test names to durations using zip.
endpoints = ["/login", "/search", "/checkout", "/profile"]
expected_codes = [200, 200, 201, 200]
actual_codes = [200, 500, 201, 403]

combined = zip(endpoints, expected_codes, actual_codes)
for endpoint, expected, actual in combined:
    if expected == actual:
        print("pass")
    else:
        print("fail")


names, modules, durations, statuses = zip(*[
    (
        test["name"],
        test["module"],
        test["duration_ms"],
        test["status"]
    )
    for test in test_results
])

names_to_durations = dict(zip(names, durations))
print(names_to_durations)