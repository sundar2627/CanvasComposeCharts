package com.example.composecanvascharts

import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun DrawAxisWithLabels() {

    Canvas(modifier = Modifier
        .fillMaxSize()
    ) {

       var xAxisStart1 = 0.07*size.width
       var xAxisStart2 = 0.5*size.height
       var xAxisEnd1 = 0.93*size.width
       var xAxisEnd2 = 0.5*size.height

        var xTickMarkStart = 0.496*size.height
        var xTickMarkEnd = 0.504*size.height

        var xAxisLabel = 0.52 *size.height


        //Draw X-axis
        drawLine(color = Color.Black, start = Offset(xAxisStart1.toFloat(),xAxisStart2.toFloat() ), end = Offset(xAxisEnd1.toFloat(),xAxisEnd2.toFloat()), strokeWidth = 2.dp.toPx())

        val xTotalValue = 100
        val xinterval = 10
        val xNumberOfIntervals = xTotalValue / xinterval

        val xIntervalSpacing = (xAxisEnd1 - xAxisStart1) / xNumberOfIntervals


        drawIntoCanvas { canvas ->

            val textPaint = Paint().apply {
                color = android.graphics.Color.BLACK
                textSize = 30f
                textAlign = Paint.Align.CENTER
            }

            for (i in 0 .. xNumberOfIntervals) {
                val xPosition = xAxisStart1 + (i * xIntervalSpacing)
                Log.d("NMKIOP", "$xPosition")

                // Draw tick marks
                drawLine(
                    color = Color.Black,
                    start = Offset(xPosition.toFloat(), xTickMarkStart.toFloat()),
                    end = Offset(xPosition.toFloat(), xTickMarkEnd.toFloat()),
                    strokeWidth = 2.dp.toPx()
                )

               // Draw labels below the line
                canvas.nativeCanvas.drawText(
                    "${i * xinterval}",
                    xPosition.toFloat(),
                    xAxisLabel.toFloat(), // Adjusted for better spacing
                    textPaint
                )
            }
        }

        var yAxisStart1 = 0.07*size.width
        var yAxisStart2 = 0.5*size.height

        var labelX =  0.03*size.width


        var yAxisEnd1 =  0.07*size.width
        var yAxisEnd2 = 0.03*size.height

        var yTickMarkStart =0.06*size.width
        var yTickMarkEnd = 0.08*size.width

        var yAxisLabel= 0.5 *size.height


        //Draw Y-axis
        drawLine(color = Color.Black, start = Offset(yAxisStart1.toFloat(),yAxisStart2.toFloat() ), end = Offset(yAxisEnd1.toFloat(),yAxisEnd2.toFloat()), strokeWidth = 2.dp.toPx())

        val yTotalValue = 100
        val yinterval = 10
        val yNumberOfIntervals = yTotalValue / yinterval

        val yIntervalSpacing = (yAxisStart2-yAxisEnd2) / yNumberOfIntervals


        drawIntoCanvas { canvas ->

            val textPaint1 = Paint().apply {
                color = android.graphics.Color.BLACK
                textSize = 30f
                textAlign = Paint.Align.CENTER
            }

            for (i in 0 .. yNumberOfIntervals) {
                val yPosition = (0.5*size.height) - (i * yIntervalSpacing)
                Log.d("NMKIOP1", "$yPosition")

                // Draw tick marks
                drawLine(
                    color = Color.Black,
                    start = Offset(yTickMarkStart.toFloat(), yPosition.toFloat()),
                    end = Offset(yTickMarkEnd.toFloat(), yPosition.toFloat()),
                    strokeWidth = 2.dp.toPx()
                )

                // Draw labels below the line
                canvas.nativeCanvas.drawText(
                    "${i * yinterval}",
                    labelX.toFloat(),
                  yPosition.toFloat(), // Adjusted for better spacing
                    textPaint1
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DrawBarChart() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val xAxisStart = Offset(0.07f * size.width, 0.5f * size.height)
        val xAxisEnd = Offset(0.93f * size.width, 0.5f * size.height)
        val yAxisStart = Offset(0.07f * size.width, 0.5f * size.height)
        val yAxisEnd = Offset(0.07f * size.width, 0.03f * size.height)

        // Draw X and Y axes
        drawLine(Color.Black, xAxisStart, xAxisEnd, strokeWidth = 2.dp.toPx())
        drawLine(Color.Black, yAxisStart, yAxisEnd, strokeWidth = 2.dp.toPx())

        val xTotalValue = 100
        val xInterval = 10
        val xNumberOfIntervals = xTotalValue / xInterval
        val xIntervalSpacing = (xAxisEnd.x - xAxisStart.x) / xNumberOfIntervals

        val yTotalValue = 100
        val yInterval = 10
        val yNumberOfIntervals = yTotalValue / yInterval
        val yIntervalSpacing = (yAxisStart.y - yAxisEnd.y) / yNumberOfIntervals

        val barWidth = xIntervalSpacing * 0.5f  // Adjust bar width as needed

        val barHeights = listOf(20, 40, 60, 80, 100, 60, 40, 80, 30, 70) // Sample data

        drawIntoCanvas { canvas ->
            val textPaint = Paint().apply {
                color = android.graphics.Color.BLACK
                textSize = 30f
                textAlign = Paint.Align.CENTER
            }

            for (i in 0..xNumberOfIntervals) {
                val xPosition = xAxisStart.x + (i * xIntervalSpacing)

                // Draw tick marks on X-axis
                drawLine(
                    Color.Black,
                    start = Offset(xPosition, xAxisStart.y - 4.dp.toPx()),
                    end = Offset(xPosition, xAxisStart.y + 4.dp.toPx()),
                    strokeWidth = 2.dp.toPx()
                )

                // Draw labels below the X-axis
                canvas.nativeCanvas.drawText(
                    "${i * xInterval}",
                    xPosition,
                    xAxisStart.y + 40f,
                    textPaint
                )

                // Draw bars based on data
                if (i < barHeights.size) {
                    val barHeight = (barHeights[i] / yTotalValue.toFloat()) * (yAxisStart.y - yAxisEnd.y)
                    drawRect(
                        color = Color.Blue,
                        topLeft = Offset(xAxisStart.x + (xPosition - barWidth / 2), xAxisStart.y - barHeight),
                        size = Size(barWidth, barHeight)
                    )
                }
            }
        }
    }
}
