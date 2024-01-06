package com.lakshaykamat.unitconvertor

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import com.lakshaykamat.unitconvertor.ui.theme.UnitConvertorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConvertorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   UnitConvertor()
                }
            }
        }
    }
}

@Composable
fun UnitConvertor() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //all elements are like in stack
        Text(text = "Unit Convertor")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = "", onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))
        Row{
            //all elements will next to each other
            Box {
                Button(onClick = {  }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown,contentDescription = null)

                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meter")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Millimeter")}, onClick = { /*TODO*/ })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{

                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown,contentDescription = null)
                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meter")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Millimeter")}, onClick = { /*TODO*/ })
                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Response:")
    }
}

@Preview(showSystemUi = true,
    device = "id:pixel_7"
)
@Composable
fun UnitConvertorPreview(){
    UnitConvertor()
}