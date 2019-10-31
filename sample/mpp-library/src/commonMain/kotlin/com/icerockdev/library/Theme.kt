/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.icerockdev.library

import com.icerockdev.library.screen.CryptoProfileScreen
import dev.icerock.moko.graphics.Color
import dev.icerock.moko.widgets.ButtonWidget
import dev.icerock.moko.widgets.InputWidget
import dev.icerock.moko.widgets.LinearWidget
import dev.icerock.moko.widgets.SingleChoiceWidget
import dev.icerock.moko.widgets.TextWidget
import dev.icerock.moko.widgets.buttonStyle
import dev.icerock.moko.widgets.core.WidgetScope
import dev.icerock.moko.widgets.inputStyle
import dev.icerock.moko.widgets.linearStyle
import dev.icerock.moko.widgets.setButtonStyle
import dev.icerock.moko.widgets.singleChoiceStyle
import dev.icerock.moko.widgets.style.background.Background
import dev.icerock.moko.widgets.style.background.Corners
import dev.icerock.moko.widgets.style.background.Direction
import dev.icerock.moko.widgets.style.background.Orientation
import dev.icerock.moko.widgets.style.background.Shape
import dev.icerock.moko.widgets.style.background.ShapeType
import dev.icerock.moko.widgets.style.view.Colors
import dev.icerock.moko.widgets.style.view.FontStyle
import dev.icerock.moko.widgets.style.view.MarginValues
import dev.icerock.moko.widgets.style.view.PaddingValues
import dev.icerock.moko.widgets.style.view.SizeSpec
import dev.icerock.moko.widgets.style.view.TextStyle
import dev.icerock.moko.widgets.style.view.WidgetSize
import dev.icerock.moko.widgets.style.view.rgba
import dev.icerock.moko.widgets.textStyle

object Theme {
    object Color {
        val white = Color(0xFF, 0xFF, 0xFF, 0xFF)
        val redError = Color(0xFF, 0x66, 0x66, 0xFF)
        val grayText = Color(0x26, 0x26, 0x28, 0xFF)
        val gray2Text = Color(0x4A, 0x4A, 0x4A, 0xFF)
        val lightGrayText = rgba(38, 38, 40, 0.4)
        val grayUnderline = Color(0xDD, 0xDD, 0xDD, 0xFF)
    }

    val errorTextStyle: TextStyle = TextStyle(
        size = 12,
        color = Color.redError,
        fontStyle = FontStyle.MEDIUM // Roboto-regular weight 400
    )

    val inputStyle: InputWidget.Style = InputWidget.Style(
        size = WidgetSize(
            width = SizeSpec.AS_PARENT,
            height = SizeSpec.WRAP_CONTENT
        ),
        textStyle = TextStyle(
            size = 15,
            color = Color.grayText,
            fontStyle = FontStyle.MEDIUM // Roboto-medium weight 500
        ),
        labelTextStyle = TextStyle(
            size = 12,
            color = Color.gray2Text,
            fontStyle = FontStyle.MEDIUM // Roboto-regular weight 400
        ),
        errorTextStyle = errorTextStyle,
        underLineColor = Color.grayUnderline,
        padding = PaddingValues(
            padding = 16f
        ),
        margins = MarginValues(
            bottom = 8f
        ),
        background = null
    )

    val buttonStyle: ButtonWidget.Style = ButtonWidget.Style(
        size = WidgetSize(
            width = SizeSpec.AS_PARENT,
            height = 50
        ),
        textStyle = TextStyle(
            size = 17,
            color = Color.white,
            fontStyle = FontStyle.MEDIUM // Roboto-medium weight 500
        ),
        isAllCaps = false,
        margins = MarginValues(),
        background = Background(
            colors = listOf(0xffb83af3, 0xff6950fb),
            colorsDisabled = listOf(0x80b83af3, 0x806950fb),
            direction = Direction.TR_BL,
            shape = Shape(
                type = ShapeType.RECTANGLE,
                corners = Corners(radii = 16f)
            )
        )
    )

    val headerTextStyle: TextStyle = TextStyle(
        size = 12,
        color = Color.lightGrayText,
        fontStyle = FontStyle.MEDIUM // Roboto-medium weight 500
    )

    val headerStyle: TextWidget.Style = TextWidget.Style(
        textStyle = headerTextStyle,
        padding = PaddingValues(),
        margins = MarginValues(
            bottom = 8f
        )
    )

