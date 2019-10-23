from cnn_tsm.cnn_mnist import CNNMnist

predictArray = ['one.jpg',
                'two.jpg',
                'three.jpg',
                'four.jpg'
                ]


cnn= CNNMnist()
assert cnn.getNumberFromImage(predictArray[0])=='1'

assert cnn.getNumberFromImage(predictArray[2])=='3'

assert cnn.getNumberFromImage(predictArray[1])=='2'
assert cnn.getNumberFromImage(predictArray[3])=='4'

