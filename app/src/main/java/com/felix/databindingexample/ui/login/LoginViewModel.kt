package com.felix.databindingexample.ui.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.felix.databindingexample.R
import com.felix.databindingexample.data.model.User
import com.felix.databindingexample.data.repository.UserRepository

/**
 * Created by Felix on 06/04/2018.
 */

class LoginViewModel : ViewModel() {

    // BUSINES LOGIC FROM LOGIN PAGE

    var title = "LoginViewModel"
    var username = ""
    var password = ""

    var message = ObservableField<String>()
    var color = ObservableField<Int>(android.R.color.black)
    val successLogin = MutableLiveData<Boolean>()

    private val repository = UserRepository()

    fun login() {
        val user = User()
        user.userName = username
        user.password = password

        val success: Boolean = repository.validadeUser(user)

        message.set(if (success) "User ok" else "User not ok")
        color.set(if (success) R.color.success else R.color.error)

        successLogin.value = success
    }
}
