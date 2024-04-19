package com.example.jetpack.userUI.signIN

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

import com.example.jetpack.userUI.LOGGIN.loginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen2(
    loginViewModel: loginViewModel? = null,
    onNavToHomePage : () -> Unit,
    onNavToSignInPage : () -> Unit
) {

    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.signupError != null
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Register page",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            if (isError) {
                Text(
                    text = loginUiState?.signupError ?: "Unknown Error",
                    color = Color.Red
                )
            }

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = loginUiState?.firstName ?: "",
                onValueChange = { loginViewModel?.onUserfastNameSignUpChange(it) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = "Name"
                    )
                },
                isError = isError
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = loginUiState?.lastNameSignUp ?: "",
                onValueChange = { loginViewModel?.onUserlastNameSignUpChange(it) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = "Role"
                    )
                },
                isError = isError
            )


            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = loginUiState?.userNameSignUp ?: "",
                onValueChange = { loginViewModel?.onUserNameSignUpChange(it) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = "Email"
                    )
                },
                isError = isError
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = loginUiState?.passwordSignUp ?: "",
                onValueChange = { loginViewModel?.onPasswordSignUpChange(it) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = "password"
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                isError = isError
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = loginUiState?.confirmPasswordSignUp ?: "",
                onValueChange = { loginViewModel?.onConfirmPasswordSignUpChange(it) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = "confirm Password"
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                isError = isError
            )


            Button(
                onClick = {
                    CoroutineScope(Dispatchers.Main).launch {
                        loginViewModel?.createUser(context)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Register"
                )
            }




            Spacer(modifier = Modifier.size(16.dp))

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Row (
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Already have an Account"
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    TextButton(onClick = {
                        onNavToSignInPage.invoke()
                    }) {
                        Text("Login")

                    }
                }
            }


            if (loginUiState?.isLoading == true) {
                CircularProgressIndicator()
            }
            LaunchedEffect(key1 = loginViewModel?.hasUser) {
                if (loginViewModel?.hasUser == true) {
                    onNavToHomePage.invoke()
                }
            }
        }
    }
}