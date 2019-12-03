/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.icerockdev.library.universal

import com.icerockdev.library.MR
import dev.icerock.moko.fields.FormField
import dev.icerock.moko.fields.liveBlock
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import dev.icerock.moko.widgets.InputWidget
import dev.icerock.moko.widgets.button
import dev.icerock.moko.widgets.constraint
import dev.icerock.moko.widgets.core.Image
import dev.icerock.moko.widgets.core.Theme
import dev.icerock.moko.widgets.image
import dev.icerock.moko.widgets.input
import dev.icerock.moko.widgets.screen.Args
import dev.icerock.moko.widgets.screen.WidgetScreen
import dev.icerock.moko.widgets.screen.getViewModel
import dev.icerock.moko.widgets.style.view.SizeSpec
import dev.icerock.moko.widgets.style.view.WidgetSize

class LoginScreen(
    private val theme: Theme
) : WidgetScreen<Args.Empty>() {

    override fun createContentWidget() = with(theme) {
        val viewModel = getViewModel { LoginViewModel() }

        constraint(size = WidgetSize.AsParent) {
            val logoImage = +image(
                size = WidgetSize.Const(SizeSpec.AsParent, SizeSpec.WrapContent),
                image = const(Image.resource(MR.images.logo))
            )

            val loginInput = +input(
                size = WidgetSize.WidthAsParentHeightWrapContent,
                id = Id.LoginInputId,
                label = const("login".desc() as StringDesc),
                field = viewModel.loginField
            )
            val passwordInput = +input(
                size = WidgetSize.WidthAsParentHeightWrapContent,
                id = Id.PasswordInputId,
                label = const("password".desc() as StringDesc),
                field = viewModel.passwordField
            )
            val submitButton = +button(
                size = WidgetSize.Const(SizeSpec.AsParent, SizeSpec.Exact(50f)),
                text = const("submit".desc() as StringDesc),
                onTap = viewModel::onSubmitPressed
            )

            constraints {
                passwordInput centerYToCenterY root
                passwordInput leftRightToLeftRight root

                loginInput bottomToTop passwordInput
                loginInput leftRightToLeftRight root

                submitButton topToBottom passwordInput
                submitButton leftRightToLeftRight root

                // logo image height must be automatic ?
                logoImage leftRightToLeftRight root
                logoImage.verticalCenterBetween(
                    top = root.top,
                    bottom = loginInput.top
                )
            }
        }
    }

    object Id {
        object LoginInputId : InputWidget.Id
        object PasswordInputId : InputWidget.Id
    }
}

class LoginViewModel : ViewModel() {
    val loginField = FormField<String, StringDesc>("", liveBlock { null })
    val passwordField = FormField<String, StringDesc>("", liveBlock { null })

    fun onSubmitPressed() {

    }
}
