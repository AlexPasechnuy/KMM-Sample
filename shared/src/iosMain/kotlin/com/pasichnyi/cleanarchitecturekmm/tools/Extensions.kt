package com.pasichnyi.cleanarchitecturekmm.tools

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap

actual fun ByteArray.toImageBitmap(): ImageBitmap {
    return org.jetbrains.skia.Image.makeFromEncoded(this).toComposeImageBitmap()
}