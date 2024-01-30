package com.hfad.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hfad.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import android.net.Uri
import androidx.compose.material3.Icon
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.hfad.myapplication.MMAModel.MmaFighter



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Create MMAView instance
                    val mmaView = MMAView()

                    // Display the FighterProfile Composable inside the Surface
                    mmaView.FighterProfile(
                        viewModel = MMAModel(MMARepository()),
                        fighter = MmaFighter("Cow"),
                        modifier = Modifier.fillMaxSize()

                        )
                }
            }
        }
    }
}



/*@Preview(showBackground = true)
@Composable
fun GreetingPreview(){
    MyApplicationTheme {
        val mmaView = MMAView()
        val mmaModel = MMAModel(MMARepository())
        mmaView.FighterProfile(
            MmaFighter(
                "Conor McGregor
        )
    }
}

*/
