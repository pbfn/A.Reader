package com.pedro_bruno.areader.screens.details


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro_bruno.areader.data.Resource
import com.pedro_bruno.areader.model.Item
import com.pedro_bruno.areader.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val bookRepository: BookRepository) :
    ViewModel() {



    suspend fun getBookInfo(bookId: String): Resource<Item> {
        viewModelScope.launch {

        }
        return bookRepository.getBookInfo(bookId)
    }

}