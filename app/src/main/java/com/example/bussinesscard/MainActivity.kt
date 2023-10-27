package com.example.bussinesscard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinesscard.ui.theme.BussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BussinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            AboutCard(
                avatar = painterResource(R.drawable.avatar_bagas),
                fullName = "Bagas Yusuf Gunawan",
                title = "Full Stack Programmer"
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            ContactInfoCard(
                iconPhone = Icons.Outlined.Phone,
                phoneNumber = "+6282249861409",
                iconGithub = Icons.Outlined.Share,
                githubName = "bgsygnwan",
                iconEmail = Icons.Outlined.Email,
                emailAddress = "bagasysf@gmail.com"
            )
        }
    }
}

@Composable
private fun AboutCard(
    avatar: Painter,
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = avatar,
            contentDescription = null,
            modifier = Modifier
                .height(144.dp)
                .clip(shape = CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = fullName,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = title,
            modifier = Modifier
        )
    }
}

@Composable
private fun ContactInfoCard(
    iconPhone: ImageVector,
    phoneNumber: String,
    iconGithub: ImageVector,
    githubName: String,
    iconEmail: ImageVector,
    emailAddress: String,
    ) {
    Column(
        horizontalAlignment = Alignment.Start,
    ) {
        ItemInfo(
            icon = iconPhone,
            info = phoneNumber
        )
        ItemInfo(
            icon = iconGithub,
            info = githubName
        )
        ItemInfo(
            icon = iconEmail,
            info = emailAddress
        )
    }
}

@Composable
private fun ItemInfo(
    icon: ImageVector,
    info: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(bottom = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
            )
            Spacer(
                modifier = Modifier
                    .padding(start = 16.dp)
            )
            Text(
                text = info,
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BussinessCardTheme {
        BusinessCardApp()
    }
}