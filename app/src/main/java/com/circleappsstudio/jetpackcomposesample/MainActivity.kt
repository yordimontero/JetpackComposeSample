package com.circleappsstudio.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
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

/*var i = 0

@Composable
private fun Test(
    backPressedDispatcher: OnBackPressedDispatcher
) {

    val callback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Do something...
            }
        }
    }

    DisposableEffect(key1 = backPressedDispatcher) {
        backPressedDispatcher.addCallback(callback)
        onDispose {
            callback.remove()
        }
    }

    Button(onClick = { /*TODO*/ }) {
        Text(text = "Click me!")
    }
    
}*/

@Composable
private fun Test() {

    val scaffoldState = rememberScaffoldState()

    // Create coroutine scope to using suspend functions in Composable
    // PD: Should only launch coroutines in callbacks like OnClick {...}
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState
    ) {

        val counter = produceState(initialValue = 0) {
            kotlinx.coroutines.delay(3000L)
            value = 4
        }

        /*var counter by remember {
            mutableStateOf(0)
        }*/

        if (counter.value % 5 == 0 && counter.value > 0) {

            LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
                scaffoldState.snackbarHostState.showSnackbar("Counter is divisible in 5")
            }

        }

        /*if (counter % 5 == 0 && counter > 0) {
            // Execute suspend functions in Composable using scope.launch {...}

            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Counter is divisible in 5")
            }

        }*/

        Button(
            onClick = {}
        ) {
            Text(text = "Counter: ${counter.value}")
        }

        /*Button(
            onClick = {
                counter++
            }
        ) {
            Text(text = "Counter: $counter")
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