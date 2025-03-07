package com.example.composecanvascharts

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val defaultMaxHeight = 300.dp

@Composable
fun BarChartScreen(
) {

    Column {
        barChartSetup(
            modifier = Modifier.padding(20.dp),
            values = barChartInputsPercent,
            defaultMaxHeight
        )
       // DrawXAxisWithLabels()
    }
}

@Composable
fun barChartSetup(
    modifier: Modifier = Modifier,
    values: List<Float>,
    maxHeight: Dp
){

    assert(values.isNotEmpty()) { "Input values are empty" }

    val density = LocalDensity.current
    val strokeWidth = with(density) { 1.dp.toPx() }

    Row (modifier.then(

        Modifier
            .fillMaxWidth()
            .height(maxHeight)
            .drawBehind {

                /*  //Draw X-axis
                drawLine(color =androidx.compose.ui.graphics.Color.Red, start = Offset(0f,size.height),end= Offset(size.width,size.height), strokeWidth = 2.dp.toPx())

                //Draw Y-axis
                drawLine(color =androidx.compose.ui.graphics.Color.Red, start = Offset(0f,size.height),end= Offset(0f,0f), strokeWidth = 2.dp.toPx())*/


                //Draw X-axis
                drawLine(
                    color = Color.Green,
                    start = Offset(0f, 0f),
                    end = Offset(0f, size.height),
                    strokeWidth = 2.dp.toPx()
                )

                //Draw Y-axis
                drawLine(
                    color = Color.Green,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 2.dp.toPx()
                )

            }
    ),   verticalAlignment = Alignment.Bottom){

        values.forEach { item ->
            Log.d("GTYHU", "$item")
            Bar(
                value = item,
                color = Color.Magenta,
                maxHeight = maxHeight
            )
        }

    }
}


@Composable
private fun RowScope.Bar(
    value: Float,
    color: Color,
    maxHeight: Dp
) {

    Log.d("GTYHU", "Bar: $value--${maxHeight.value / 100}--${value * maxHeight.value / 100}")
    val itemHeight = remember(value) { value * maxHeight.value / 100 }

    Spacer(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .height(itemHeight.dp)
            .weight(1f)
            .background(color)
    )
}



