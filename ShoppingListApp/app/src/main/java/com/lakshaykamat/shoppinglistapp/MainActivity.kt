package com.lakshaykamat.shoppinglistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lakshaykamat.shoppinglistapp.ui.theme.ShoppingListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShoppingListApp()
                }
            }
        }
    }
}


//Alert Dialog for user
@Composable
fun AlertDisplay(buttonText: String, alertMessage: String, alertTitle: String) {
    var showDialog by remember { mutableStateOf(false) }

    Button(
        onClick = { showDialog = true },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = buttonText)
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when clicking outside the alert or pressing the back button
                showDialog = false
            },
            title = {
                Text(text = alertTitle)
            },
            text = {
                Text(text = alertMessage)
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Perform action when the confirm button is clicked
                        showDialog = false // Dismiss the dialog
                    }
                ) {
                    Text(text = "OK?")
                }
            }
        )
    }
}


@Preview
@Composable
fun AlertDisplayPreview() {
    AlertDisplay("Show alert", "Alert", "This is a alert content")
}