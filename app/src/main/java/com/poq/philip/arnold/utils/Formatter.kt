package com.poq.philip.arnold.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object Formatter {
    fun NumberFormatter(temp: Double): String {
        var tempPart = String.format("%.1f", temp)
        if (tempPart.substring(tempPart.length-2).equals(".0")) {
            tempPart = String.format("%.0f", temp)
        }
        return tempPart
    }
    fun TempFormatter(temp: Double, metric: Boolean): String {
        val tempPart = NumberFormatter(temp)
        val value = String.format("%s\u00B0%s", tempPart,
            if (metric) {
                "c"
            } else {
                "f"
            }
        )
        return value
    }
    fun WindFormatter(windSpeed: Double, windDirection: Double): String {
        val tempPart = NumberFormatter(windSpeed)
        val tempPart2 = NumberFormatter(windDirection)
        val value = String.format("%skm/h -> %s\u00B0", tempPart, tempPart2)
        return value
    }

    fun CalcDate(date: String): Date {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
        val value = sdf.parse(date)
        return value!!
    }
    fun DateFormatter(date: String): String {
        val dt = CalcDate(date)
        return Formatter.DateFormatter(dt)
    }
    fun DateFormatter(date: Date): String {
        val value = DateFormat.getDateInstance().format(date)
        return value
    }
    fun DayFormatter(date: String, short: Boolean = true): String {
        val calcDate = CalcDate(date)
        val sdf2 = SimpleDateFormat("EEEE", Locale.ENGLISH)
        var value = sdf2.format(calcDate)
        if (short) {
            value = value.substring(0, 3).toUpperCase(Locale.ENGLISH)
        }
        return value
    }
    fun TimeFormatter(date: String): String {
        val calcDate = CalcDate(date)
        val sdf2 = SimpleDateFormat("HH:mm", Locale.ENGLISH)
        val value = sdf2.format(calcDate)
        return value
    }
}