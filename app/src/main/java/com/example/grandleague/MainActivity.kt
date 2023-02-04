package com.example.grandleague

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
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
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.Coil
import com.example.grandleague.data.model.Matche
import com.example.grandleague.ui.home.HomeViewModel
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
                     MatchesList()
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
fun MatchesList( homeViewModel: HomeViewModel = viewModel()){
    val matchesList by homeViewModel.matchesresp.observeAsState()

    Column {
        LazyColumn(modifier = Modifier.padding(top = 70.dp)){
            if (matchesList?.equals(null) == true){
                item {  CircularProgressIndicator(modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center))

                }

            }
            else{
                val matchList= matchesList?.matches
                if (matchList!=null){
                    itemsIndexed(items = matchList){index, item ->
                        if (item != null) {
                            MatchItem(match = item)
                        }

                    }
                }
            }

        }

    }
}
@Composable
fun MatchItem(
    match:Matche
) {



        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(size = 20.dp))
                .padding(top = 50.dp)
                .background(backgroundColor.copy(alpha = 0.8f))
                .height(170.dp)
                .fillMaxSize()
                 .clip(shape = RoundedCornerShape(0.dp))
            ,    contentAlignment = Alignment.Center ) {

            Row(
verticalAlignment =Alignment.Top,
                horizontalArrangement = Arrangement.Start
            , modifier = Modifier.padding(bottom = 50.dp).align(TopCenter)
            ) {

                Box(

                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(0, 0, 50, 50))
                        .background(colorResource(id = R.color.main_red).copy(0.8f))
                        .height(40.dp)

                        .width(120.dp)
                        .align(alignment = Alignment.Top)

                ) {
                    Text(text = "${match.status.toString()}", modifier = Modifier.fillMaxSize().align(
                        Center), textAlign = TextAlign.Center, color = Color.White)
                }

            }
            Row(
            ) {
                Column(  Modifier.fillMaxWidth().weight(1f) ) {
                    Text(text = "${match.homeTeam?.name}" , color = colorResource(id = R.color.team_name_color),fontSize = 20.sp, modifier = Modifier.padding(10.dp), textAlign = TextAlign.Center, maxLines = 4)
                }
                Column(Modifier.fillMaxWidth().weight(1f)) {
                    Row() {
                        Text(text = "Today", color = Color.White)

                    }
                    Row() {
                        Text(text = "${match.score?.fullTime?.homeTeam} - ${match.score?.fullTime?.awayTeam}", color = Color.White,fontSize = 20.sp, modifier = Modifier.padding(10.dp), textAlign = TextAlign.Center)

                    }
                }
                Column(Modifier.fillMaxWidth().weight(1f)) {
                    Text(text = "${match.awayTeam?.name}", color = colorResource(id = R.color.team_name_color), fontSize = 20.sp, modifier = Modifier.padding(10.dp), textAlign = TextAlign.Center,maxLines = 4)

                }
            }
//
//            Row() {
//                Divider(color = Color.Blue, thickness = 1.dp)
//
//            }

        }
    }





@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GrandLeagueTheme {
        LeagueLogo()
        MatchesList()
     }
}