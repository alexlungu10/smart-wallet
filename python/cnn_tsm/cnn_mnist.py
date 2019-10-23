from pathlib import Path

from keras.layers import Conv2D, MaxPooling2D, Flatten, Dense
from keras.models import Sequential, model_from_json

from keras.datasets import mnist
from keras.utils import to_categorical
from keras.preprocessing import image

import matplotlib.pyplot as plt
import numpy as np


# %matplotlib inline

class CNNMnist():
    def getNumberFromImage(self, imageName):
        # 1 Load Data
        size = 100
        (X_train, y_train), (X_test, y_test) = mnist.load_data()
        plt.imshow(X_train[0], cmap='gray')

        # 2 Preprocess
        img_width, img_height = 28, 28
        X_train = X_train.reshape(60000, img_width, img_height, 1)
        X_test = X_test.reshape(10000, img_width, img_height, 1)
        # print(X_train.shape)
        # print(X_test.shape)

        X_train = X_train.astype('float32')
        X_train /= 255.0

        y_train = to_categorical(y_train, num_classes=10)
        y_test = to_categorical(y_test, num_classes=10)

        # 3 Build Model
        model = Sequential()
        model.add(Conv2D(filters=64, kernel_size=(5, 5), input_shape=(28, 28, 1), padding='same', activation='relu'))
        model.add(MaxPooling2D())
        model.add(Conv2D(filters=128, kernel_size=(5, 5), padding='same', activation='relu'))
        model.add(MaxPooling2D())
        model.add(Flatten())
        model.add(Dense(1024, activation='relu'))
        model.add(Dense(10, activation='softmax'))

        # Model
        model.compile(optimizer='adam', loss='categorical_crossentropy', metrics=['accuracy'])
        # model.summary()

        # Train
        # history = model.fit(X_train, y_train, epochs=2, validation_data=(X_test, y_test))

        # Save trained model
        # jsonModel=model.to_json()
        # Path("jsonModel.json").write_text(jsonModel)
        modelWeightsName = "modelWeights64-128.h5"
        # model.save_weights(modelWeightsName)

        # Load trained model
        model.load_weights(modelWeightsName)

        def loadImageAndPrepareData(imageName):
            oneImg = image.load_img(path=imageName, target_size=(28, 28), color_mode='grayscale')
            vector = image.img_to_array(oneImg)
            return vector / 255.0

        # predictArray = ['images/one.jpg',
        #                 'images/two.jpg',
        #                 'images/three.jpg',
        #                 'images/four.jpg',
        #                 'images/six.jpg',
        #                 'images/seven.jpg',
        #                 'images/eight.jpg',
        #                 'images/nine.jpg']
        # print(f"array size to predict: {len(predictArray)}")
        #
        # result = model.predict_classes(
        #     np.array(
        #         [loadImageAndPrepareData(predictArray[0]), loadImageAndPrepareData(predictArray[1]),
        #          loadImageAndPrepareData(predictArray[2]),
        #          loadImageAndPrepareData(predictArray[3])
        #             , loadImageAndPrepareData(predictArray[4]), loadImageAndPrepareData(predictArray[5]),
        #          loadImageAndPrepareData(predictArray[6]),
        #          loadImageAndPrepareData(predictArray[7])
        #          ]))
        # print(result)

        result = model.predict_classes(np.array([loadImageAndPrepareData('images/' + imageName)]))
        print(result)
        return str(result[0])
