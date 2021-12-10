package ru.arefyev.monthly.extremecalendar.model.celebration

import java.time.LocalDate

/**
 * Business logic for determining the day of celebration
 * Бизнес-логика определения праздничного дня
 * Interface/Интерфейс
 * */
interface CelebrationStrategy {
    /**
     * Determines if the date is a celebration date
     * @param date 
     * @return If date is a celebration date, return True.
     */
    fun isCelebrationDate(date: LocalDate): Boolean
}