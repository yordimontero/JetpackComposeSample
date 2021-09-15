package com.circleappsstudio.jetpackcomposesample.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.circleappsstudio.jetpackcomposesample.R

@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(
            name = "another_instagram_user",
            Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
    }

}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Notifications",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_dot_menu),
            contentDescription = "Menu",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )

    }

}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxWidth()) {
        
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {

            RoundImage(
                image = painterResource(
                    id = R.drawable.images
                ),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            StatSection(modifier = Modifier.weight(7f))

        }
        
    }

}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {

    Image(
        painter = image,
        contentDescription = "Image",
        modifier = modifier
            .aspectRatio(
                ratio = 1f,
                matchHeightConstraintsFirst = true
            )
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )

}

@Composable
fun StatSection(
    modifier: Modifier = Modifier
) {
    
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(
            numberText = "601",
            text = "Posts"
        )
        ProfileStat(
            numberText = "100K",
            text = "Followers"
        )
        ProfileStat(
            numberText = "800",
            text = "Following"
        )
    }
    
}

@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = text)

    }

}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: String
) {

    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {

        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

    }

}