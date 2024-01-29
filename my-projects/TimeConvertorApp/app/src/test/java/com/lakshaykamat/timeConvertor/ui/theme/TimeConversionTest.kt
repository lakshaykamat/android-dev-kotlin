package com.lakshaykamat.timeConvertor.ui.theme

import com.lakshaykamat.timeConvertor.Time
import com.lakshaykamat.timeConvertor.TimeUnits
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class TimeConversionTest{
    @Test
    fun `Test 1 - Hour to Minute Conversion`() {
        val result = Time.performConversion(TimeUnits.Hour, TimeUnits.Minute, 1.0)
        val expectedResult = 60.0
        assertEquals(expectedResult, result)
    }

    @Test
    fun `Test 2 - Second to Millisecond Conversion`() {
        val result = Time.performConversion(TimeUnits.Second, TimeUnits.Millisecond, 2.5)
        val expectedResult = 2500.0
        assertEquals(expectedResult, result)
    }

    @Test
    fun `Test 3 - Day to Hour Conversion`() {
        val result = Time.performConversion(TimeUnits.Day, TimeUnits.Hour, 3.0)
        val expectedResult = 72.0
        assertEquals(expectedResult, result)
    }

    @Test
    fun `Test 4 - Week to Second Conversion`() {
        val result = Time.performConversion(TimeUnits.Week, TimeUnits.Second, 4.5)
        val expectedResult = 2721600.0
        assertEquals(expectedResult, result)
    }

    @Test
    fun `Test 5 - Microsecond to Millisecond Conversion`() {
        val result = Time.performConversion(TimeUnits.Microsecond, TimeUnits.Millisecond, 500.0)
        val expectedResult = 0.5
        assertEquals(expectedResult, result)
    }

    @Test
    fun `Test 6 - Century to Decade Conversion`() {
        val result = Time.performConversion(TimeUnits.Century, TimeUnits.Decade, 2.0)
        val expectedResult = 20.0
        assertEquals(expectedResult, result)
    }

    @Test
    fun `Test 7 - Minute to Nanosecond Conversion`() {
        val result = Time.performConversion(TimeUnits.Minute, TimeUnits.Nanosecond, 1.5)
        val expectedResult = 90000000000.0
        assertEquals(expectedResult, result)
    }

}