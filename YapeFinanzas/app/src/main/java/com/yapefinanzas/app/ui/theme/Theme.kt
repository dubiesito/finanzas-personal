package com.yapefinanzas.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = Purple40,
    onPrimary = SurfaceLight,
    primaryContainer = PurpleContainerLight,
    onPrimaryContainer = PurpleDark,
    background = SurfaceLight,
    surface = SurfaceLight,
)

private val DarkColors = darkColorScheme(
    primary = Purple80,
    onPrimary = PurpleDark,
    primaryContainer = PurpleContainerDark,
    onPrimaryContainer = Purple80,
    background = SurfaceDark,
    surface = SurfaceDark,
)

@Composable
fun FinanzasTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        content = content,
    )
}
