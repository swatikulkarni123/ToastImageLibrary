package com.swa.quicknotify.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource

@Composable
fun QuickSnackbar(
    message: String,
    icon: ImageVector? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()          // Match parent width
            .padding(horizontal = 16.dp, vertical = 16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF323232),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            if (icon != null) {
                Image(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = message,
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}
