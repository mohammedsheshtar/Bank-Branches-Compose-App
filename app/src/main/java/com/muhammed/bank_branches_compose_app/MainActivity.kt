package com.muhammed.bank_branches_compose_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.muhammed.bank_branches_compose_app.composables.BranchDetailScreen
import com.muhammed.bank_branches_compose_app.composables.BranchListScreen
import com.muhammed.bank_branches_compose_app.repository.BranchesRepository
import com.muhammed.bank_branches_compose_app.ui.theme.BankBranchesComposeAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankBranchesComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BranchNavHost(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}