package dev.icerock.moko.widgets.style.ext

import android.graphics.drawable.GradientDrawable
import android.widget.LinearLayout
import dev.icerock.moko.widgets.style.background.Direction
import dev.icerock.moko.widgets.style.background.Orientation

internal fun Direction.toPlatformOrientation(): GradientDrawable.Orientation = when (this) {
    Direction.TOP_BOTTOM -> GradientDrawable.Orientation.TOP_BOTTOM
    Direction.TR_BL -> GradientDrawable.Orientation.TR_BL
    Direction.RIGHT_LEFT -> GradientDrawable.Orientation.RIGHT_LEFT
    Direction.BR_TL -> GradientDrawable.Orientation.BR_TL
    Direction.BOTTOM_TOP -> GradientDrawable.Orientation.BOTTOM_TOP
    Direction.BL_TR -> GradientDrawable.Orientation.BL_TR
    Direction.LEFT_RIGHT -> GradientDrawable.Orientation.LEFT_RIGHT
    Direction.TL_BR -> GradientDrawable.Orientation.TL_BR
}

internal fun Orientation.toLinearLayoutOrientation(): Int = when (this) {
    Orientation.HORIZONTAL -> LinearLayout.HORIZONTAL
    Orientation.VERTICAL -> LinearLayout.VERTICAL
}
