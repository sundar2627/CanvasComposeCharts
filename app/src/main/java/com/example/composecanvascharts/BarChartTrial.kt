package com.example.composecanvascharts

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp


@Composable
fun DrawXAxisWithLabels() {
    val totalValue = 100
    val interval = 10
    val numberOfIntervals = totalValue / interval

    Canvas(modifier = Modifier.fillMaxWidth().height(100.dp)) {
        val lineHeight = size.height - 20.dp.toPx()
        val intervalSpacing = size.width / numberOfIntervals.toFloat()

        // Draw X-axis
        drawLine(
            color = Color.Green,
            start = Offset(0f, lineHeight),
            end = Offset(size.width, lineHeight),
            strokeWidth = 2.dp.toPx()
        )

        // Draw intervals and labels
        drawIntoCanvas { canvas ->

            val textPaint = Paint().apply {
                color = android.graphics.Color.BLACK
                textSize = 30f
                textAlign = Paint.Align.CENTER
            }

            for (i in 0..numberOfIntervals) {
                val xPosition = i * intervalSpacing

                // Draw tick marks
                drawLine(
                    color = Color.Green,
                    start = Offset(xPosition, lineHeight - 10f),
                    end = Offset(xPosition, lineHeight),
                    strokeWidth = 2.dp.toPx()
                )

                // Draw labels below the line
                canvas.nativeCanvas.drawText(
                    "${i * interval}",
                    xPosition,
                    lineHeight + 40f, // Adjusted for better spacing
                    textPaint
                )
            }
        }
    }
}