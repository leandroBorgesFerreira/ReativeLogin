package br.com.qualquer.reactivelogin.signup

import br.com.qualquer.reactivelogin.repository.SignUpRepository
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.zipWith

class SignUpPresenter(val signUpView: SignUpContract.View, val signUpRepository : SignUpRepository) :
        SignUpContract.Presenter {


    override fun login() {
        signUpRepository.firstAuth().zipWith(signUpRepository.secondAuth(), {
            firstAuth, secondAuth -> Pair(firstAuth, secondAuth)
        }).subscribeBy(
                onSuccess = {
                    signUpView.showRequest("primeiro: ${it.first} segundo: ${it.second}")
                }
        )
    }
}

