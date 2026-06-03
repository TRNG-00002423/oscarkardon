def validate_password(password):
    returnDict = {
        "is_valid": True,
        "errors": []
    }
    if len(password) < 8:
        returnDict["is_valid"] = False
        returnDict["errors"].append("Password must be at least 8 characters long")
    if not any(char.isupper() for char in password):
        returnDict["is_valid"] = False
        returnDict["errors"].append("Password must contain at least one uppercase letter")
    if not any(char.islower() for char in password):
        returnDict["is_valid"] = False
        returnDict["errors"].append("Password must contain at least one lowercase letter")
    if not any(char.isdigit() for char in password):
        returnDict["is_valid"] = False
        returnDict["errors"].append("Password must contain at least one digit")
    if not any(char in "!@#$%^&*()-_=+[]{}|;:,.<>?/" for char in password):
        returnDict["is_valid"] = False
        returnDict["errors"].append("Password must contain at least one special character")
    return returnDict


print(validate_password("Abc123!x") )   # valid
print(validate_password("abc") )         # too short, no upper, no digit, no special
print(validate_password("ABCDEFGH") )    # no lower, no digit, no special
print(validate_password("ABCDefgh1!") )  # valid
