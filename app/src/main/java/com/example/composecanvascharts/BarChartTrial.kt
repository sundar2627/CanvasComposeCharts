package com.example.composecanvascharts

import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun DrawXAxisWithLabels() {
    val totalValue = 100
    val interval = 10
    val numberOfIntervals = totalValue / interval

    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(500.dp)) {
        val lineHeight = size.height - 200.dp.toPx()
       // val lineHeight = size.height - 200.dp.toPx()
        var startXPosition = 50f
        var endPosition = size.width - 50f

        val intervalSpacing = (endPosition - startXPosition) / numberOfIntervals

        // Draw X-axis (Base line)
        drawLine(
            color = Color.Black,
            start = Offset(50f, lineHeight),
            end = Offset(size.width - 50f, lineHeight),
            strokeWidth = 2.dp.toPx()
        )

        // Draw intervals and labels
        drawIntoCanvas { canvas ->

            val textPaint = Paint().apply {
                color = android.graphics.Color.BLACK
                textSize = 30f
                textAlign = Paint.Align.CENTER
            }

            for (i in 0 .. numberOfIntervals) {
                val xPosition = startXPosition + (i * intervalSpacing)
                Log.d("YUIO", "i=$i --$xPosition")   // 1180

                // Draw tick marks
                drawLine(
                    color = Color.Black,
                    start = Offset(xPosition, lineHeight - 10f),
                    end = Offset(xPosition, lineHeight + 10f),
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

        // Draw Y-axis (Base line)
        drawLine(
            color = Color.Black,
            start = Offset(50f, lineHeight),
            end = Offset(50f, lineHeight-500.dp.toPx()),
            strokeWidth = 2.dp.toPx()
        )

        val ytotalValue = 100
        val yInterval = 10
        val yNumberOfIntervals = ytotalValue / yInterval

        Log.d("yjuio", "$ytotalValue--$yInterval--$yNumberOfIntervals ")

        drawIntoCanvas { canvas ->

            val textPaint1 = Paint().apply {
                color = android.graphics.Color.BLACK
                textSize = 30f
                textAlign = Paint.Align.CENTER
            }

            for (i in 0 ..yNumberOfIntervals.toInt()) {
                val yPosition = lineHeight - (i * yNumberOfIntervals)
                Log.d("yjuio1", "i=$i --$yPosition")   // 1180

                // Draw tick marks
                drawLine(
                    color = Color.Green,
                    start = Offset(50f, yPosition),
                    end = Offset(50f, yPosition),
                    strokeWidth = 2.dp.toPx()
                )

                // Draw labels below the line
                canvas.nativeCanvas.drawText(
                    "${i * yInterval}",
                    yPosition,
                    lineHeight + 40f, // Adjusted for better spacing
                    textPaint1
                )
            }
        }





    }
}

@Composable
fun DrawYAxisWithLabels() {


}
