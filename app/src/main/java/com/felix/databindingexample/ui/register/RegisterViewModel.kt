package com.felix.databindingexample.ui.register

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.felix.databindingexample.R
import com.felix.databindingexample.data.model.User
import com.felix.databindingexample.data.repository.UserRepository
import java.text.SimpleDateFormat

/**
 * Created by Felix on 06/04/2018.
 */

class RegisterViewModel : ViewModel() {

    // BUSINES LOGIC FROM REGISTER PAGE

    val message = ObservableField<String>("")
    var color = ObservableField<Int>(android.R.color.black)
    val successRegister = MutableLiveData<Boolean>()

    var name = ""
    var birthday = ""
    var username = ""
    var password = ""

    private val userRepository = UserRepository()

    fun register() {
        val user = User()
        user.name = name
        user.userName = username
        user.password = password

        try {
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            user.birthDay = sdf.parse(birthday)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val success = userRepository.registerUser(user)

        message.set(if (success) "User ok" else "User not ok")
        color.set(if (success) R.color.success else R.color.error)

        successRegister.value = success
    }
}
