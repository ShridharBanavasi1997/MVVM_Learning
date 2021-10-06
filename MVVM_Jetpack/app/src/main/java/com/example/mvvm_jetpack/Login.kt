package com.example.mvvm_jetpack

import android.graphics.drawable.shapes.RectShape
import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import android.text.TextUtils
import android.util.Patterns
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mvvm_jetpack.ui.theme.Shapes
@Composable
fun LoginPage(navController: NavController,loginViewModel: LoginViewModel = viewModel()) {
    val email:String by loginViewModel.email.observeAsState("")
    val password:String by loginViewModel.password.observeAsState("")
    val errorMsg by loginViewModel.errMsg.observeAsState("")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Login",
            color = Color.Blue,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(x = 100.dp)
        )
        inputHolder(value = email,label = "Email",onValueChange = {loginViewModel.onEmailChange(it)})
        Spacer(modifier = Modifier.height(10.dp))
        inputHolder(value = password,label = "Password",onValueChange = {loginViewModel.onPasswordChange(it)})
        Spacer(modifier = Modifier.height(10.dp))
        if (errorMsg.isNotEmpty()) {
            Text(
                text = " *$errorMsg",
                color = Color.Red,
                fontSize = 8.sp,
                modifier = Modifier.offset(x = 100.dp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                      if(loginViewModel.onSubmit()){
                          navController.navigate("homePage")
                      }
            },
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 4.dp, shape = RectangleShape),
            shape = Shapes.medium

        ) {
            Text(text = "Login", color = Color.White)
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Register",
            modifier = Modifier.clickable {
                navController.navigate("registerPage")
            })


    }

}

@Composable
fun inputHolder(value:String,label:String,onValueChange:(String)->Unit){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "$label") },
        shape = Shapes.medium,
        modifier = Modifier.fillMaxWidth()
    )
}

