package com.example.application18102023.ui.home

import androidx.lifecycle.ViewModel
import com.example.application18102023.data.Item

class HomeViewModel() : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}
data class HomeUiState(val itemList: List<Item> = listOf())