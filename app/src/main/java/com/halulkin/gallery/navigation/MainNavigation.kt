package com.halulkin.gallery.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.halulkin.gallery.ui.list.ListRoute

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = NavItem.List,
        modifier = modifier,
    ) {
        composable<NavItem.List> {
            ListRoute(
                onImageClick = { url ->
                    navController.navigate(NavItem.Details)
                },
            )
        }

        composable<NavItem.Details> {
            // TODO("Details screen")
        }
    }
}
