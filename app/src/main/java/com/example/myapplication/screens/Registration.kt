package com.example.myapplication.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.navigation.NavRoute


@Composable
fun RegistrationScreen (navController: NavHostController){
// Состояния полей ввода
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Регистрация",
            style = MaterialTheme.typography.h4
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text(text = "Пароль") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = confirmPasswordState.value,
            onValueChange = { confirmPasswordState.value = it },
            label = { Text(text = "Подтвердите пароль") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Обработка нажатия кнопки "Зарегистрироваться" */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Зарегистрироваться")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Уже есть аккаунт?",
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { navController.navigate(route = NavRoute.Start.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Войти")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegistrationScreen() {
    MyApplicationTheme {
        RegistrationScreen(navController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun prevRegistrationScreen(){
    MyApplicationTheme{
        RegistrationScreen(navController = rememberNavController())

    }
}
