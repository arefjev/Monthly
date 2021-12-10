package ru.arefyev.monthly.extremecalendar.model

import ru.arefyev.monthly.extremecalendar.model.celebration.CelebrationStrategy
import ru.arefyev.monthly.extremecalendar.model.types.DayOfTheMonthType
import java.lang.Integer.min
import java.time.DayOfWeek
import java.time.LocalDate

internal data class Day(
    val day: LocalDate,
    val events: List<Event> = emptyList()
) {
    fun dayOfTheMonthType(
        currentMonth: Month,
        celebrationStrategy: CelebrationStrategy
    ): DayOfTheMonthType {
        if (day.month != currentMonth.yearMonth.month) {
            return DayOfTheMonthType.DAY_OF_ANOTHER_MONTH
        }
        if (celebrationStrategy.isCelebrationDate(day)) {
            return DayOfTheMonthType.HOLIDAY
        }
        return when (day.dayOfWeek) {
            DayOfWeek.SATURDAY -> DayOfTheMonthType.SATURDAY
            DayOfWeek.SUNDAY -> DayOfTheMonthType.SUNDAY
            else -> DayOfTheMonthType.WEEKDAY
        }
    }

    fun addEvent(event: Event) = this.events + event
    fun addEvents(events: List<Event>) = this.events + events

    fun eventCount(maxCount: Int): Int = min(maxCount, events.size)

}
