package com.circleappsstudio.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.circleappsstudio.jetpackcomposesample.ui.Dimensions
import com.circleappsstudio.jetpackcomposesample.ui.MediaQuery
import com.circleappsstudio.jetpackcomposesample.ui.ProfileScreen
import com.circleappsstudio.jetpackcomposesample.ui.lessThan
import com.circleappsstudio.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme
import com.circleappsstudio.jetpackcomposesample.ui.theme.LightGreen3
import com.circleappsstudio.jetpackcomposesample.ui.theme.LightRed
import kotlinx.coroutines.delay
import kotlin.math.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(
                text = "I'm only shown below a width of 400dp",
                modifier = Modifier
                    .background(Color.Green)
                    .mediaQuery(
                        Dimensions.Width lessThan 400.dp,
                        modifier = Modifier.size(300.dp)
                    )
            )
        }
    }
}

/*@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun TestingPreview() {

}*/