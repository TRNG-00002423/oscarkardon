from flask import Flask, request, jsonify

app = Flask(__name__)

students = []
id_tracker = 0

@app.get("/students")
def get_students():
    return jsonify(students)

@app.get("/student/<int:id>")
def student(id):
    for student in students:
        if student["id"] == id:
            return jsonify(student)
    return "Error: student not found"


@app.post("/students")
def add_student():
    global id_tracker
    data = request.json
    students.append({
        "id": id_tracker,
        "name": data["name"],
        "course": data["course"]
    })
    id_tracker += 1
    return "201 Created"

@app.put("/students/<int:id>")
def update_student(id):
    data = request.json
    for student in students:
        if student["id"] == id:
            student["name"] = data["name"]
            student["course"] = data["course"]
            return "201 Created"
    return "Error: student not found"

@app.delete("/students/<int:id>")
def delete_student(id):
    for student in students:
        if student["id"] == id:
            students.remove(student) 
            return "Student deleted successfully"
    return "Error: student not found"
 
if __name__ == "__main__":
    app.run(debug=True)