package com.example.composecanvascharts

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composecanvascharts.ui.theme.ComposeCanvasChartsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            ComposeCanvasChartsTheme {

                NavHost(navController = navController, startDestination = "mainUI") {
                    composable("mainUI") { MainUI(navController) }
               //    composable("barChartScreen") { BarChartScreen() }
                   composable("barChartScreen") { DrawXAxisWithLabels() }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainUI() {
    MainUI() // Uses default navController for preview
}


@Composable
fun MainUI(navController: NavController = rememberNavController()) {
    Column (modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)){

        val context = LocalContext.current

        /*Toast.makeText(
            context,
            "Barchart Click",
            Toast.LENGTH_SHORT
        ).show()*/

        Button(
            onClick = {
                navController.navigate("barChartScreen") // Navigates correctly

            },
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Red
            ),
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 16.dp)
                .align(Alignment.CenterHorizontally)
        ){
            Text(text = "Bar Chart", textAlign = TextAlign.Center )

        }

        Button(
            onClick = {
            },
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Green
            ),
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 16.dp)
                .align(Alignment.CenterHorizontally)
        ){
            Text(text = "Pie Chart", textAlign = TextAlign.Center)
        }

    }

}


