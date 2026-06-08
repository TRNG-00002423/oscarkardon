from flask import Flask, request

app = Flask(__name__)


@app.route("/")
def home():
    return "Hello Flask"

@app.route("/about")
def about():
    return "About Page"

@app.route("/contact")
def contact():
    return "Contact Page"


@app.route("/user/<name>")
def user_name(name):
    return f"Hello {name}!"

@app.route("/add/<int:num1>/<int:num2>")
def sum(num1, num2):
    return str(num1 + num2)


@app.route("/user1")
def user1_name():
    name = request.args.get("name")
    job = request.args.get("job")
    return f"Hello {name}, he is {job}!"


if __name__ == "__main__":
    app.run(debug=True)