from flask import Flask, render_template, request, redirect, session
import random

app = Flask(__name__)
app.secret_key = "secret_key"


@app.route("/")
def index():

    if "number" not in session:
        session["number"] = random.randint(1, 100)
        session["message"] = ""
        session["color"] = ""
        session["attempts"] = 0

    return render_template("index.html")


@app.route("/guess", methods=["POST"])
def guess():

    user_guess = int(request.form["guess"])
    session["attempts"] += 1

    if user_guess < session["number"]:
        session["message"] = "Too low!"
        session["color"] = "red"

    elif user_guess > session["number"]:
        session["message"] = "Too high!"
        session["color"] = "red"

    else:
        session["message"] = f"{session['number']} was the number!"
        session["color"] = "green"

    return redirect("/")


@app.route("/reset")
def reset():
    session.clear()
    return redirect("/")


if __name__ == "__main__":
    app.run(debug=True)