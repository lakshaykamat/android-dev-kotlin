package com.lakshaykamat.timeConvertor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lakshaykamat.timeConvertor.ui.theme.TimeConvertorTheme


@Composable
fun TimeConverterApp(modifier: Modifier = Modifier) {
    var inputStateOne by remember { mutableStateOf("") }
    var selectedFromUnit by remember { mutableStateOf(TimeUnits.Hour) }
    var selectedToUnit by remember { mutableStateOf(TimeUnits.Minute) }
    var inputStateTwo by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Time Converter App",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TimeConverterCard(
            inputStateOne = inputStateOne,
            selectedFromUnit = selectedFromUnit,
            onInputStateChanged = {
                inputStateOne = it
                val ans = Time.performConversion(
                    fromUnit = selectedFromUnit,
                    toUnit = selectedToUnit,
                    value = inputStateOne.toDoubleOrNull() ?: 0.0
                )
                inputStateTwo = ans.toString()

            },
            onSelectedUnitChange = {
                selectedFromUnit = it
                inputStateOne =""
                inputStateTwo =""
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        // Additional card or content can be added here if needed
        TimeConverterCard(
            inputStateOne = inputStateTwo,
            selectedFromUnit = selectedToUnit,
            onInputStateChanged = {
                inputStateTwo = it
                val ans = Time.performConversion(
                    fromUnit = selectedToUnit,
                    toUnit = selectedFromUnit,
                    value = inputStateTwo.toDoubleOrNull() ?: 0.0
                )
                inputStateOne = ans.toString()
            },
            onSelectedUnitChange = {
                selectedToUnit = it
                inputStateOne =""
                inputStateTwo =""
            }
        )
    }
}

@Composable
fun TimeConverterCard(
    inputStateOne: String,
    selectedFromUnit: TimeUnits,
    onInputStateChanged: (String) -> Unit,
    onSelectedUnitChange: (TimeUnits) -> Unit
) {
    var isDropdownExpanded by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        Column(
            horizontalAlignment = AbsoluteAlignment.Right,
            modifier = Modifier.padding(16.dp)
        ) {
            TimeConverterDropdownMenu(
                expanded = isDropdownExpanded,
                selectedOption = selectedFromUnit,
                onExpandedStateChanged = { isDropdownExpanded = it },
                onSelectedOptionChanged = onSelectedUnitChange
            )
            // TextField for input
            TextField(
                label = { Text(text = selectedFromUnit.toString()) },
                modifier = Modifier.fillMaxWidth(),
                value = inputStateOne,
                onValueChange = { onInputStateChanged(it) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                singleLine = true
            )
        }
    }
}


@Composable
fun TimeConverterDropdownMenu(
    expanded: Boolean,
    selectedOption: TimeUnits,
    onExpandedStateChanged: (Boolean) -> Unit,
    onSelectedOptionChanged: (TimeUnits) -> Unit
) {
    Column {
        Button(
            onClick = { onExpandedStateChanged(true) },
            modifier = Modifier.fillMaxWidth(.5f)
        ) {
            Text(text = selectedOption.toString())
        }

        DropdownMenu(
            modifier = Modifier.fillMaxWidth(.5f),
            expanded = expanded,
            onDismissRequest = { onExpandedStateChanged(false) },
        ) {
            TimeUnits.values().forEach { unit ->
                DropdownMenuItem(
                    onClick = {
                        onSelectedOptionChanged(unit)
                        onExpandedStateChanged(false)
                    },
                    text = { Text(unit.toString()) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TimeConverterAppPreview() {
    TimeConvertorTheme {
        TimeConverterApp()
    }
}