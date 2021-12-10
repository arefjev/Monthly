package ru.arefyev.monthly.extremecalendar.model.dto

import java.time.LocalDateTime

data class EventDto(
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val title: String? = null
)
