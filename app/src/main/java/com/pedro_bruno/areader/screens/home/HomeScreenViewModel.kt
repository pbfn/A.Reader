package com.pedro_bruno.areader.screens.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro_bruno.areader.data.DataOrException
import com.pedro_bruno.areader.model.Book
import com.pedro_bruno.areader.model.MBook
import com.pedro_bruno.areader.repository.FireRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: FireRepository) :
    ViewModel() {

    val data: MutableState<DataOrException<List<MBook>, Boolean, Exception>> =
        mutableStateOf(DataOrException(listOf(), true, Exception("")))

    init {
        getAllBooksFromDatabase()
    }

    private fun getAllBooksFromDatabase() {
        viewModelScope.launch {
            //data.value.loading = true

            data.value = repository.getAllBooksFromDataBase()
            if(!data.value.data.isNullOrEmpty()) data.value.loading = false
        }
        Log.d("getAllBooksFromDatabase", "getAllBooksFromDatabase: ${data.value.data?.toList().toString()}")
    }
}