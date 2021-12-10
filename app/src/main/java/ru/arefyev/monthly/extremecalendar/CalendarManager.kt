package ru.arefyev.monthly.extremecalendar

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import ru.arefyev.monthly.extremecalendar.model.celebration.CelebrationStrategy
import ru.arefyev.monthly.extremecalendar.model.celebration.DefaultCelebrationStrategy
import ru.arefyev.monthly.extremecalendar.model.types.FirstDayOfTheWeekType

object CalendarManager {

    var celebrationStrategy: CelebrationStrategy = DefaultCelebrationStrategy()
    var firstDayOfWeek = FirstDayOfTheWeekType.MONDAY

    object Colors {
        var Saturday = Color.Red
        var Sunday = Color.Red
        var CelebrationDay = Sunday
        var Weekday = Color.LightGray
        var Today = Color.DarkGray
        var SelectedDay = Color.Blue
        var EventMarker = Color.Magenta
    }

    object Layout {
        var calendarHeight = 320.dp
        var selectedBackground: Shape = RoundedCornerShape(16.dp)
    }

    object Localizable {
        var YEAR_MONTH_FORMAT = "MM.yyyy"
        var DATE_FORMAT = "dd"

        var MONDAY_LABEL    = "ПН"
        var THURSDAY_LABEL  = "ВТ"
        var WEDNESDAY_LABEL = "СР"
        var TUESDAY_LABEL   = "ЧТ"
        var FRIDAY_LABEL    = "ПТ"
        var SATURDAY_LABEL  = "СБ"
        var SUNDAY_LABEL    = "ВС"

        var EVENT_MARKER = "°"
    }
}