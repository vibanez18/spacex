package com.vibanez.spacex.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.vibanez.spacex.Greeting
import ru.alexpanov.spacex.theme.AppTheme
import ru.alexpanov.spacex.theme.pagerIndicatorBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val root = RootComponent(defaultComponentContext())
        setContent {
            val systemUiController = rememberSystemUiController()

            DisposableEffect(systemUiController) {
                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = false
                )
                onDispose {}
            }

            AppTheme {
                RootScreen(root)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun RootScreen(
    root: Root,
    modifier: Modifier = Modifier
) {
    val childStack by root.childStack.subscribeAsState()

    val bottomSheetState = rememberSlotModalBottomSheetState(
        root.childSlot,
        onDismiss = root::dismissSlotChild
    ) { slotChild ->
        when (val child = slotChild.instance) {
            is Root.SlotChild.SettingsChild -> SettingsScreen(component = child.component)
        }
    }

    ModalBottomSheetLayout(
        sheetState = bottomSheetState.sheetState,
        sheetContent = bottomSheetState.sheetContent.value,
        sheetShape = RoundedCornerShape(16.dp),
        sheetBackgroundColor = MaterialTheme.colors.pagerIndicatorBackground
    ) {
        Children(
            stack = childStack,
            animation = stackAnimation { from, to, direction ->
                if (direction.isFront) {
                    slide() + fade()
                } else {
                    scale(frontFactor = 1F, backFactor = 0.7F) + fade()
                }
            },
            modifier = modifier
        ) {
            when (val child = it.instance) {
                is Root.Child.RocketsChild ->
                    RocketsScreen(component = child.component)

                is Root.Child.LaunchesChild ->
                    LaunchesScreen(
                        component = child.component,
                        topBarContent = { component ->
                            LaunchesAppBar(
                                component = component,
                                contentPadding = WindowInsets.statusBars.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
                                    .asPaddingValues()
                            )
                        }
                    )
            }
        }
    }
}
