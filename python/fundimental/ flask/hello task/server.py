from flask import Flask , render_template
app = Flask(__name__)

@app.route('/')
def hello_world():
    return "hello wolrld!"


@app.route('/aws')
def hello_world1():
    return "hello aws!"


@app.route('/abdallah')
def hello_world2():
    return "hello abdallah!"

@app.route('/maaty')
def hello_world3():
    return render_template("index.html") 

if __name__=="__main__":
    app.run (debug=True)