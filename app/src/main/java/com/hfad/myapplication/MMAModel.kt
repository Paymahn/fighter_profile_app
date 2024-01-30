package com.hfad.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.hfad.myapplication.MMARepository

class MMAModel(private val mmaRepository: MMARepository) : ViewModel() {

    init {
        initiateImageSearch("Cow") // Example query
    }

    private val _imageUrl = MutableLiveData<GoogleImage>()
    val imageUrl: LiveData<GoogleImage> = _imageUrl

    data class MmaFighter (val name : String )


    fun initiateImageSearch(query: String) {
        viewModelScope.launch {
            val imageUrls = mmaRepository.searchGoogleImages(query)
            if (imageUrls.isNotEmpty()) {
                _imageUrl.value = imageUrls.first() // Get the first image URL
            }

        }
    }



}