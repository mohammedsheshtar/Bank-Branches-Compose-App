package com.muhammed.bank_branches_compose_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.muhammed.bank_branches_compose_app.ui.theme.LightYellow
import com.muhammed.bank_branches_compose_app.ui.theme.Orange
import com.muhammed.bank_branches_compose_app.ui.theme.TangyYellow

@Composable
fun BranchCard(branch: Branch,
               modifier: Modifier = Modifier,
               isFavorite: Boolean,
               onClick: () -> Unit) {
    val defaultImage = R.drawable.nbk_kw_6c7ba085
    val actualImage = branch.imageUri ?: defaultImage
    val isDefaultImage = actualImage == defaultImage

    val typeColor = when (branch.type) {
        BranchType.MAIN -> Blue
        BranchType.ATM -> Green
        BranchType.SERVICE_CENTER -> Orange
    }

    Card(
        onClick = onClick,
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = if (isFavorite) LightYellow else DarkGrey),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = actualImage),
                contentDescription = branch.name,
                contentScale = if (!isDefaultImage) ContentScale.Crop else ContentScale.Fit,
                modifier = Modifier
                    .size(80.dp)
                    .then(if (!isDefaultImage) Modifier.clip(RoundedCornerShape(12.dp)) else Modifier)
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
                if (isFavorite) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Favorite",
                        tint = TangyYellow,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}


