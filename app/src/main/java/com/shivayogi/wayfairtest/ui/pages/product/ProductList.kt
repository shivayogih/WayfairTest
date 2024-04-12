package com.shivayogi.wayfairtest.ui.pages.product

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shivayogi.wayfairtest.data.models.Product


@Composable
fun ProductList(
    rowIndex: Int, entries: List<Product>
) {
    Column {
        Row {
            ProductEntry(
                entry = entries[rowIndex * 2], modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            if (entries.size >= rowIndex * 2 + 2) {
                ProductEntry(
                    entry = entries[rowIndex * 2 + 1], modifier = Modifier.weight(1f)
                )
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }


}


@Composable
fun ProductEntry(
    entry: Product, modifier: Modifier = Modifier
) {
    val defaultDominantColor = MaterialTheme.colorScheme.surface
    val dominantColor by remember {
        mutableStateOf(defaultDominantColor)
    }

    Box(contentAlignment = Alignment.Center,
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(
                Brush.verticalGradient(
                    listOf(
                        dominantColor, defaultDominantColor
                    )
                )
            )
            .clickable {

            }) {
        Column {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary, modifier = Modifier.scale(0.5f)
            )
            entry.name?.let {
                Text(
                    text = it,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

            }


            entry.name?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            entry.tagline?.let {
                Text(
                    text = "Tagline:$it",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )
            }

            entry.rating?.let {
                Text(
                    text = "Rating: $it.roundToInt() ",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }

            entry.date?.let {
                Text(
                    text = "Date:$it", fontSize = 12.sp, color = Color.Black
                )
            }

        }
    }
}
