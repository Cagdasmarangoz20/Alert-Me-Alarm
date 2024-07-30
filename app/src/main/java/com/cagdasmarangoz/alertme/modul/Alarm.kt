package com.cagdasmarangoz.alertme.modul

import java.util.Date

data class Alarm(
    var title: String,
    var hour: Int,
    var minute: Int,
    var isActive: Boolean,
    var dayList: List<Days>
) {

    val time: String = "$hour:$minute"
}

enum class Days(val value: String) {
    MONDAY("MONDAY"),
    TUESDAY("TUESDAY"),
    WEDNESDAY("WEDNESDAY"),
    THURSDAY("THURSDAY"),
    FRIDAY("FRIDAY"),
    SATURDAY("SATURDAY"),
    SUNDAY("SUNDAY")
}
