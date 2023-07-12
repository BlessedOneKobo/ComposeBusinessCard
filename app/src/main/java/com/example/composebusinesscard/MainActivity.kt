package com.example.composebusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebusinesscard.ui.theme.ComposeBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun UserBioSection(fullName: String, jobTitle: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color(0xFF073042)),
        )
        Spacer(modifier.size(8.dp))
        Text(
            text = fullName,
            fontSize = 40.sp,
        )
        Spacer(modifier.size(12.dp))
        Text(
            text = jobTitle,
            color = Color(0xFF3ddc84),
        )
    }
}

@Composable
fun UserContactSection(modifier: Modifier = Modifier) {
    val spacingDp = 16.dp

    Column {
        ContactInformation(
            icon = Icons.Default.Phone,
            text = "+11 (123) 444 555 666",
            modifier = modifier.padding(bottom = spacingDp)
        )
        ContactInformation(
            icon = Icons.Default.Share,
            text = "@AndroidDev",
            modifier = modifier.padding(bottom = spacingDp),
        )
        ContactInformation(
            icon = Icons.Default.Email,
            text = "jen.doe@android.com",
        )
    }
}

@Composable
fun ContactInformation(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3ddc84),
        )
        Spacer(modifier.size(16.dp))
        Text(
            text = text,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    ComposeBusinessCardTheme {
        UserBioSection(fullName = "Jennifer Doe", jobTitle = "Android Developer Extraordinaire")
    }
}