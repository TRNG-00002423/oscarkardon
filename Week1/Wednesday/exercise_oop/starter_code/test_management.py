class TestCase:
    """Represents a single test case.

    Class Attributes:
        total_created (int): Count of all TestCase objects ever created

    
    Instance Attributes:
        name (str): Test name (e.g., "test_login_valid")
        description (str): What this test verifies
        priority (str): "high", "medium", or "low" (default: "medium")
        tags (list): Labels like ["smoke", "regression"]
    """
    total_created = 0

    def __init__(self, name, description, priority="medium", tags=None):
        self.name = name
        self.description = description
        self.priority = priority
        self.tags = tags
        TestCase.total_created += 1


    def run(self):
        """Simulate running the test. Return True for pass, False for fail.
        For now, use: return "fail" not in self.name
        """
        return "fail" not in self.name

    @classmethod
    def from_dict(cls, data):
        """Create a TestCase from a dictionary.
        Example: TestCase.from_dict({"name": "test_login", "priority": "high"})
        """
        return cls(data["name"], data.get("description"), data.get("priority", data.get("tags")))

    @staticmethod
    def is_valid_name(name):
        """Check if name starts with 'test_' and has no spaces."""
        if name[:5] == "test_" and " " not in name:
            return True
        return False
    

class TestResult:
    """The outcome of running a single test.

    Instance Attributes:
        test_name (str): Which test was run
        status (str): "pass" or "fail"
        duration_ms (float): How long it took
        error_message (str or None): Error details if failed
    """
    def __init__(self, test_name, status, duration_ms, error_message):
        self.test_name = test_name
        self.status = status
        self.duration_ms = duration_ms
        self.error_message = error_message

    def summary(self):
        """Return a one-line summary like: '✅ test_login (120ms)'"""
        if self.status == "pass":
            return f"✅ {self.test_name} ({self.duration_ms}ms)"
        else:
            return f"X {self.test_name} ({self.duration_ms}ms)"
        

class TestSuite:
    """A collection of test cases.

    Instance Attributes:
        name (str): Suite name
        tests (list): List of TestCase objects

    Methods:
        add_test(test): Add a TestCase
        remove_test(name): Remove by name
        get_by_priority(priority): Return tests matching the priority
        count(): Return number of tests
    """
    def __init__(self, name, tests):
        self.name = name
        self.tests = tests
    
    def add_test(self, test):
        self.tests.append(test)
    
    def remove_test(self, name):
        self.tests = [test for test in self.tests if test.name != name]

    def get_by_priority(self, priority):
        return [test for test in self.tests if test.priority == priority]
    
    def count(self):
        return len(self.tests)
    
    def __len__(self):
        return len(self.tests)

    
    
class TestRunner:
    """Executes a TestSuite and collects results.

    Methods:
        run(suite): Run all tests in a suite, return list of TestResult
        summary(results): Print a formatted summary
    """

    def run(self, suite):
        """Run each test in the suite and return a list of TestResults."""
        import time
        import random
        results = []
        for test in suite.tests:
            start = time.time()
            passed = test.run()
            duration = (time.time() - start) * 1000
            # Simulate varying duration
            duration += random.uniform(50, 500)
            result = TestResult(
                test.name,
                "pass" if passed else "fail",
                round(duration, 1),
                None if passed else f"{test.name} assertion failed"
            )
            results.append(result)
        return results
    
    def summary(self, results):
        for result in results:
            print(result.summary())


def main():
    test1 = TestCase("test_login", "Test Login")
    test2 = TestCase("test_security", "Check security", "high", "security")
    test3 = TestCase("TestAccess", "Check access")
    test4= TestCase("Test API", "Test the APIs")
    testFail = TestCase("failTest", "This test should Fail")
    test5 = TestCase.from_dict({
        "name": "test_data",
        "priority": "high"})
    test6 = TestCase.from_dict({
        "name": "TestF1",
        "priority": "low"})
    
    testSuite = TestSuite("testSuite", [test1, test2, test3, test4, test5, test6, testFail])

    high_priority_tests = testSuite.get_by_priority("high")
    print("High priority tests:")
    for test in high_priority_tests:
        print(test.name)
    
    runner = TestRunner()
    results = runner.run(testSuite)
    print("Test Summaries")
    runner.summary(results)
    print(f"Length of test suite: {len(testSuite)}")


if __name__ == "__main__":
    main()