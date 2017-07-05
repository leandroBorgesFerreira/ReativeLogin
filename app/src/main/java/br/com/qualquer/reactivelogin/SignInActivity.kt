package br.com.qualquer.reactivelogin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.com.qualquer.reactivelogin.repository.SignUpRepositoryImpl
import br.com.qualquer.reactivelogin.signup.SignUpContract
import br.com.qualquer.reactivelogin.signup.SignUpPresenter
import com.jakewharton.rxbinding2.widget.textChanges
import io.reactivex.rxkotlin.combineLatest
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity(), SignUpContract.View {

    var presenter : SignUpContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        presenter = SignUpPresenter(this, SignUpRepositoryImpl())

        name.textChanges().combineLatest(lastName.textChanges())
                .map { "Olá: ${it.first} ${it.second}" }
                .subscribeBy(onNext = {
                    hello.text = it
                })

        btnEnter.setOnClickListener { buttonClicked() }
    }

    override fun buttonClicked() {
        presenter?.login()
    }

    override fun showRequest(message : String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
