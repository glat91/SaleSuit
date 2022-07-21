package com.proyect.ventasexamen.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proyect.ventasexamen.models.inventoryResponse.Products
import com.proyect.ventasexamen.models.salesRv.SalesRv

class SalesViewModel: ViewModel() {
    private val _sales = MutableLiveData<ArrayList<SalesRv>>()
    val sales = _sales

    fun getSales(){
        val array = arrayListOf<SalesRv>()
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        _sales.value = array
    }
}