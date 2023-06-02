package com.example.myapplication.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.NavRoute
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun StartScreen(navController: NavHostController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Вход",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            val emailState = remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            val passwordState = remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                label = { Text("Пароль") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                          navController.navigate(route = NavRoute.Main.route)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Войти")
            }

            Button(
                onClick = {
                    navController.navigate(route = NavRoute.Registration.route)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Зарегистрироваться")
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun prevStartScreen(){
    MyApplicationTheme{
        StartScreen(navController = rememberNavController())

    }
}