    val profileContainerStyle: LinearWidget.Style = LinearWidget.Style(
        background = null,
        orientation = Orientation.VERTICAL,
        size = WidgetSize(
            width = SizeSpec.AS_PARENT,
            height = SizeSpec.WRAP_CONTENT
        ),
        padding = PaddingValues(16f)
    )

    val singleChoiceStyle: SingleChoiceWidget.Style = SingleChoiceWidget.Style(
        size = WidgetSize(
            width = SizeSpec.AS_PARENT,
            height = SizeSpec.WRAP_CONTENT
        ),
        textStyle = TextStyle(
            size = 15,
            color = Color.grayText,
            fontStyle = FontStyle.MEDIUM // Roboto-medium weight 500
        ),
        labelTextStyle = TextStyle(
            size = 12,
            color = Color.gray2Text,
            fontStyle = FontStyle.MEDIUM // Roboto-regular weight 400
        ),
        margins = MarginValues(
            bottom = 8f
        ),
        dropDownTextColor = null,
        underlineColor = Color.grayUnderline,
        dropDownBackground = null
    )

    val socialWidgetScope = WidgetScope {
        this.inputStyle = Theme.inputStyle
        this.textStyle = Theme.headerStyle
        this.buttonStyle = Theme.buttonStyle
        this.linearStyle = Theme.profileContainerStyle
        this.singleChoiceStyle = Theme.singleChoiceStyle
    }

    val mcommerceWidgetScope = WidgetScope {
        this.inputStyle = Theme.inputStyle.copy(
            textStyle = TextStyle(
                size = 16,
                color = Color(0x4B, 0x4F, 0x4E, 0xFF),
                fontStyle = FontStyle.MEDIUM // ProximaNova-Semibold weight 600
            ),
            labelTextStyle = TextStyle(
                size = 12,
                color = Color(0x99, 0x9E, 0x9C, 0xFF), // #999e9cff
                fontStyle = FontStyle.MEDIUM // ProximaNova-Regular weight 400
            ),
            underLineColor = Color(0x00, 0x00, 0x00, 0x1F) // #0000001f
        )
        this.buttonStyle = Theme.buttonStyle.copy(
            textStyle = TextStyle(
                size = 17,
                color = Color.white,
                fontStyle = FontStyle.MEDIUM // Roboto-medium weight 500
            ),
            background = Background(
                color = 0xff00492c, //#00492cff
                colorDisabled = 0x8000492c,
                shape = Shape(
                    type = ShapeType.RECTANGLE,
                    corners = Corners(radii = 4f)
                )
            )
        )
        this.linearStyle = Theme.profileContainerStyle
    }

    val cryptoWidgetScope = WidgetScope {
        inputStyle = Theme.inputStyle.copy(
            textStyle = TextStyle(
                size = 16,
                color = Colors.white, // #ffffffff
                fontStyle = FontStyle.MEDIUM // Gotham Pro
            ),
            labelTextStyle = TextStyle(
                size = 12,
                color = Color(0xA6, 0xA6, 0xA6, 0xFF), // #a6a6a6ff
                fontStyle = FontStyle.MEDIUM // Gotham Pro
            ),
            underLineColor = Colors.white
        )
        textStyle = Theme.headerStyle.copy(
            textStyle = TextStyle(
                size = 14,
                color = Colors.white, // #ffffffff
                fontStyle = FontStyle.MEDIUM // Gotham Pro
            )
        )
        buttonStyle = Theme.buttonStyle.copy(
            size = WidgetSize(
                width = SizeSpec.AS_PARENT,
                height = 48
            ),
            background = Background(
                color = 0xFF1375f8,
                shape = Shape(
                    type = ShapeType.RECTANGLE,
                    corners = Corners(radii = 22f)
                )
            )
        )
        setButtonStyle(
            buttonStyle.copy(
                background = Background(
                    color = 0xFF303030,
                    shape = Shape(
                        type = ShapeType.RECTANGLE,
                        corners = Corners(radii = 22f)
                    )
                )
            ), CryptoProfileScreen.Id.TryDemoButton
        )
        linearStyle = Theme.profileContainerStyle.copy(
            background = Background(
                color = Colors.black.argb
            )
        )
        singleChoiceStyle = Theme.singleChoiceStyle
    }
}
