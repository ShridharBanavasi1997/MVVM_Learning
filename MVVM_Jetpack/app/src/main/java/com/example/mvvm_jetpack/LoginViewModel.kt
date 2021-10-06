package com.example.mvvm_jetpack

import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData("")
    private val _password = MutableLiveData("")
    private val _msg = MutableLiveData("")
    var email: LiveData<String> = _email
    var password: LiveData<String> = _password
    var errMsg: LiveData<String> = _msg

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun onSubmit():Boolean {
        if (TextUtils.isEmpty(_email.value) || !Patterns.EMAIL_ADDRESS.matcher(_email.value)
                .matches()
        ) {
            _msg.value = "Check email"
            return false;
        } else if (_password.value!!.length < 5) {
            _msg.value = "Check password"
            return false;
        }else{
            return true;
        }
    }

}