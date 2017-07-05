package br.com.qualquer.reactivelogin.repository

import io.reactivex.Single

class SignUpRepositoryImpl : SignUpRepository {

    override fun firstAuth(): Single<String> = Single.just("auth1")

    override fun secondAuth(): Single<String> = Single.just("auth2")

}