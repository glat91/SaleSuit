package com.proyect.ventasexamen.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyect.ventasexamen.models.statusInput.StatusInput
import kotlinx.coroutines.launch

class InputSellViewModel: ViewModel() {
    var _status = MutableLiveData<StatusInput>()
    var status = _status


    fun uploadSale(){
        viewModelScope.launch{
            /** falta realizar esta parte los datos parecen estar incorrectos
            val engine = Engine.getEngine().create<Services>()
            engine.putSale().enqueue(object: Callback<SaleResponse> {})
            */
        }
    }
}