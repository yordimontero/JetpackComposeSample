package com.circleappsstudio.jetpackcomposesample

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.circleappsstudio.jetpackcomposesample.ui.*
import com.circleappsstudio.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme
import com.circleappsstudio.jetpackcomposesample.ui.theme.LightGreen3
import com.circleappsstudio.jetpackcomposesample.ui.theme.LightRed
import kotlinx.coroutines.delay
import kotlin.math.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                color = Color(0xFF212121),
                modifier = Modifier.fillMaxSize()
            ) {
                MainNavigation()
            }
        }
    }

}


@Composable
fun MainNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {

        composable(route = "splash_screen") {
            SplashScreenTest(navController = navController)
        }

        composable(route = "main_screen") {
            MainScreenTest()
        }

    }

}

@Composable
fun SplashScreenTest(navController: NavController) {

    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate(route = "main_screen") {
            popUpTo("splash_screen") {
                inclusive = true
            }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.hong_kong),
            contentDescription = "Icon",
            modifier = Modifier.scale(scale.value)
        )

    }
    
}

@Composable
fun MainScreenTest() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hi!",
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

/*@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun TestingPreview() {

}*/