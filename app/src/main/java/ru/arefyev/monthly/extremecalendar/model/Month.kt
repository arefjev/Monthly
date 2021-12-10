package ru.arefyev.monthly.extremecalendar.model

import ru.arefyev.monthly.extremecalendar.CalendarManager
import ru.arefyev.monthly.extremecalendar.model.types.FirstDayOfTheWeekType
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth

internal data class Month private constructor(
    val yearMonth: YearMonth,
    val currentDate: LocalDate,
    val events: List<Event>
) {
    companion object {
        fun of(date: LocalDate, events: List<Event> = emptyList()) = Month(
            YearMonth.of(date.year, date.month),
            date,
            events
        )

        fun of(monthIndex: Int, events: List<Event> = emptyList()): Month {
            val isDecember = monthIndex % 12 == 0
            val year = if (isDecember) {
                monthIndex / 12 - 1
            } else {
                monthIndex / 12
            }
            val month = if (isDecember) {
                12
            } else {
                monthIndex % 12
            }
            return of(LocalDate.of(year, month, 1), events)
        }
    }

    val monthIndex: Int = yearMonth.year * 12 + yearMonth.monthValue

    val weeksOfMonth: List<Week> get() {
        val firstDayOfMonth = LocalDate.of(yearMonth.year, yearMonth.month, 1)
        val firstDayOfWeek = firstDayOfMonth.dayOfWeek
        val lackDate = calculateLackDateOfWeek(firstDayOfWeek, CalendarManager.firstDayOfWeek)
        val firstDayOfFirstWeek = firstDayOfMonth.minusDays(lackDate.toLong())
        var weekRowCount = (lackDate + yearMonth.lengthOfMonth()) / 7
        if ((lackDate + yearMonth.lengthOfMonth()) % 7 == 0) {
            weekRowCount--
        }
        return (0..weekRowCount).map {
            Week.of(firstDayOfFirstWeek.plusDays((it * 7).toLong()), eventsOfThisMonth)
        }
    }

    private val eventsOfThisMonth = events.filter {
        event -> event.customEventEndDateTime.month == yearMonth.month
            || event.customEventStartDateTime.month == yearMonth.month
    }

    private fun calculateLackDateOfWeek(
        dayOfWeek: DayOfWeek,
        firstDayOfWeek: FirstDayOfTheWeekType): Int = when (firstDayOfWeek) {
            FirstDayOfTheWeekType.SUNDAY -> {
                if (dayOfWeek == DayOfWeek.SUNDAY) {
                    0
                } else {
                    dayOfWeek.value
                }
            }
            FirstDayOfTheWeekType.MONDAY -> dayOfWeek.value - 1
        }
}
