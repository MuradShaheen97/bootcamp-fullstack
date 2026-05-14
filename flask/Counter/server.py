from flask import Flask, render_template, session, redirect, request

app = Flask(__name__)

app.secret_key = "secret_key"


@app.route('/')
def index():

    if 'count' not in session:
        session['count'] = 0

    session['count'] += 1

    return render_template("index.html")


@app.route('/add_two')
def add_two():

    session['count'] += 2

    return redirect('/')


@app.route('/reset')
def reset():

    session.clear()

    return redirect('/')


@app.route('/custom', methods=['POST'])
def custom():

    number = int(request.form['number'])

    session['count'] += number - 1

    return redirect('/')


if __name__ == "__main__":
    app.run(debug=True)