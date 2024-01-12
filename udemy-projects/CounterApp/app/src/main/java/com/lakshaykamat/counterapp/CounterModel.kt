package com.lakshaykamat.counterapp

data class CounterModel(var count: Int)

class CounterRepo {
    private var counter = CounterModel(0)

    fun getCounter() = counter
    fun getCounterValue() = counter.count

    fun incrementCounter() {
        counter.count++
    }

    fun decrementCounter() {
        counter.count--
    }
}