from flask import Flask
from werkzeug.utils import escape

from cnn_tsm.cnn_mnist import CNNMnist

app = Flask(__name__)
cnn = CNNMnist()


@app.route('/')
def index():
    return "Image Recognition server!"


@app.route('/getNumberFromImage/<string:imageName>')
def getNumberFromImage(imageName):
    print(f"input: {imageName}")

    return cnn.getNumberFromImage(imageName)


if __name__ == "__main__":
    app.run()
