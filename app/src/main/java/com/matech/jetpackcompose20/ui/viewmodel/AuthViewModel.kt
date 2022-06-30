package com.matech.jetpackcompose20.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel

class AuthViewModel: ViewModel() {

    val emailValue =   mutableStateOf("")
    val passwordValue =  mutableStateOf("")

    fun onEmailInputChanged(newEmailValue:String){
        this.emailValue.value = newEmailValue
    }
    fun onPasswordInputChanged(newPasswordValue:String){
        this.passwordValue.value = newPasswordValue
    }
}