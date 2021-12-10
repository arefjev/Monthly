package ru.arefyev.monthly.extremecalendar.model.types

import java.time.DayOfWeek

/**
 * First day of the week type
 * Тип - Первый день недели в календаре
 */
enum class FirstDayOfTheWeekType(val dayOfTheWeek: DayOfWeek) {

    /** Monday/Понедельник */
    MONDAY(DayOfWeek.MONDAY),

    /** Sunday/Воскресенье */
    SUNDAY(DayOfWeek.SUNDAY)
}