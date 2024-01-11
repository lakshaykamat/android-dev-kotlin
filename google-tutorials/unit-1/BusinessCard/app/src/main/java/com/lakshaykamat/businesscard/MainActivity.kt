package com.lakshaykamat.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lakshaykamat.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(.85f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier.size(120.dp),
                            painter = painterResource(id = R.drawable.android_logo),
//                            contentScale = ContentScale.Fit,
                            contentDescription = "Android Logo"
                        )
                        Text(text = "Lakshay Kamat", style = MaterialTheme.typography.headlineLarge)
                        Text(
                            text = "Android Developer",
                            style = MaterialTheme.typography.headlineSmall,
                            color = Color(0xFF3ddc84)
                        )
                    }

                    Column(
//                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier
                            .fillMaxWidth().fillMaxHeight()
                            .border(BorderStroke(2.dp, Color.Black))
                            .padding(vertical = 16.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ShareIcon(
                            icon = Icons.Filled.Call,
                            iconDescription = "Call",
                            text = "(91) 9958125355"
                        )
                        ShareIcon(
                            icon = Icons.Filled.Share,
                            iconDescription = "share",
                            text = "@lakshaykamat"
                        )
                        ShareIcon(
                            icon = Icons.Filled.Email,
                            iconDescription = "email",
                            text = "lakshay@kamat.com"
                        )
                    }

                }
            }
        }
    }

    @Composable
    fun ShareIcon(icon: ImageVector, iconDescription: String, text: String) {
        Row(

            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = icon,
                contentDescription = iconDescription,
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = text,
                modifier = Modifier.fillMaxWidth(.5f)
            )
        }
    }
}