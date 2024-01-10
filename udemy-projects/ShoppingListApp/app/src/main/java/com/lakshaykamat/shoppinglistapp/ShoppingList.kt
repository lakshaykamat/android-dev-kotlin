package com.lakshaykamat.shoppinglistapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.stringResource
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
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(32.dp))

        //Showing all list of items
        LazyColumn(modifier = Modifier.fillMaxHeight(.88f)) {
            items(shoppingItems) { item ->
                if (item.isEditing) {
                    ShoppingItemEditor(shoppingItem = item, onEdit = { editName, editQty ->
                        shoppingItems = shoppingItems.map { it.copy(isEditing = false) }
                        val editedItem = shoppingItems.find { it.id == item.id }
                        editedItem?.let {
                            it.name = editName
                            it.quantity = editQty
                        }
                    })
                } else {
                    ItemCardUI(item = item, onEditPress = {
                        shoppingItems = shoppingItems.map { it.copy(isEditing = item.id == it.id) }
                    }, {})
                }

            }
        }


        //Button for adding new items
        AddItemButton(onPress = { showDialog = true })

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
                    //Shopping Item Editor
                    CreateShoppingItem(
                        name = itemNameInput,
                        quantity = itemQuantityInput,
                        onNameChange = { newName -> itemNameInput = newName },
                        onQuantityChange = { newQuantity -> itemQuantityInput = newQuantity },
                    )
                }
            )
        }
    }
}

@Composable
fun ShoppingItemEditor(shoppingItem: ShoppingItem, onEdit: (String, Int) -> Unit) {
    var editingName by remember { mutableStateOf(shoppingItem.name) }
    var editingQuantity by remember { mutableStateOf(shoppingItem.quantity.toString()) }
    var isEditing by remember { mutableStateOf(shoppingItem.isEditing) }

    Column {
        //Name Input Box
        OutlinedTextField(value = editingName,
            onValueChange = { editingName = it },
            label = { Text(text = "Name") })

        //Quantity Input Box
        OutlinedTextField(value = editingQuantity,
            onValueChange = { editingQuantity = it },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            label = { Text(text = "Quantity") })

        Button(onClick = {
            isEditing = false
            onEdit(editingName, editingQuantity.toIntOrNull() ?: 1)
        }) {
            Text(text = "Save")
        }
    }
}

@Composable
fun CreateShoppingItem(
    name: String, quantity: String, onNameChange: (String) -> Unit,
    onQuantityChange: (String) -> Unit
) {
    Column {
        //Name Input Box
        OutlinedTextField(value = name,
            onValueChange = { onNameChange(it) },
            label = { Text(text = "Name") })

        //Quantity Input Box
        OutlinedTextField(value = quantity,
            onValueChange = { onQuantityChange(it) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            label = { Text(text = "Quantity") })
    }
}

@Composable
fun AddItemButton(onPress: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = onPress,
            modifier = Modifier
                .size(80.dp)
                .padding(16.dp),
            containerColor = MaterialTheme.colorScheme.primary,
            shape = CircleShape,
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = Color.White
            )
        }
    }
}

//@Composable
//fun ListShoppingItems(shoppingItems: MutableList<ShoppingItem>) {
//    LazyColumn(modifier = Modifier.fillMaxHeight(.88f)) {
//        items(shoppingItems) { item ->
//            if (item.isEditing) {
//                ShoppingItemEditor(shoppingItem = item, onEdit = { editName, editQty ->
//                    s = shoppingItems.map { it.copy(isEditing = false) }
//                    val editedItem = s.find { it.id == item.id }
//                    editedItem?.let {
//                        it.name = editName
//                        it.quantity = editQty
//                    }
//                })
//            } else {
//                ItemCardUI(item = item, onEditPress = {
//                    shoppingItems = shoppingItems.map { it.copy(isEditing = item.id == it.id) }
//                }, {})
//            }
//
//        }
//    }
//}

@Composable
fun ItemCardUI(
    item: ShoppingItem,
    onEditPress: () -> Unit,
    onDeletePress: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
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
                    IconButton(onClick = onEditPress) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit item")
                    }
                    IconButton(onClick = onDeletePress) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete item")
                    }
                }
            }
        }
    }
}
