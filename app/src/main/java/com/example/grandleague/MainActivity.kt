package com.example.grandleague

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
 import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.Coil
import com.example.grandleague.ui.theme.GrandLeagueTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GrandLeagueTheme {
                 Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.main_purble),

                ) {
                     LeagueLogo()
                     MatchItem()
                }
            }
        }
    }
}

@Composable
fun LeagueLogo() {
Row() {

    Image(
        painter = painterResource(id = R.drawable.leaguelogo),
        contentDescription = stringResource(id = R.string.english_League_Logo)
    )



 }
 }
@Composable
fun MatchItem() {


    Row() {

        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(size = 20.dp))
                .padding(top = 50.dp)
                .background(backgroundColor.copy(alpha = 0.8f))
                .height(170.dp)
                .fillMaxSize()

                .clip(shape = RoundedCornerShape(0.dp))
            ,    contentAlignment = Alignment.Center ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                ,

         ) {
            Row(
verticalAlignment =Alignment.Top,
                horizontalArrangement = Arrangement.Start
            , modifier = Modifier.padding(bottom = 90.dp)
            ) {

                Box(

                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(20, 20, 50, 50))
                        .background(colorResource(id = R.color.main_red).copy(0.8f))
                        .height(40.dp)

                        .width(120.dp)
                        .align(alignment = Alignment.Top)

                ) {
                    Text(text = "Finished", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center, color = Color.White)
                }

            }
            Row(verticalAlignment =Alignment.Top,
                horizontalArrangement = Arrangement.Start ,
                modifier = Modifier
            ) {
                Column(  verticalArrangement = Arrangement.Top) {
                    Text(text = "Home Team" , color = Color.White)
                }
                Column() {
                    Row() {
                        Text(text = "Today", color = Color.White)

                    }
                    Row() {
                        Text(text = "0-2", color = Color.White)

                    }
                }
                Column() {
                    Text(text = "Next Team", color = Color.White)

                }
            }
                Row() {
                    Divider(color = Color.Blue, thickness = 1.dp)

                }
            Row() {
                Divider(color = Color.Blue, thickness = 1.dp)

            }

        }
    }

}




}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GrandLeagueTheme {
        LeagueLogo()
        MatchItem()
    }
}