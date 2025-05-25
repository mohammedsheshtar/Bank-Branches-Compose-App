package com.muhammed.bank_branches_compose_app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.muhammed.bank_branches_compose_app.composables.BranchDetailScreen
import com.muhammed.bank_branches_compose_app.composables.BranchListScreen
import com.muhammed.bank_branches_compose_app.repository.BranchesRepository

enum class NavRoutesEnum(val value: String) {
    NAV_ROUTE_LIST_BRANCHES_SCREEN("listBranches"),
    NAV_ROUTE_BRANCH_DETAILS_SCREEN("branchDetails"),
}

@Composable
fun BranchNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavRoutesEnum.NAV_ROUTE_LIST_BRANCHES_SCREEN.value
) {
    val branchesState by rememberSaveable { mutableStateOf(BranchesRepository.branches) }
    var favoriteBranchIds by rememberSaveable { mutableStateOf(setOf<Int>()) }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavRoutesEnum.NAV_ROUTE_LIST_BRANCHES_SCREEN.value) {
            BranchListScreen(
                branchesState,
                modifier = modifier,
                favoriteBranchIds = favoriteBranchIds,
                onClicked = { branch ->
                    navController.navigate("${NavRoutesEnum.NAV_ROUTE_BRANCH_DETAILS_SCREEN.value}/${branch.id}")
                }
            )
        }

        composable("${NavRoutesEnum.NAV_ROUTE_BRANCH_DETAILS_SCREEN.value}/{branchId}") { backStackEntry ->
            val branchId = backStackEntry.arguments?.getString("branchId")?.toIntOrNull() ?: "branch not found"
            val selectedBranch = branchesState.find { it.id == branchId }

            selectedBranch?.let {
                BranchDetailScreen(
                    branch = it,
                    modifier = modifier,
                    isFavorite = it.id in favoriteBranchIds,
                    onToggleFavorite = {
                        favoriteBranchIds = if (it.id in favoriteBranchIds) {
                            favoriteBranchIds - it.id
                        } else {
                            favoriteBranchIds + it.id
                        }
                    }
                )
            }
        }
    }
}