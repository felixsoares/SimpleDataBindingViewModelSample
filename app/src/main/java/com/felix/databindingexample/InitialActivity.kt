package com.felix.databindingexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.felix.databindingexample.ui.login.LoginActivity
import com.felix.databindingexample.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_initial.*

class InitialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)

        btnLogin.setOnClickListener({
            changePage(Intent(this, LoginActivity::class.java))
        })

        btnRegister.setOnClickListener({
            changePage(Intent(this, RegisterActivity::class.java))
        })
    }

    private fun changePage(intent: Intent) {
        startActivity(intent)
    }
}
