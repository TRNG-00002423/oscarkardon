print("═══════════════════════════════════════")
print("  QA Test Metrics Calculator")
print("═══════════════════════════════════════")


test_cases = int(input("Enter total test cases: "))
passed_cases = int(input("Enter passed tests: "))
execution_time = float(input("Enter total execution time (seconds): "))

print("───────────────────────────────────────")
print("  Test Results Summary")
print("───────────────────────────────────────")

print(f"Total Tests: {test_cases}")
print(f"Passed: {passed_cases}")
failed_cases = test_cases - passed_cases
print(f"Failed: {failed_cases}")
pass_rate = (passed_cases / test_cases) * 100
print(f"Pass Rate: {pass_rate}%")
fail_rate = (failed_cases / test_cases) * 100
print(f"Fail Rate: {fail_rate}%")
average_test_time = execution_time / test_cases
print(f"Avg Time/Test: {average_test_time:.2f}s")
print(f"Total Time: {execution_time}s")

print('')
if pass_rate >= 95:
    print("Verdict: ✅ RELEASE APPROVED")
elif pass_rate >= 80:
    print("Verdict: ⚠️ CONDITIONAL RELEASE — review failures")
else:
    print("Verdict: ❌ RELEASE BLOCKED — too many failures")

print("═══════════════════════════════════════")
