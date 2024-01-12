package com.lakshaykamat.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lakshaykamat.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    private val counterViewModel: CounterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CounterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Counter(appName = "Count:", viewModel = counterViewModel)
                }
            }
        }
    }
}

@Composable
fun Counter(appName: String, viewModel: CounterViewModel) {


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$appName ${viewModel.count.intValue}",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(8.dp)
        )
        Buttons(
            count = viewModel.count.intValue,
            increment = { viewModel.incrementCount() },
            decrement = { viewModel.decrementCount() })
    }
}

@Composable
fun Buttons(count: Int, increment: () -> Unit, decrement: () -> Unit) {
    Row {
        Button(onClick = increment) {
            Text(text = "Increment")
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Button(onClick = decrement, enabled = count > 0) {
            Text(text = "Decrement")
        }

    }
}