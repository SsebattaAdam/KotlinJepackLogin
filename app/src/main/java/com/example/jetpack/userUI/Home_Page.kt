package com.example.jetpack.userUI

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetpack.userUI.LOGGIN.loginViewModel
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navToLoginPage : () -> Unit,
    loginViewModel: loginViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home page Screen") },
                actions = {
                    IconButton(
                        onClick = {
                            loginViewModel.logoutUser { success ->
                                if (success) {
                                    loginViewModel.resetLoginState()
                                    navToLoginPage.invoke()
                                }
                            }
                        }
                    ) {
                        Icon(Icons.Filled.ExitToApp, contentDescription = "Log out")
                    }
                }
            )
        }
    ) {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Home page Screen")
        }
    }
}