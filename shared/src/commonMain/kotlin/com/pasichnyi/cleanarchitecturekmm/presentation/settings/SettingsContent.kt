package com.pasichnyi.cleanarchitecturekmm.presentation.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.pasichnyi.cleanarchitecturekmm.presentation.icons.StorageImageVector
import com.softartdev.themepref.PreferableMaterialTheme.themePrefs
import com.softartdev.themepref.ThemePreferenceItem

@Composable
internal fun SettingsContent(component: SettingsComponent, modifier: Modifier = Modifier) {
    val model by component.model.subscribeAsState()
    Column {
        // Placeholder using library. Can later be replaced with own implementation
        PreferenceCategory(title = "Appearance")
        ThemePreferenceItem()
        PreferenceCategory(title = "Storage")
        Text("Local DB contains ${model.localArticlesCount} articles")
        ClearCacheItem(onClick = component::clearCache, title = "Clear local DB")
        themePrefs.showDialogIfNeed()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun ClearCacheItem(onClick: () -> Unit, title: String) {
    ListItem(
        modifier = Modifier.clickable(onClick = onClick),
        icon = {
            Icon(
                imageVector = StorageImageVector,
                contentDescription = title,
                // TODO("Add dimensions")
                modifier = Modifier.width(24.dp).height(24.dp)
            )
        },
        text = { Text(text = title) },
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun PreferenceCategory(title: String, vector: ImageVector? = null) {
    ListItem(
        text = {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.secondaryVariant
            )
        }
    )
}
