from flask import Flask, render_template, request
from datetime import datetime

app = Flask(__name__)


@app.route('/')
def fruits():
    return render_template("fruits.html")


@app.route('/checkout', methods=['POST'])
def checkout():

    strawberries = int(request.form['strawberry'])
    raspberries = int(request.form['raspberry'])
    apples = int(request.form['apple'])

    total_fruits = strawberries + raspberries + apples

    name = request.form['name']
    student_id = request.form['student_id']

    print(f"Charging {name} for {total_fruits} fruits")

    current_time = datetime.now().strftime("%B %d %Y %I:%M %p")

    return render_template(
        "checkout.html",
        strawberries=strawberries,
        raspberries=raspberries,
        apples=apples,
        total=total_fruits,
        name=name,
        student_id=student_id,
        time=current_time
    )


if __name__ == "__main__":
    app.run(debug=True)