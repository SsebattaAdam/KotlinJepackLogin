//package com.example.jetpack.userUI.LOGGIN
//
//import android.os.Build
//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Lock
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material3.Button
//import androidx.compose.material3.Checkbox
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.example.jetpack.Route
//import com.example.jetpack.userUI.COMPONNETS.HeaderText
//import com.example.jetpack.userUI.COMPONNETS.loginTextFiled
//import java.time.format.TextStyle
//
//
//val defaultPadding = 16.dp
//val itemSpacing = 8.dp
//
//
//
//
//@Composable
//fun LoginScreen(navController: NavController) {
//    val (userName, setUserName) = rememberSaveable { mutableStateOf("") }
//    val (password, setPassword) = rememberSaveable { mutableStateOf("") }
//    val (checked, onCheckedChange) = rememberSaveable { mutableStateOf(false) }
//
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(defaultPadding)
//                .verticalScroll(rememberScrollState()),
//
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            HeaderText(
//                text = "Login Screen",
//                modifier = Modifier
//                    .align(Alignment.Start)
//                    .padding(vertical = itemSpacing)
//            )
//
//            loginTextFiled(
//                value = userName,
//                onValueChange = setUserName,
//                labelText = "Username",
//                leadingIcon = Icons.Default.Person,
//                keyboardType = KeyboardType.Text,
//                modifier = Modifier.width(400.dp)
//            )
//
//            loginTextFiled(
//                value = password,
//                onValueChange = setPassword,
//                labelText = "Password",
//                leadingIcon = Icons.Default.Lock,
//                keyboardType = KeyboardType.Password,
//                visualTransformation = PasswordVisualTransformation(),
//                modifier = Modifier.width(400.dp)
//            )
//
//            Spacer(modifier = Modifier.height(itemSpacing))
//
//            Button(
//                onClick = { navController.navigate(Route.HomeScreen.name)},
//                modifier = Modifier
//                    .width(400.dp)
//                    .padding(horizontal = defaultPadding)
//            ) {
//                Text("Login")
//            }
//
//            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = defaultPadding)
//            ) {
//                Row(
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Checkbox(checked = checked, onCheckedChange = onCheckedChange)
//                    Text("Remember me")
//                }
//                TextButton(onClick = { /*TODO*/ }) {
//                    Text("Forgot password")
//                }
//            }
//
//            Spacer(modifier = Modifier.height(itemSpacing))
//
//            LoginLink(
//                onClick = { navController.navigate(Route.RegisterScreen.name)},
//                modifier = Modifier.padding(vertical = itemSpacing)
//            )
//        }
//    }
//}
//
//
//@Composable
//fun LoginLink(
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Row(
//        horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = defaultPadding)
//    ) {
//        Row(
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text("Don't have an account? ")
//            TextButton(onClick = onClick) {
//                Text("Register")
//
//            }
//        }
//    }
//
//}
//
//
//
