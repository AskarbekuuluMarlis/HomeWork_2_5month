package com.example.hw_2_5month


interface LoveContract {

    interface View {
        fun showResult(result: LoveModel)
        fun showError(message: String)
    }
    interface Presenter {
        fun getPercentage(firstName: String, secondName: String)
    }
}