package com.pasichnyi.cleanarchitecturekmm.presentation.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import com.pasichnyi.cleanarchitecturekmm.tools.toImageBitmap
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.utils.io.core.use

@Composable
internal fun AsyncImage(
    url: String,
    contentDescription: String? = "",
    modifier: Modifier = Modifier
) {
    var image by remember { mutableStateOf<ImageBitmap?>(null) }
    image?.let {
        androidx.compose.foundation.Image(
            modifier = modifier,
            bitmap = it,
            contentDescription = contentDescription
        )
    } ?: run {
        Spacer(modifier = modifier)
    }
    LaunchedEffect(key1 = url, block = {
        try {
            val bytes: ByteArray = HttpClient().use { client ->
                client.get(url).body()
            }
            image = bytes.toImageBitmap()
        } catch (_: Exception) {
        }
    })
}