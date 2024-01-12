package com.lakshaykamat.counterapp

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel:ViewModel() {
    //only accessible here
    private val _repository:CounterRepo = CounterRepo()
    private val _count = mutableIntStateOf(_repository.getCounterValue())

    //setter
    val count:MutableIntState = _count

    fun incrementCount() {
        _repository.incrementCounter()
        _count.intValue = _repository.getCounterValue()
    }

    fun decrementCount() {
        if(_count.intValue <= 0) return
        _repository.decrementCounter()
        _count.intValue = _repository.getCounterValue()
    }
}