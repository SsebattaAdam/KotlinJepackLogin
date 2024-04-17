package com.example.jetpack.userUI.Authenticat

import com.example.jetpack.userUI.LOGGIN.loginState
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRepository{
    val currentUser : FirebaseUser? = Firebase.auth.currentUser
    fun hasUser() :Boolean = Firebase.auth.currentUser != null

    fun getUserId() : String? = Firebase.auth.currentUser?.uid.orEmpty()



    private val db = Firebase.firestore

    suspend fun addUserToFirestore(user: loginState, onComplete: (Boolean) -> Unit) = withContext(Dispatchers.IO) {
        val userMap = hashMapOf(
            "firstName" to user.firstName,
            "lastNameSignUp" to user.lastNameSignUp,
            "userName" to user.userName,
            "password" to user.password,
            "confirmPasswordSignUp" to user.confirmPasswordSignUp
            // Add other user information here
        )

        db.collection("users")
            .add(userMap)
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { onComplete(false) }
    }

    suspend fun CreateUser(
        email: String,
        password: String,
        onComplete: (Boolean) -> Unit
    ) = withContext(Dispatchers.IO){
        Firebase.auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful){
                onComplete.invoke(true)
        }else{
                onComplete.invoke(false)
            }
        }.await()
    }

    suspend fun loginUser2(
        email: String,
        password: String,
        onComplete: (Boolean) -> Unit
    ) = withContext(Dispatchers.IO){
        Firebase.auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful){
                onComplete.invoke(true)
            }else{
                onComplete.invoke(false)
            }
        }.await()
    }
    fun logoutUser(onComplete: (Boolean) -> Unit) {
        Firebase.auth.signOut()
        onComplete(true)
    }
}