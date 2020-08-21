from flask import Flask, redirect, url_for
from markupsafe import escape
app = Flask(__name__)

@app.route('/')
def home():
    return 'Home Page'

@app.route('/user/<username>')
def user(username):
    return 'Hello, %s' % escape(username)

@app.route('/admin')
def admin():
    return redirect(url_for('user', username='Admin!'))

if __name__ == '__main__':
    app.run()