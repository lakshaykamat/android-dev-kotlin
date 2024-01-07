package com.lakshaykamat.shoppinglistapp

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


data class ShoppingItem(
    val id: Int, var name: String, var quantity: Int, var isEditing: Boolean = false
)

@Composable
fun ShoppingListApp() {
    //Mutable List of Shopping Items
    var shoppingItems by remember { mutableStateOf(SAMPLE_DATA) }

    var showDialog by remember { mutableStateOf(false) }

    var itemNameInput by remember { mutableStateOf("") }

    var itemQuantityInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Shopping List",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(32.dp))

        //Showing all list of items
        ListShoppingItems(shoppingItems = shoppingItems)


        //Button for adding new items
        Button(
            onClick = { showDialog = true },
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Add Item")
        }

        //Alert dialog
        if (showDialog) {
            AlertDialog(
                shape = MaterialTheme.shapes.medium,
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    Button(onClick = {
                        //If input values are not null then add items
                        if (itemNameInput.isNotBlank() && itemQuantityInput.isNotBlank()) {
                            //Creating a new item
                            val newItem = ShoppingItem(
                                id = shoppingItems.size + 1,
                                name = itemNameInput,
                                quantity = itemQuantityInput.toInt()
                            )

                            //Adding new item to list
                            shoppingItems = shoppingItems + newItem

                            showDialog = false //Hiding dialog
                            itemNameInput = "" //resting input value of name filed
                            itemQuantityInput = ""  //resting input value of quantity field
                        }

                    }) {
                        Text(text = "Add Item")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text(text = "Cancel")
                    }
                },
                title = { Text(text = "New Shopping Item") },
                text = {
                    //Shopping Item Form
                    Column {
                        //Name Input Box
                        OutlinedTextField(value = itemNameInput,
                            onValueChange = { itemNameInput = it },
                            label = { Text(text = "Name") })

                        //Quantity Input Box
                        OutlinedTextField(value = itemQuantityInput,
                            onValueChange = { itemQuantityInput = it },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            label = { Text(text = "Quantity") })
                    }
                })
        }
    }
}

@Composable
fun ListShoppingItems(shoppingItems: List<ShoppingItem>) {
    LazyColumn(modifier = Modifier.fillMaxHeight(0.9f)) {
        items(shoppingItems) { item ->
            ItemCardUI(item = item)
        }
    }
}

@Composable
fun ItemCardUI(item: ShoppingItem) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        //elevation = 16.dp,
        shape = RoundedCornerShape(10.dp), border = BorderStroke(1.dp, Color.LightGray)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "${item.id}. ${item.name}",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Quantity: ${item.quantity}", style = MaterialTheme.typography.bodyMedium
                )

            }

            Column {
                Row {
                    IconButton(
                        onClick = { /*TODO*/ },
                        content = { Icon(Icons.Default.Edit, contentDescription = "Edit item") })
                    IconButton(
                        onClick = { /*TODO*/ },
                        content = {
                            Icon(Icons.Default.Delete, contentDescription = "Delete item")
                        })
                }
            }
        }
    }
}
