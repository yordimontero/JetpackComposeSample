package com.circleappsstudio.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test()
        }
    }
}

data class User(
    val name: String = "",
    val age: Int = 0
)

val userList = listOf(
    User(
        "Juan",
        25
    ),
    User(
        "Luis",
        19
    ),
    User(
        "María",
        32
    )
)

@Composable
private fun Test() {

    LazyColumn {

        itemsIndexed(
            userList
        ) { index, item ->

            Text(
                text = "#$index: ${item.name}, ${item.age}",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
                    .background(Color.DarkGray),
                color = Color.White
            )

        }

        /*items(5000) {

            Text(
                text = "Item: $it",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
                    .background(Color.DarkGray),
                color = Color.White
            )

        }*/

    }

}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun TestingPreview() {

}