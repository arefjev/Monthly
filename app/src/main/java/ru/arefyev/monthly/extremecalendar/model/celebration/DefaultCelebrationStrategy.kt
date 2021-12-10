package ru.arefyev.monthly.extremecalendar.model.celebration

import java.time.LocalDate

/** Default Celebration Date Strategy */
class DefaultCelebrationStrategy : CelebrationStrategy {
    /**
     * Always return false
     * To define custom business logic for defining
     * celebration days (national, ceremonial, church, etc.),
     * you need to override CelebrationStrategy
     * */
    override fun isCelebrationDate(date: LocalDate): Boolean = false
}