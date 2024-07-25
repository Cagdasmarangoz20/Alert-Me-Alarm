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

enum class Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
