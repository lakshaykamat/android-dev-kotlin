package com.lakshaykamat.tipCalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lakshaykamat.tipCalculator.ui.theme.TipCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipCalculatorApp()
                }
            }
        }
    }
}

@Composable
fun TipCalculatorApp() {
    val tC = TipCalculation()
    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }
    var tipAmount by remember { mutableDoubleStateOf(0.00) }
    var amountToPay by remember { mutableDoubleStateOf(0.00) }
    var person by remember { mutableStateOf("1") }
    var eachPersonAmount by remember { mutableDoubleStateOf(0.00) }
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.tip_calculator),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            leadingIcon ={ Icon(painter = painterResource(id = R.drawable.attach_money),contentDescription = null)},
            label = { Text(text = "Enter Amount") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = amountInput,
            onValueChange = { amountInput = it })
        OutlinedTextField(
            leadingIcon ={ Icon(painter = painterResource(id = R.drawable.percent),contentDescription = null)},
            label = { Text(text = "Enter Tip %") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = tipInput,
            onValueChange = { tipInput = it })
        OutlinedTextField(
            leadingIcon ={ Icon(imageVector = Icons.Filled.Person, contentDescription =null)},
            label = { Text(text = "No. of Person") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            value = person,
            onValueChange = { person = it })

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Round the tip?")
            Switch(checked = roundUp, onCheckedChange = { roundUp = !roundUp })
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
        )
        {
            Text(
                text = stringResource(
                    id = R.string.amount_to_pay,
                    tC.limitDecimalDigits(amountToPay, 2)
                ),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(
                    id = R.string.total_tip,
                    tC.limitDecimalDigits(tipAmount, 2)
                ),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text =
                stringResource(
                    R.string.each_person,
                    tC.limitDecimalDigits(eachPersonAmount, 2)
                )
            )


        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            val amountValue = amountInput.toDoubleOrNull() ?: 0.0
            val tipValue = tipInput.toDoubleOrNull() ?: 0.0
            val personValue = person.toIntOrNull() ?: 1
            tipAmount = tC.calculateTip(
                amountValue,
                tipValue
            )

            amountToPay = tC.calculateFinalAmount(
                amountValue,
                tipValue,
                roundUp
            )
            eachPersonAmount = (amountToPay / personValue)
        }) {
            Text(text = stringResource(R.string.calculate_tip_btn_txt))
        }
    }
}
