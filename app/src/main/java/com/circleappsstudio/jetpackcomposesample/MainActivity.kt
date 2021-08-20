package com.circleappsstudio.jetpackcomposesample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.circleappsstudio.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

private lateinit var composeView: ComposeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        composeView = findViewById(R.id.composeView)

        composeView.setContent {
            JetpackComposeSampleTheme {
                SampleColumnList(sampleList = sampleList)
            }
        }
    }
}

data class SampleItem(
    @DrawableRes val imageResource: Int,
    val title: String,
    val items: List<String>
)

val sampleList = listOf(

    SampleItem(
        R.mipmap.ic_launcher,
        "Title 1",
        listOf(
            "Item 1",
            "Item 2",
            "Item 3"
        )
    ),

    SampleItem(
        R.mipmap.ic_launcher,
        "Title 2",
        listOf(
            "Item 4",
            "Item 5",
            "Item 6"
        )
    ),

    SampleItem(
        R.mipmap.ic_launcher,
        "Title 3",
        listOf(
            "Item 7",
            "Item 8",
            "Item 9"
        )
    ),

    SampleItem(
        R.mipmap.ic_launcher,
        "Title 4",
        listOf(
            "Item 10",
            "Item 11",
            "Item 12"
        )
    ),

    SampleItem(
        R.mipmap.ic_launcher,
        "Title 5",
        listOf(
            "Item 13",
            "Item 14",
            "Item 15"
        )
    )

)

@Composable
private fun SampleCard(sampleItem: SampleItem, onItemClick: (SampleItem) -> Unit) {

    val image = painterResource(id = R.mipmap.header)

    Card (
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onItemClick(sampleItem)
            }
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            val imageModifier = Modifier
                .requiredHeight(150.dp)
                .fillMaxWidth()
                .clip(
                    shape = RoundedCornerShape(8.dp)
                )

            Image(
                painter = image,
                contentDescription = "SampleImage",
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )

            Spacer(
                modifier = Modifier.padding(
                    top = 10.dp
                )
            )

            Text(
                text = sampleItem.title,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            for (item in sampleItem.items) {

                Text(
                    text = "- $item",
                    style = MaterialTheme.typography.h5
                )

            }

        }

    }

}

@Composable
private fun SampleColumnList(sampleList: List<SampleItem>) {

    // Creating Vertical List:

    LazyColumn {
        items(sampleList) { sampleItem ->
            SampleCard(sampleItem = sampleItem, onItemClick = {
                Log.wtf("TAG", it.title)
            })
        }
    }

}

@Composable
private fun SampleRowList(sampleList: List<SampleItem>) {

    // Creating Horizontal List:

    LazyRow {
        items(sampleList) { sampleItem ->
            SampleCard(sampleItem = sampleItem, onItemClick = {
                Log.wtf("TAG", it.title)
            })
        }
    }

}

@Preview(
    name = "SampleCard",
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun PreviewRecipeCard() {
    SampleCard(sampleItem = sampleList[0], onItemClick = {})
}