from flask import Flask, request, jsonify

app = Flask(__name__)


# @app.route("/student", methods=['GET', 'POST'])
@app.get("/student")
def student():
    data = {
        "id": 1,
        "name": "Oscar",
        "course": "Python"
    }

    return jsonify(data)


@app.get("/students")
def students():
    data = [
        {"id": 1, "name": "Oscar", "course": "Python"},
        {"id": 2, "name": "Kardon", "course": "Python"},
    ]

    return jsonify(data)

if __name__ == "__main__":
    app.run(debug=True)