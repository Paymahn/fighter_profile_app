package com.hfad.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import com.hfad.myapplication.MMAModel.MmaFighter
import androidx.compose.material3.Scaffold
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import coil.compose.rememberImagePainter
import com.hfad.myapplication.MMAModel
import com.hfad.myapplication.MMARepository
import androidx.compose.runtime.livedata.observeAsState



class MMAView {


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FighterProfile(viewModel: MMAModel, fighter: MmaFighter, modifier: Modifier = Modifier) {
        val googleImage by viewModel.imageUrl.observeAsState()
        val imageUrl = googleImage?.link

        Scaffold(
            modifier = modifier,
            topBar = {
                Column {
                    Text(text = fighter.name)
                }
            },
            content = { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {
                    @OptIn(coil.annotation.ExperimentalCoilApi::class)
                    Image(
                        painter = rememberImagePainter(imageUrl),
                        contentDescription = "Fighter Image"
                    )
                }
            }
        )
    }
}



