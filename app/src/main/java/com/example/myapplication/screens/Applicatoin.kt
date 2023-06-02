import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R

import com.example.myapplication.ui.theme.MyApplicationTheme


@Composable
fun ApplicationScreen(navController: NavHostController) {
    val app = getAppData() // Получите данные приложения из вашего источника данных

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // 1 уровень: Название приложения с картинкой и кнопкой "Скачать"
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = app.name,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = { /* Обработка нажатия кнопки "Скачать" */ },
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(text = "Скачать")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 2 уровень: Картинки с горизонтальной прокруткой
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
        ) {
            items(app.imageResIds) { imageResId ->
                Image(
                    painter = painterResource(imageResId),
                    contentDescription = app.name,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 3 уровень: Описание приложения
        Text(
            text = app.description,
            style = TextStyle(
                fontSize = 18.sp
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 4 уровень: Версии приложения
        Column {
            app.versions.forEach { version ->
                Button(
                    onClick = { /* Обработка нажатия на версию приложения */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = version)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

data class App(
    val name: String,
    val imageResIds: List<Int>,
    val description: String,
    val versions: List<String>
)

fun getAppData(): App {
    // Здесь вам нужно получить данные приложения из вашего источника данных
    return App(
        name = "Название приложения",
        imageResIds = listOf(
            R.drawable.image_1,
            R.drawable.image_1,
            R.drawable.image_1
        ),
        description = "Описание приложения",
        versions = listOf(
            "Версия 1.0",
            "Версия 2.0",
            "Версия 3.0"
        )
    )
}

@Preview(showBackground = true)
@Composable
fun prevApplicationScreen() {
    MyApplicationTheme {
        ApplicationScreen(navController = rememberNavController())
    }
}
