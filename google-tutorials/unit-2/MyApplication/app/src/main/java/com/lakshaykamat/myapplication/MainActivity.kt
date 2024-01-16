package com.lakshaykamat.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lakshaykamat.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MultiplicationApp()
                }
            }
        }
    }
}

@Composable
fun MultiplicationApp(modifier: Modifier = Modifier) {
    TableCol(modifier = Modifier)
}

@Composable
fun TableCol(modifier: Modifier) {
    val userInput = remember { mutableStateOf("") }
    val str = tableStringGenerator(userInput.value.toIntOrNull())
    Column(modifier = modifier
        .fillMaxSize()
        .padding(vertical = 16.dp) , horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Multiplication", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.padding(16.dp))
        OutlinedTextField(value = userInput.value, onValueChange = { userInput.value = it })
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = str, style = MaterialTheme.typography.bodyLarge)
    }

}

fun tableStringGenerator(number: Int? = 2): String {
    val n = number ?: 2
    return buildString {
        for (i in 1..20) {
            append("$n X $i = ${n * i}\n")
        }
    }
}