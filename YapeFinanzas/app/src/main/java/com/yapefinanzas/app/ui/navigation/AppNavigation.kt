package com.yapefinanzas.app.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yapefinanzas.app.ui.screens.PlaceholderScreen

private enum class Destino(val ruta: String, val titulo: String, val icono: ImageVector) {
    Inicio("inicio", "Inicio", Icons.Filled.Home),
    Movimientos("movimientos", "Movimientos", Icons.AutoMirrored.Filled.List),
    Presupuestos("presupuestos", "Presupuestos", Icons.Filled.Star),
    Gasolina("gasolina", "Gasolina", Icons.Filled.Place),
    Ajustes("ajustes", "Ajustes", Icons.Filled.Settings),
}

@Composable
fun AppNavigation() {
    val nav = rememberNavController()
    val actual by nav.currentBackStackEntryAsState()
    val rutaActual = actual?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                Destino.entries.forEach { d ->
                    NavigationBarItem(
                        selected = rutaActual == d.ruta,
                        onClick = {
                            nav.navigate(d.ruta) {
                                popUpTo(nav.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(d.icono, contentDescription = d.titulo) },
                        label = { Text(d.titulo) },
                    )
                }
            }
        },
    ) { padding ->
        NavHost(
            navController = nav,
            startDestination = Destino.Inicio.ruta,
            modifier = Modifier.padding(padding),
        ) {
            Destino.entries.forEach { d ->
                composable(d.ruta) { PlaceholderScreen(d.titulo) }
            }
        }
    }
}
