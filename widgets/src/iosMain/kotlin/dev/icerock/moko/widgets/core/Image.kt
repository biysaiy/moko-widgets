/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.widgets.core

import dev.icerock.moko.media.Bitmap
import dev.icerock.moko.resources.ImageResource
import dev.icerock.plural.dataTask
import platform.Foundation.NSURL
import platform.Foundation.NSURLSession
import platform.Foundation.NSURLSessionConfiguration
import platform.UIKit.UIImage
import platform.UIKit.UIImageView


actual abstract class Image {

    abstract fun apply(imageView: UIImageView)

    actual companion object {
        actual fun resource(imageResource: ImageResource): Image {
            return ResourceImage(imageResource)
        }

        actual fun network(url: String): Image {
            return NetworkImage(url)
        }

        actual fun bitmap(bitmap: Bitmap): Image {
            return BitmapImage(bitmap)
        }
    }
}

class ResourceImage(
    private val imageResource: ImageResource
) : Image() {
    override fun apply(imageView: UIImageView) {
        imageView.image = imageResource.toUIImage()
    }
}

class BitmapImage(
    private val bitmap: Bitmap
) : Image() {
    override fun apply(imageView: UIImageView) {
        imageView.image = bitmap.image
    }
}

// TODO add https://github.com/SDWebImage/SDWebImage to cache images
class NetworkImage(
    private val url: String
) : Image() {
    override fun apply(imageView: UIImageView) {
        imageView.image = null

        try {
            val tag = url.hashCode().toLong()
            imageView.tag = tag
            val nsUrl = NSURL.URLWithString(url) ?: return

            val config = NSURLSessionConfiguration.defaultSessionConfiguration().apply {
                timeoutIntervalForRequest = 60.0
            }
            dataTask(
                session = NSURLSession.sessionWithConfiguration(config),
                url = nsUrl
            ) { data, _, error ->
                if (error != null) {
                    println(error)
                    return@dataTask
                }
                if (data == null) return@dataTask

                if (imageView.tag != tag) return@dataTask

                imageView.image = UIImage.imageWithData(data)
            }?.resume()
        } catch (error: Throwable) {
            error.printStackTrace()
        }
    }
}
