package com.pedro_bruno.areader.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.pedro_bruno.areader.model.MUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class LoginScreenViewModel : ViewModel() {

    //val loadingState = MutableStateFlow(LoadingState.IDLE)
    private val auth: FirebaseAuth = Firebase.auth

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading


    fun signInWithEmailAndPassword(email: String, password: String, goToHome: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d("InWithEmailAndPassword", "signInWithEmailAndPassword: Login ok")
                            goToHome()
                        } else {
                            Log.d(
                                "InWithEmailAndPassword",
                                "signInWithEmailAndPassword: ${task.result.toString()}"
                            )
                        }
                    }
            } catch (ex: Exception) {
                Log.d("InWithEmailAndPassword", "signInWithEmailAndPassword: ${ex.message}")
            }
        }

    fun createUserWithEmailAndPassword(email: String, password: String, goToHome: () -> Unit) =
        viewModelScope.launch {
            if (_loading.value == false) {
                _loading.value = true
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val displayName = task.result.user?.email?.split("@")?.get(0)
                            createUser(displayName)
                            goToHome()
                        } else {
                            Log.d(
                                "CreateUser",
                                "createUserWithEmailAndPassword: ${task.result.toString()}"
                            )
                        }
                        _loading.value = false
                    }
            }
        }

    private fun createUser(displayName: String?) {
        val userID = auth.currentUser?.uid
        val user = MUser(
            userId = userID.toString(),
            displayName = displayName.toString(),
            avatarUrl = "",
            quote = "Life is great",
            profession = "Android Developer",
            id = null
        ).toMap()

        FirebaseFirestore.getInstance().collection("users")
            .add(user)
    }


}