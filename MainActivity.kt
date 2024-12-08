package com.mhs.lazycolumn.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mhs.lazycolumn.ui.theme.LazyColumnTheme
import com.mhs.lazycolumn.ui.theme.PurpleGrey80
import com.mhs.lazycolumn.utils.BRANDS

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LazyColumnTheme {
                CreateLazyHorizontalGrid(BRANDS) {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}


@Composable
fun BrandItem(item: Pair<String, Int>, onBrandClick: (String) -> Unit) {

    Card(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .padding(horizontal = 8.dp, 4.dp)
            .clickable { onBrandClick.invoke(item.first) },
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(Color.White)

    ) {

        Column {

            AsyncImage(
                model = item.second,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                text = item.first,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium)
            )
        }

    }

}


@Composable
fun CreateLazyColumn(brandList: List<Pair<String, Int>>, onBrandClick: (String) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = PurpleGrey80
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(brandList.size) {
                BrandItem(brandList[it], onBrandClick)
            }

        }


    }
}

@Composable
fun CreateLazyRow(brandList: List<Pair<String, Int>>, onBrandClick: (String) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = PurpleGrey80
    ) {

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(brandList.size) {
                BrandItem(brandList[it], onBrandClick)
            }

        }


    }
}

@Composable
fun CreateLazyVerticalGrid(brandList: List<Pair<String, Int>>, onBrandClick: (String) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = PurpleGrey80
    ) {

        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(32.dp)) {
            items(brandList.size) {
                BrandItem(brandList[it], onBrandClick)
            }

        }


    }
}

@Composable
fun CreateLazyHorizontalGrid(brandList: List<Pair<String, Int>>, onBrandClick: (String) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = PurpleGrey80
    ) {

        LazyHorizontalGrid(rows = GridCells.Fixed(2), modifier = Modifier.padding(32.dp)) {
            items(brandList.size) {
                BrandItem(brandList[it], onBrandClick)
            }

        }


    }
}
