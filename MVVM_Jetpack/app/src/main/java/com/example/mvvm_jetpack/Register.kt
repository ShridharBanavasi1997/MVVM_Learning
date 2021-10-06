package com.example.mvvm_jetpack

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mvvm_jetpack.ui.theme.Shapes

@Preview(showSystemUi = true)
@Composable
fun RegisterPage(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMsg by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Register",color = Color.Blue,fontSize = 30.sp, fontWeight = FontWeight.Bold,modifier = Modifier.offset(x=100.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            shape = Shapes.medium,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            shape = Shapes.medium,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        if (errorMsg.isNotEmpty()) {
            Text(text = " *$errorMsg", color = Color.Red, fontSize = 8.sp, modifier = Modifier.offset(x=100.dp))
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 4.dp, shape = RectangleShape),
            shape = Shapes.medium

        ) {
            Text(text = "Register", color = Color.White)
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Login",
            modifier = Modifier.clickable {
                navController.navigate("loginPage")
            })


    }

}