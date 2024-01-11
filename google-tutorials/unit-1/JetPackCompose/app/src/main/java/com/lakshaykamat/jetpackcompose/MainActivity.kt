package com.lakshaykamat.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.lakshaykamat.jetpackcompose.ui.theme.JetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    ) {
                        val image = painterResource(id = R.drawable.bg_compose_background)
                        ArticleImage(imagePainter = image, imageDescription = R.string.image_description)
                        ArticleText(
                            headingLineID = R.string.title_jetpack_compose_tutorial,
                            shortDescription = R.string.compose_short_desc,
                            longDescription = R.string.compose_long_desc
                        )
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 32.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            OutlinedButton(
                                onClick = { /*TODO*/ },
                            ) {
                                Text(text = "Previous")
                            }
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = "Next")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ArticleImage(imagePainter: Painter, imageDescription:Int){
    Image(painter = imagePainter, contentDescription = stringResource(id = imageDescription))
}
@Composable
fun ArticleText(@StringRes headingLineID: Int, shortDescription: Int, longDescription: Int) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(id = headingLineID),
            modifier = Modifier.padding(top = 16.dp, bottom = 32.dp),
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = stringResource(id = shortDescription),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(id = longDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}