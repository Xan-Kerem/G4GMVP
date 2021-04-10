package com.cefer.g4gmvp.presenter

import com.cefer.g4gmvp.contract.Contract

class Presenter(private var mainView: Contract.View?, private val model: Contract.Model) :
    Contract.Presenter, Contract.Model.OnFinishedListener {

    override fun onButtonClick() {

        mainView?.showProgress()

        model.getNextCourse(this)
    }

    override fun onDestroy() {
        mainView = null
    }

    // method to return the string
    // which will be displayed in the
    // Course Detail TextView
    override fun onFinished(string: String?) {
        mainView?.let { mv ->
            mv.setString(string)
            mv.hideProgress()
        }
    }

}