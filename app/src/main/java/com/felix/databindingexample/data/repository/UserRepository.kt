package com.felix.databindingexample.data.repository

import com.felix.databindingexample.data.model.User

/**
 * Created by Felix on 06/04/2018.
 */

class UserRepository {
    // CALL ASYNC TASK AND SAVE IN DB
    fun validadeUser(user: User): Boolean = !(user.userName == "" || user.password == "")
    fun registerUser(user: User): Boolean = !(user.birthDay == null || user.name == "" || user.userName == "" || user.password == "")
}
