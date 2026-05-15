from flask import Flask, render_template

app = Flask(__name__)

@app.route('/play')
def play(x=4):
    return render_template("index.html",x=int(x))

@app.route('/play/<x>')
def add(x=3,colors = "Aqua"):
    return render_template("index.html",x=int(x),colors=str(colors))

@app.route('/play/<x>/<colors>')
def color(x=3,colors="green"):
    return render_template("index.html",x=int(x),colors=str(colors))


if __name__ == "__main__":
    app.run(debug=True)