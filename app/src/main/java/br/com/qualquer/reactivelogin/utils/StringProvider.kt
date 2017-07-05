package br.com.qualquer.reactivelogin.utils

import android.support.annotation.StringRes

interface StringProvider {
    fun getString(@StringRes resId: Int): String
}
