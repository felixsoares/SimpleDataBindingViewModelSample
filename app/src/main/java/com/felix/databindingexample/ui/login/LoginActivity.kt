package com.felix.databindingexample.ui.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.felix.databindingexample.R
import com.felix.databindingexample.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        val dataBinding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        dataBinding.login = loginViewModel

        loginViewModel.successLogin.observe(this, Observer {
            if (it!!) {
                Handler().postDelayed({
                    finish()
                }, 350)
            }
        })

        setupToolbar()
    }

    private fun setupToolbar() {
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->
                finish()
        }
        return true
    }
}
