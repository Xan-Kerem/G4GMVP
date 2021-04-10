package com.cefer.g4gmvp.contract

interface Contract {

    interface View {

        fun showProgress()

        fun hideProgress()

        // method to set random
        // text on the TextView
        fun setString(string: String?)

    }

    interface Model {

        interface OnFinishedListener {
            // fun to be called once
            // the Handler of Model class
            // completes its execution
            fun onFinished(string: String?)
        }

        fun getNextCourse(onFinishedListener: OnFinishedListener?)

    }

    interface Presenter {
        // to be called when the button is clicked
        fun onButtonClick()

        // method to be destroy lifecycle of MainActivity
        fun onDestroy()
    }
}