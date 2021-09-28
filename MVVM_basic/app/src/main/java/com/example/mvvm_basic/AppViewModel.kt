package com.example.mvvm_basic

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import java.util.*

class AppViewModel: BaseObservable() {
    private var dataModel:DataModel= DataModel("","","")

    private val successMessage:String = "Login successful"
    private val errorMessage:String = "Email or Password is not valid"

    var toastMessage: String?
        @Bindable get() =dataModel.message
        set(value) {
            dataModel.message = value
            notifyPropertyChanged(BR.toastMessage)
        }


    var userEmail: String?
        @Bindable get() = dataModel.email
        set(value) {
            dataModel.email = value
            notifyPropertyChanged(BR.userEmail)
        }

    var userPassword: String?
        @Bindable get() = dataModel.password
        set(value) {
            dataModel.password = value
            notifyPropertyChanged(BR.userEmail)
        }

    fun AppViewModel() {
        dataModel = DataModel("","","")
    }

    fun onButtonClicked() {
        if (isValid())
            toastMessage=successMessage;
        else
            toastMessage=errorMessage;
    }

    fun isValid():Boolean {
        return !TextUtils.isEmpty(userEmail) && Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()
                && userPassword!!.length > 5
    }


}