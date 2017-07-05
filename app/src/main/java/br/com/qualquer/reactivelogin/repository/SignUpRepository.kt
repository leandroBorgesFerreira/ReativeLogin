package br.com.qualquer.reactivelogin.repository

import io.reactivex.Single

interface SignUpRepository {
    fun firstAuth() : Single<String>
    fun secondAuth() : Single<String>
}