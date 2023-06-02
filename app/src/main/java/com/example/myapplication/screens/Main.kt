package com.example.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.navigation.NavRoute
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun TopBar() {
    TopAppBar(
        backgroundColor = Color.White,
        elevation = 4.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "HackStore",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
        }
    }
}

@Composable
fun SearchBar() {
    var search = remember { mutableStateOf(TextFieldValue()) }
    OutlinedTextField(
        value = search.value,
        onValueChange = {search.value = it},
        placeholder = {
            Text(text = "Поиск")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun MainScreen(navController: NavHostController) {
    val apps = generateAppList()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar()
        SearchBar()
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(apps) { app ->
                AppListItem(app = app, navController = navController)
                Divider()
            }
        }
    }
}

@Composable
fun AppListItem(app: App, navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                navController.navigate(NavRoute.Application.route)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(app.iconResId),
            contentDescription = app.name,
            modifier = Modifier.size(64.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = app.name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = app.category,
                style = TextStyle(
                    fontSize = 14.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /* Обработка нажатия кнопки */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Установить")
            }
        }
    }
}

data class App(
    val name: String,
    val category: String,
    val iconResId: Int
)

fun generateAppList(): List<App> {
    return listOf(
        App("App 1", "Категория 1", R.drawable.image_1),
        App("App 2", "Категория 2", R.drawable.image_1),
        App("App 3", "Категория 3", R.drawable.image_1),
        App("App 4", "Категория 1", R.drawable.image_1),
        App("App 5", "Категория 2", R.drawable.image_1),
        App("App 6", "Категория 3", R.drawable.image_1),
        App("App 7", "Категория 1", R.drawable.image_1),
        App("App 8", "Категория 2", R.drawable.image_1),
        App("App 9", "Категория 3", R.drawable.image_1),
        App("App 10", "Категория 4", R.drawable.image_1)
    )
}

@Preview(showBackground = true)
@Composable
fun prevMainScreen() {
    MyApplicationTheme {
        MainScreen(navController = rememberNavController())
    }
}
