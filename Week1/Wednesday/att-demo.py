class Employee:
    company = "Revature" #Class Attribute
    emp_count = 0
    def __init__(self, name, role):
        self.name = name #Instance Attribute
        self.role = role
        Employee.emp_count += 1

    @classmethod
    def admin(cls, name):
        return cls(name, "Admin")

emp1 = Employee("Oscar", "QA Engineer")
print(emp1.name)

emp2 = Employee("Cody", "QA Engineer")
print(emp2.name)

print(emp1.company)
print(emp2.company)

print(emp1.emp_count)
print(emp2.emp_count)
print(Employee.emp_count)

emp3 = Employee.admin("Jasdhir")
print(emp3.name)
print(emp3.role)