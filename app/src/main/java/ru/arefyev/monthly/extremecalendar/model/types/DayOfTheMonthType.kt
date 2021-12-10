package ru.arefyev.monthly.extremecalendar.model.types

/**
 * Day of the month type
 * Тип дня месяца
 */
internal enum class DayOfTheMonthType {
    /**
     * Any day of another month
     * Любой день другого (не текущего) месяца
     * */
    DAY_OF_ANOTHER_MONTH,

    /**
     * Holiday
     * Праздничный день (на всякий случай, если придумаю как реализовать)
     * */
    HOLIDAY,

    /**
     * Saturday
     * Суббота
     * */
    SATURDAY,

    /**
     * Sunday
     * Воскресенье
     * */
    SUNDAY,

    /**
     * Today
     * Сегодня (текущий день, текущая дата)
     * */
    TODAY,

    /**
     * Working day
     * Рабочий день (день недели с понедельника по пятницу включительно
     * */
    WEEKDAY
}