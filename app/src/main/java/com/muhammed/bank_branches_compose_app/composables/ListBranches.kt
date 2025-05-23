package com.muhammed.bank_branches_compose_app.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.muhammed.bank_branches_compose_app.data.Branch

@Composable
fun BranchListScreen(branches: List<Branch>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(branches) { branch ->
            BranchCard(branch = branch)
        }
    }
}
