package com.example.shoeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel:ViewModel() {

    private val _eventLogin = MutableLiveData<Boolean>()
    val eventLogin : LiveData<Boolean> =_eventLogin

    private val _eventWelcome = MutableLiveData<Boolean>()
    val eventWelcome : LiveData<Boolean> = _eventWelcome

    private val _eventInstruction = MutableLiveData<Boolean>()
    val eventInstruction : LiveData<Boolean> = _eventInstruction

    private val _eventFabButton = MutableLiveData<Boolean>()
    val eventFabButton : LiveData<Boolean> = _eventFabButton


    private val _eventBackToShoeList = MutableLiveData<Boolean>()
    val eventBackToShoeList : LiveData<Boolean> = _eventBackToShoeList

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes : LiveData<List<Shoe>> = _shoes

    var currentShoe:Shoe? = null

    fun newShoe(){
        currentShoe = Shoe("",0.0 , "","")
    }




    init {

        _shoes.value = createSampleShoes()
    }

    fun login(){
        _eventLogin.value = true
    }

    fun loginComplete(){
        _eventLogin.value = false
    }

    fun welcome(){
        _eventWelcome.value = true
    }

    fun welcomeComplete(){
        _eventWelcome.value = false
    }

    fun instruction(){
        _eventInstruction.value = true
    }

    fun instructionComplete(){
        _eventInstruction.value = false
    }

    fun fabButton(){
        _eventFabButton.value = true
    }

    fun fabButtonComplete(){
        _eventFabButton.value = false
    }

    fun backToShoeList() {
        _eventBackToShoeList.value = true
    }

    fun backToShoeListComplete(){
        _eventBackToShoeList.value = false
    }

    private fun createSampleShoes():List<Shoe>{
        val shoe = mutableListOf<Shoe>()
        shoe.add(Shoe("jordan",12.5 , "Adidas" , "The best for sport"))
        shoe.add(Shoe("jordan",12.5 , "Adidas" , "The best for sport"))

        return shoe
    }

    fun save(){
        val shoe = mutableListOf<Shoe>()

        _shoes.value?.let { shoe.addAll(it) }
        currentShoe?.let { shoe.add(it) }

        _shoes.value = shoe
        _eventBackToShoeList.value = true

    }




}