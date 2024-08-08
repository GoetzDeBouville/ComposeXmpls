package com.hellcorp.composenavigationxmpl.feature.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SpecialDialog(
    visible: Boolean,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    if (visible) {
        AlertDialog(
            onDismissRequest = {
                onDismissRequest()
            },
            title = { Text(text = "Важное сообщение!") },
            text = { Text(text = "Не забывайте пить больше воды!") },
            confirmButton = {
                Button(
                    onClick = {
                        onConfirmation()
                    }
                ) {
                    Text(text = "Спасибо!")
                }
            }
        )
    }
}