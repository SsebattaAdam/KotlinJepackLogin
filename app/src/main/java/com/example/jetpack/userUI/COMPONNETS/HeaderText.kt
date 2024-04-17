package com.example.jetpack.userUI.COMPONNETS

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import java.lang.reflect.Modifier

@Composable
fun HeaderText(
    text: String,
    modifier: androidx.compose.ui.Modifier
){
    Text(
        text = text,
        style = MaterialTheme.typography.displayMedium,
        fontWeight = FontWeight.Bold,
        modifier = modifier

        )

}
