package com.example.grandleague

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
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
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MatchesList(homeViewModel: HomeViewModel = viewModel()) {
    val matchesList by homeViewModel.matchesresp.observeAsState()

    Column(modifier = Modifier) {

        val matchList = matchesList?.matches
        if (matchList != null) {


            LazyColumn(
                modifier = Modifier
                    .padding(top = 70.dp)
                    .padding(horizontal = 20.dp),

                contentPadding = PaddingValues(bottom = 40.dp)
            ) {
                if (matchesList?.equals(null) == true) {

                    item {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(align = Alignment.Center)
                        )

                    }

                } else {
                    var sortedMatchList = matchList.groupBy { it!!.utcDate!!.split("T").get(0) }


                    sortedMatchList.forEach() {
                        stickyHeader {
                            Text(
                                text = "${it.key}",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(CenterHorizontally)
                                    .background(
                                        colorResource(id = R.color.main_purble)
                                    ),
                                color = Color.White,
                                fontSize = 20.sp
                            )
                        }
                        itemsIndexed(items = it.value) { index, item ->
                            if (item != null) {
                                MatchItem(
                                    match = item,
                                    league = matchesList!!.competition!!.name.toString()
                                )
                            }

                        }

                    }
                }
            }
        }
    }

}


@Composable
fun MatchItem(
    match: Matche,
    league: String
) {


    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(size = 20.dp))
            .padding(top = 50.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.white).copy(0.1f),
                        colorResource(id = R.color.grey).copy(0.1f)
                    )
                )
            )
            .height(170.dp)
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(4.dp, 4.dp, 4.dp, 4.dp)),
        contentAlignment = Alignment.Center
    ) {

        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(bottom = 50.dp)
                .align(TopCenter)
        ) {

            Box(

                modifier = Modifier
                    .clip(shape = RoundedCornerShape(0, 0, 50, 50))
                    .background(colorResource(id = R.color.main_red).copy(0.8f))
                    .height(30.dp)

                    .width(120.dp)
                    .align(alignment = Alignment.Top)

            ) {
                Text(
                    text = "${match.status.toString()}", modifier = Modifier
                        .fillMaxSize()
                        .align(
                            Center
                        ), textAlign = TextAlign.Center, color = Color.White
                )
            }

        }
        Row(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .align(CenterVertically)
            ) {
                Text(
                    text = "${match.homeTeam?.name}",
                    color = colorResource(id = R.color.team_name_color),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(5.dp),
                    textAlign = TextAlign.Center,
                    maxLines = 4,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "${match.utcDate?.split("T")?.get(0)}",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 10.sp,
                        modifier = Modifier.fillMaxWidth()
                    )

                }
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "${match.score?.fullTime?.homeTeam} - ${match.score?.fullTime?.awayTeam}",
                        color = Color.White,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )

                }
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .align(CenterVertically)
            ) {
                Text(
                    text = "${match.awayTeam?.name}",
                    color = colorResource(id = R.color.team_name_color),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(5.dp),
                    textAlign = TextAlign.Center,
                    maxLines = 4,
                    fontWeight = FontWeight.Bold
                )

            }
        }

        Row(
            modifier = Modifier
                .align(BottomCenter)
                .padding(bottom = 30.dp)
                .width(300.dp)
                .alpha(0.2f)
        ) {
            Divider(color = Color.White, thickness = 1.dp)

        }
        Row(
            modifier = Modifier
                .align(BottomCenter)
                .padding(bottom = 25.dp)
        ) {
            Text(
                text = " Starts At ${match.utcDate?.split("T")?.get(1)}",
                color = colorResource(id = R.color.white),
                fontSize = 15.sp,
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Center,
                maxLines = 4
            )

        }

        Row(
            modifier = Modifier
                .align(BottomCenter)
                .padding(top = 20.dp)
        ) {
            Text(
                text = "${league}",
                color = colorResource(id = R.color.white),
                fontSize = 15.sp,
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Center,
                maxLines = 4
            )

        }
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