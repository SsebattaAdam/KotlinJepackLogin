//package com.example.jetpack.userUI.signIN
//
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
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.material.icons.filled.Lock
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material3.Button
//import androidx.compose.material3.Checkbox
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import androidx.navigation.NavHostController
//import com.example.jetpack.Route
//import com.example.jetpack.userUI.COMPONNETS.HeaderText
//import com.example.jetpack.userUI.COMPONNETS.loginTextFiled
//
//import com.example.jetpack.userUI.LOGGIN.defaultPadding
//import com.example.jetpack.userUI.LOGGIN.itemSpacing
//import com.google.firebase.auth.FirebaseAuth
//
//@Composable
//fun RegisterScreen(navController: NavController,auth: FirebaseAuth) {
//
//    val (FirstName, setfirstName) = rememberSaveable { mutableStateOf("") }
//    val (lasttName, setlasttName) = rememberSaveable { mutableStateOf("") }
//    val (email, setemail) = rememberSaveable { mutableStateOf("") }
//    val (password, setpassword) = rememberSaveable { mutableStateOf("") }
//    val (confirmPassword, setconfirmpassword) = rememberSaveable { mutableStateOf("") }
//    val (checked, onCheckedChange) = rememberSaveable { mutableStateOf(false) }
//    var errorMessage by remember { mutableStateOf<String?>(null) }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState()),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(defaultPadding)
//                //.verticalScroll(rememberScrollState())
//            ,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//
//            HeaderText(
//                text = "Sign Up",
//                modifier = Modifier
//                    .align(Alignment.Start)
//                    .padding(vertical = itemSpacing)
//            )
//
//            loginTextFiled(
//                value = FirstName,
//                onValueChange = setfirstName,
//                labelText = "First Name",
//                leadingIcon = Icons.Default.Person,
//                keyboardType = KeyboardType.Text,
//                modifier = Modifier.width(400.dp)
//            )
//            loginTextFiled(
//                value = lasttName,
//                onValueChange = setlasttName,
//                labelText = "Last Name",
//                leadingIcon = Icons.Default.Person,
//                keyboardType = KeyboardType.Text,
//                modifier = Modifier.width(400.dp)
//            )
//            loginTextFiled(
//                value = email,
//                onValueChange = setemail,
//                labelText = "Email",
//                leadingIcon = Icons.Default.Email,
//                keyboardType = KeyboardType.Text,
//                modifier = Modifier.width(400.dp)
//            )
//
//            loginTextFiled(
//                value = password,
//                onValueChange = setpassword,
//                labelText = "Password",
//                leadingIcon = Icons.Default.Lock,
//                keyboardType = KeyboardType.Password,
//                visualTransformation = PasswordVisualTransformation(),
//                modifier = Modifier.width(400.dp)
//            )
//
//            loginTextFiled(
//                value = confirmPassword,
//                onValueChange = setconfirmpassword,
//                labelText = "Confirm Password",
//                leadingIcon = Icons.Default.Person,
//                keyboardType = KeyboardType.Text,
//                modifier = Modifier.width(400.dp)
//
//
//            )
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
//                    Text("i agree with the terms and conditions")
//                }
//
//            }
//
//
//            Spacer(modifier = Modifier.height(itemSpacing))
//
//            Button(
//                onClick = {
//                    if (password == confirmPassword) {
//                        auth.createUserWithEmailAndPassword(email, password)
//                            .addOnCompleteListener { task ->
//                                if (task.isSuccessful) {
//                                    // Registration successful, navigate to home screen
//                                    navController.navigate(Route.HomeScreen.name)
//                                } else {
//                                    // Registration failed, show error message
//                                    errorMessage = task.exception?.message ?: "Unknown error"
//                                }
//                            }
//                    } else {
//                        // Passwords do not match, show error message
//                        errorMessage = "Passwords do not match"
//                    }
//                },
//                modifier = Modifier
//                    .width(400.dp)
//                    .padding(horizontal = defaultPadding)
//            ) {
//                Text("Sign Up")
//            }
//
//            Spacer(modifier = Modifier.height(itemSpacing))
//            errorMessage?.let {
//                Text(it, color = Color.Red)
//            }
//
//            RegisterLink(
//                onClick =  { navController.navigate(Route.LoginScreen.name)},
//                modifier = Modifier.padding(vertical = itemSpacing)
//            )
//
//        }
//    }
//}
//
//
//
//@Composable
//fun RegisterLink(
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
//            Text("Already have an account? ")
//            TextButton(onClick = onClick) {
//                Text("Sign In")
//
//            }
//        }
//    }
//
//}