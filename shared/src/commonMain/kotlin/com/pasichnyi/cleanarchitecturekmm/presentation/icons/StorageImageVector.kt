package com.pasichnyi.cleanarchitecturekmm.presentation.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

// TODO("Place Builder in a separate object")
val StorageImageVector: ImageVector
    get() {
        if (_storageFill0Wght400Grad0Opsz48 != null) {
            return _storageFill0Wght400Grad0Opsz48!!
        }
        _storageFill0Wght400Grad0Opsz48 = Builder(
            name = "StorageFill0Wght400Grad0Opsz48",
            defaultWidth = 48.0.dp, defaultHeight = 48.0.dp, viewportWidth = 960.0f,
            viewportHeight = 960.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(120.0f, 800.0f)
                verticalLineToRelative(-148.0f)
                horizontalLineToRelative(720.0f)
                verticalLineToRelative(148.0f)
                lineTo(120.0f, 800.0f)
                close()
                moveTo(180.0f, 762.0f)
                horizontalLineToRelative(72.0f)
                verticalLineToRelative(-72.0f)
                horizontalLineToRelative(-72.0f)
                verticalLineToRelative(72.0f)
                close()
                moveTo(120.0f, 308.0f)
                verticalLineToRelative(-148.0f)
                horizontalLineToRelative(720.0f)
                verticalLineToRelative(148.0f)
                lineTo(120.0f, 308.0f)
                close()
                moveTo(180.0f, 270.0f)
                horizontalLineToRelative(72.0f)
                verticalLineToRelative(-72.0f)
                horizontalLineToRelative(-72.0f)
                verticalLineToRelative(72.0f)
                close()
                moveTo(120.0f, 554.0f)
                verticalLineToRelative(-148.0f)
                horizontalLineToRelative(720.0f)
                verticalLineToRelative(148.0f)
                lineTo(120.0f, 554.0f)
                close()
                moveTo(180.0f, 516.0f)
                horizontalLineToRelative(72.0f)
                verticalLineToRelative(-72.0f)
                horizontalLineToRelative(-72.0f)
                verticalLineToRelative(72.0f)
                close()
            }
        }
            .build()
        return _storageFill0Wght400Grad0Opsz48!!
    }

private var _storageFill0Wght400Grad0Opsz48: ImageVector? = null
