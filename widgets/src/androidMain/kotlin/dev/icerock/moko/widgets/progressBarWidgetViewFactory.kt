/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.widgets

import android.widget.ProgressBar
import dev.icerock.moko.widgets.core.VFC
import dev.icerock.moko.widgets.style.applyStyle

actual var progressBarWidgetViewFactory: VFC<ProgressBarWidget> = { viewFactoryContext, widget ->
    val context = viewFactoryContext.androidContext
    val style = widget.style

    ProgressBar(context).apply {
        applyStyle(style)
    }
}