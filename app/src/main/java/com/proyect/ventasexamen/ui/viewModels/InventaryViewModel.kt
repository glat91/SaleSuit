package com.proyect.ventasexamen.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proyect.ventasexamen.models.inventoryResponse.Products

class InventaryViewModel: ViewModel() {

    private var _inventoryResponse = MutableLiveData<ArrayList<Products>>()
    var inventory = _inventoryResponse

    fun getInventary(){
        val array = arrayListOf<Products>()
        array.add(Products(1, "Samsung TV 59", "Samsung", "ADGFDF34343", "https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", 10, true))
        array.add(Products(2, "Samsung TV 59", "Samsung", "ADGFDF34343", "https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", 10, true))
        array.add(Products(3, "Samsung TV 59", "Samsung", "ADGFDF34343", "https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", 10, true))
        array.add(Products(4, "Samsung TV 59", "Samsung", "ADGFDF34343", "https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", 10, true))
        array.add(Products(5, "Samsung TV 59", "Samsung", "ADGFDF34343", "https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", 10, true))
        _inventoryResponse.value = array
    }
}