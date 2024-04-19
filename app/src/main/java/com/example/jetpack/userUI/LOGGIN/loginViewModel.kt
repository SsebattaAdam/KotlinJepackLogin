package com.example.jetpack.userUI.LOGGIN

import com.example.jetpack.userUI.Authenticat.AuthRepository
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class loginViewModel(
    private val repository: AuthRepository = AuthRepository()

): ViewModel(){

    var currentUser = repository.currentUser

    val hasUser: Boolean get() = repository.hasUser()

    var loginUiState by mutableStateOf(loginState())
        private  set

    fun onUserNameChange(userName: String){
        loginUiState = loginUiState.copy(userName = userName)
    }
    fun onPasswordChange(password: String){
        loginUiState = loginUiState.copy(password = password)
    }
    fun onUserNameSignUpChange(userName: String){
        loginUiState = loginUiState.copy(userNameSignUp = userName)
    }
    fun onPasswordSignUpChange(password: String){
        loginUiState = loginUiState.copy(passwordSignUp = password)
    }
    fun onConfirmPasswordSignUpChange(password: String){
        loginUiState = loginUiState.copy(confirmPasswordSignUp = password)
    }

    fun onUserlastNameSignUpChange(lastNameSignUp: String){

        loginUiState = loginUiState.copy(lastNameSignUp =lastNameSignUp)
    }
    fun onUserfastNameSignUpChange(firstName: String){
        loginUiState = loginUiState.copy(firstName = firstName)
    }





    private fun validateLoginForm() : Boolean{
        return loginUiState.userName.isNotBlank() && loginUiState.password.isNotBlank()
    }
    private fun validateSignUpForm() : Boolean{
        return loginUiState.userNameSignUp.isNotBlank()
                && loginUiState.passwordSignUp.isNotBlank()
                && loginUiState.confirmPasswordSignUp.isNotBlank()
    }


    suspend fun createUser(context:Context){
        try {
            if(!validateSignUpForm()){
                throw  IllegalArgumentException("Please fill in all fields")
            }
            loginUiState = loginUiState.copy(isLoading = true)
            if(loginUiState.passwordSignUp != loginUiState.confirmPasswordSignUp){
                throw IllegalArgumentException("password must be the same")
            }

            loginUiState = loginUiState.copy(signupError = null)
            repository.CreateUser(
                loginUiState.firstName,
                loginUiState.lastNameSignUp,
                loginUiState.userNameSignUp,
                loginUiState.userNameSignUp,
                loginUiState.passwordSignUp
            ){ isSuccessfull ->

                CoroutineScope(Dispatchers.Main).launch {
                    if (isSuccessfull ){
                        Toast.makeText(
                            context, "Successs login",
                            Toast.LENGTH_SHORT
                        ).show()

                        loginUiState = loginUiState.copy( isSuccesslogin = true)
                    } else{
                        Toast.makeText(
                            context, "Failed to login",
                            Toast.LENGTH_SHORT
                        ).show()
                        loginUiState = loginUiState.copy( isSuccesslogin = false)
                    }
                }
            }

        }catch (e: Exception){
            loginUiState = loginUiState.copy( signupError = e.message)
        } finally {
            loginUiState = loginUiState.copy(isLoading = false)
        }
    }


    suspend fun loginUser(context:Context){
        try {
            if(!validateLoginForm()){
//                loginUiState = loginUiState.copy(signupError = "Please fill in all fields")
//                return
                throw  IllegalArgumentException("Please fill in all fields")
            }
            loginUiState = loginUiState.copy(isLoading = true)
            loginUiState = loginUiState.copy(loginError = null)
            repository.loginUser2(
                loginUiState.userName,
                loginUiState.password
            ){ isSuccessfull ->

                if (isSuccessfull ){
                    Toast.makeText(
                        context, "Successs login",
                        Toast.LENGTH_SHORT
                    ).show()

                    loginUiState = loginUiState.copy( isSuccesslogin = true)
                } else{
                    Toast.makeText(
                        context, "Failed to login",
                        Toast.LENGTH_SHORT
                    ).show()
                    loginUiState = loginUiState.copy( isSuccesslogin = false)
                }
            }

        }catch (e: Exception){
            loginUiState = loginUiState.copy( loginError = e.message)
        } finally {
            loginUiState = loginUiState.copy(isLoading = false)
        }
    }
    fun logoutUser(onComplete: (Boolean) -> Unit) {
        Firebase.auth.signOut()
        onComplete(true)
    }
    fun resetLoginState() {
        loginUiState = loginState()
    }
}



data class loginState(
    val firstName: String = "",
    val lastNameSignUp: String = "",
    val userName: String = "",
    val password: String= "",
    val userNameSignUp: String = "",
    val passwordSignUp: String= "",
    val confirmPasswordSignUp: String= "",
    val isLoading : Boolean = false,
    val isSuccesslogin : Boolean = false,
    val signupError : String? = null,
    val loginError : String ? = null

)