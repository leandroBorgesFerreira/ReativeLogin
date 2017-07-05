package br.com.qualquer.reactivelogin

import br.com.qualquer.reactivelogin.repository.SignUpRepository
import br.com.qualquer.reactivelogin.signup.SignUpContract
import br.com.qualquer.reactivelogin.signup.SignUpPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class PresenterTest {


    @Mock
    lateinit var view : SignUpContract.View

    @Mock
    lateinit var signUpRepository : SignUpRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun shouldLoginCorrectly() {
        val presenter = SignUpPresenter(view, signUpRepository)

        presenter.login()

        Mockito.verify(signUpRepository).firstAuth()
        Mockito.verify(signUpRepository).secondAuth()
    }

    @Test
    fun shouldCallViewOnSuccess() {
        val presenter = SignUpPresenter(view, signUpRepository)

        presenter.login()

        Mockito.verify(view).showRequest(Mockito.anyString())
    }
}