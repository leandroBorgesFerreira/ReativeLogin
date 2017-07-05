package br.com.qualquer.reactivelogin.signup

interface SignUpContract {
    interface View {
        fun buttonClicked()
        fun showRequest(message : String)
    }

    interface Presenter {
        fun login()
    }
}