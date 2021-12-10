package ru.arefyev.monthly.extremecalendar.model

import java.time.LocalDate

internal data class Week(
    val days: List<Day>
) {
    companion object {
        fun of(firstDayOfWeek: LocalDate, events: List<Event> = emptyList()): Week {
            val weekDays = (0..6).map {
                val day = firstDayOfWeek.plusDays(it.toLong())
                Day(day, events.filter { event -> event.isEventDate(day) })
            }
            return Week(weekDays)
        }
    }
}
