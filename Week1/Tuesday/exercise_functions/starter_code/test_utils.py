def format_test_name(name):
    """Convert a human-readable name to a test function name.

    Example:
        format_test_name("Valid Login") → "test_valid_login"
        format_test_name("  Search Results Page  ") → "test_search_results_page"

    Rules:
        - Lowercase
        - Spaces replaced with underscores
        - Leading/trailing whitespace stripped
        - Prefixed with "test_"
    """
    name = name.strip().lower().replace(" ", "_")
    return f"test_{name}"


def is_valid_test_name(name):
    """Check if a string is a valid test function name.

    Rules:
        - Must start with "test_"
        - Must contain only lowercase letters, digits, and underscores
        - Must be at least 6 characters (e.g., "test_x")

    Returns: bool
    """
    if not name[0:5] == "test_":
        return False
    for char in name[5:]:
        if not (char.islower() or char.isdigit() or char == "_"):
            return False
    if len(name) < 6:
        return False
    return True

assert format_test_name("Valid Login") == "test_valid_login"
assert format_test_name("  Search Results  ") == "test_search_results"
assert is_valid_test_name("test_login") == True
assert is_valid_test_name("login_test") == False
assert is_valid_test_name("test_") == False

def create_test_result(name, status="pass", duration_ms=0, error=None):
    """Create a test result dictionary.

    Args:
        name: Test name (required)
        status: "pass" or "fail" (default: "pass")
        duration_ms: Execution time in ms (default: 0)
        error: Error message if failed (default: None)

    Returns:
        dict with keys: name, status, duration_ms, error
    """
    dict_result = {
        "name": name,
        "status": status,
        "duration_ms": duration_ms,
        "error": error
    }
    return dict_result


def format_duration(ms, unit="ms"):
    """Format a duration value with the specified unit.

    Args:
        ms: Duration in milliseconds
        unit: "ms", "s", or "min" (default: "ms")

    Returns:
        Formatted string like "1,200ms" or "1.20s" or "0.02min"
    """
    if unit == "ms":
        return f"{ms:,}ms"
    elif unit == "s":
        seconds = ms / 1000
        return f"{seconds:.2f}s"
    elif unit == "min":
        minutes = ms / 60000
        return f"{minutes:.2f}min"
    


r1 = create_test_result("test_login")
assert r1 == {"name": "test_login", "status": "pass", "duration_ms": 0, "error": None}

r2 = create_test_result("test_checkout", status="fail", duration_ms=2300, error="Timeout")
assert r2["status"] == "fail"
assert r2["error"] == "Timeout"

assert format_duration(1200) == "1,200ms"
assert format_duration(1200, "s") == "1.20s"


def calculate_stats(*scores):
    """Calculate statistics for any number of scores.

    Returns:
        dict with keys: count, total, average, min, max

    Raises:
        ValueError if no scores provided
    """
    count = len(scores)
    total = sum(scores)
    average = total / count 
    min_score = min(scores)
    max_score = max(scores)
    return {
        "count": count,
        "total": total,
        "average": average,
        "min": min_score,
        "max": max_score
    }


def build_test_config(**settings):
    """Build a test configuration with defaults.

    Default config:
        browser: "chrome"
        headless: False
        timeout: 30
        retries: 0
        base_url: "http://localhost:3000"

    Any **settings passed override the defaults.

    Returns: dict
    """
    default_config = {
        "browser": "chrome",
        "headless": False,
        "timeout": 30,
        "retries": 0,
        "base_url": "http://localhost:3000"
    }
    default_config.update(settings)
    return default_config

stats = calculate_stats(85, 92, 78, 95, 88)
assert stats["count"] == 5
assert stats["average"] == 87.6
assert stats["min"] == 78
assert stats["max"] == 95

config = build_test_config(headless=True, timeout=60)
assert config["browser"] == "chrome"  # default
assert config["headless"] == True     # overridden
assert config["timeout"] == 60       # overridden


def analyze_results(*results):
    """Analyze a list of test result dicts.

    Args:
        *results: test result dicts (from create_test_result)

    Returns:
        tuple of (passed_count, failed_count, pass_rate, avg_duration)
    """
    passed_count = sum(1 for r in results if r["status"] == "pass")
    failed_count = sum(1 for r in results if r["status"] == "fail")
    pass_rate = (passed_count / len(results)) * 100 
    avg_duration = sum(r["duration_ms"] for r in results) / len(results)
    return (passed_count, failed_count, pass_rate, avg_duration)



def generate_report(*results):
    """Generate a formatted test report string.

    Calls analyze_results() internally and formats the output.

    Returns: formatted multi-line string
    """
    passed, failed, rate, avg = analyze_results(*results)
    report = f"""Test Report:
    Total: {passed + failed}
    Passed: {passed}    
    Failed: {failed}
    Pass Rate: {rate:.2f}%
    Avg Duration: {format_duration(avg)}"""
    return report


results = [
    create_test_result("test_login", "pass", 1200),
    create_test_result("test_search", "pass", 850),
    create_test_result("test_checkout", "fail", 2300, "Timeout"),
    create_test_result("test_profile", "pass", 450),
]

passed, failed, rate, avg = analyze_results(*results)
assert passed == 3
assert failed == 1
assert rate == 75.0

generated_report = generate_report(*results)
print("Tests passed")
print(generated_report)
