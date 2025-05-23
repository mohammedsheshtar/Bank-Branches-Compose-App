package com.muhammed.bank_branches_compose_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammed.bank_branches_compose_app.R
import com.muhammed.bank_branches_compose_app.data.Branch
import com.muhammed.bank_branches_compose_app.data.BranchType
import com.muhammed.bank_branches_compose_app.ui.theme.Blue
import com.muhammed.bank_branches_compose_app.ui.theme.DarkGrey
import com.muhammed.bank_branches_compose_app.ui.theme.Green
import com.muhammed.bank_branches_compose_app.ui.theme.Orange

@Composable
fun BranchCard(branch: Branch, modifier: Modifier = Modifier) {
    val defaultImage = R.drawable.nbk_kw_6c7ba085

    val typeColor = when (branch.type) {
        BranchType.MAIN -> Blue
        BranchType.ATM -> Green
        BranchType.SERVICE_CENTER -> Orange
    }

    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(120.dp), // Increased height
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = DarkGrey),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = branch.imageUri ?: defaultImage),
                contentDescription = branch.name,
                modifier = Modifier
                    .size(80.dp) // bigger image
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = branch.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = branch.type.label,
                    color = typeColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

