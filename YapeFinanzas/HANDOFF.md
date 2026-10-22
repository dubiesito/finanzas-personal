# TRASPASO - App finanzas Yape (Kotlin/Compose, local)

## Contrato del proyecto
- Android nativo, Kotlin + Jetpack Compose, Redmi Note 11 Pro. minSdk 26, targetSdk 34.
- Todo local (Room/SQLite). Sin nube.
- Ingresos: NotificationListenerService leyendo notificaciones de Yape.
- Gastos: Compartir voucher.png desde Yape -> nuestra app -> OCR local (ML Kit) -> confirmar categoria -> guardar. Numero de operacion = clave anti-duplicados.
- Manual para efectivo.
- NO: Accessibility Service sobre Yape. Gmail queda para despues.
- Categorias: comida, pasajes, gasolina, extras, gustos, ahorro. Presupuestos, dashboard, promedio gasolina, CSV, tema morado mate.

## Fases
1 Base | 2 Datos (Room) | 3 Lectores (parsers) | 4 Captura | 5 Pantallas | 6 Extras | 7 APK

## Estado
- FASES HECHAS: 1 (sin compilar aun, verificar en Android Studio)
- FASE ACTUAL: 2
- Paquete: com.yapefinanzas.app
- Archivos clave: app/build.gradle.kts, MainActivity.kt, ui/theme/*, ui/navigation/AppNavigation.kt, ui/screens/PlaceholderScreen.kt
- Pendiente: Room (movimientos, categorias, periodos, presupuestos, gasolina)
