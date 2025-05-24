package com.muhammed.bank_branches_compose_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammed.bank_branches_compose_app.R
import com.muhammed.bank_branches_compose_app.data.Branch
import com.muhammed.bank_branches_compose_app.data.BranchType

@Composable
fun BranchDetailScreen(branch: Branch,
                       modifier: Modifier,
                       isFavorite: Boolean,
                       onToggleFavorite: () -> Unit) {
    val defaultImage = R.drawable.nbk_kw_6c7ba085
    val uriHandler = LocalUriHandler.current
    val actualImage = branch.imageUri ?: defaultImage
    val isDefaultImage = actualImage == defaultImage


    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Image(
                painter = painterResource(id = actualImage),
                contentDescription = branch.name,
                contentScale = if (!isDefaultImage) ContentScale.Crop else ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .size(80.dp)
                    .then(if (!isDefaultImage) Modifier.clip(RoundedCornerShape(12.dp)) else Modifier)
            )

//            Image(
//                painter = painterResource(id = branch.imageUri ?: defaultImage),
//                contentDescription = branch.name,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(220.dp)
//                    .clip(RoundedCornerShape(12.dp))
//            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = branch.name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = branch.type.label,
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(
                        color = when (branch.type) {
                            BranchType.MAIN -> Color(0xFF1976D2)
                            BranchType.ATM -> Color(0xFF388E3C)
                            BranchType.SERVICE_CENTER -> Color(0xFFF57C00)
                        },
                        shape = RoundedCornerShape(50)
                    )
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))
            Divider()

            // 📋 Info Rows
            InfoRow("Address", branch.address, Icons.Default.LocationOn, tint = Color(0xFF1976D2))
            InfoRow("Phone", branch.phone, Icons.Default.Phone, tint = Color(0xFF00ACC1))
            InfoRow("Hours", branch.hours, Icons.Default.AccessTime, tint = Color(0xFFFF8F00))


            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { uriHandler.openUri(branch.location) },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1976D2),
                    contentColor = Color.White
                )
            ) {
                Icon(Icons.Default.LocationOn, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Open in Google Maps")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onToggleFavorite,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isFavorite) Color.Yellow else Color(0xFF1976D2),
                    contentColor = if (isFavorite) Color.Black else Color.White
                ),
                shape = RoundedCornerShape(50),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Favorite",
                    tint = if (isFavorite) Color.Black else Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(if (isFavorite) "Unfavorite" else "Set as Favorite")
            }

        }
    }
}

@Composable
fun InfoRow(label: String, value: String, icon: ImageVector, tint: Color = Color.DarkGray) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
    ) {
        Icon(icon, contentDescription = label, tint = tint)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "$label: $value",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
