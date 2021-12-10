package ru.arefyev.monthly.extremecalendar.model

import ru.arefyev.monthly.extremecalendar.model.dto.EventDto
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.MonthDay

internal data class Event(
    val customEventStartDateTime: LocalDateTime,
    val customEventEndDateTime: LocalDateTime,
    val customEventTitle: String? = null
) {

    fun isEventDate(date: LocalDate): Boolean {
        val startMonthDay = MonthDay.of(
            customEventStartDateTime.month,
            customEventStartDateTime.dayOfMonth
        )
        val endMonthDay = MonthDay.of(
            customEventEndDateTime.month,
            customEventEndDateTime.dayOfMonth
        )
        val targetDate = MonthDay.of(
            date.month,
            date.dayOfMonth
        )
        return startMonthDay == targetDate
                || targetDate == endMonthDay
                || (startMonthDay.isAfter(targetDate) && targetDate.isAfter(endMonthDay))
    }

    companion object {
        fun of(dto: EventDto): Event = Event(dto.startDateTime, dto.endDateTime, dto.title)
    }

}
