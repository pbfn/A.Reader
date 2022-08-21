package com.pedro_bruno.areader.screens.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.pedro_bruno.areader.components.ReaderAppBar
import com.pedro_bruno.areader.components.SearchForm
import com.pedro_bruno.areader.model.MBook
import com.pedro_bruno.areader.navigation.ReaderScreens

@Preview
@Composable
fun SearchScreen(navController: NavController = NavController(LocalContext.current)) {
    Scaffold(topBar = {
        ReaderAppBar(
            title = "Search Books",
            navController = navController,
            icon = Icons.Default.ArrowBack,
            showProfile = false
        ) {
            navController.navigate(ReaderScreens.ReaderHomeScreen.name)
            //navController.popBackStack()
        }
    }) {
        Surface() {
            Column {
                SearchForm(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                }
                Spacer(modifier = Modifier.height(13.dp))
                BookList(navController)
            }
        }
    }
}

@Composable
fun BookList(navController: NavController) {

    val listOfBooks = listOf(
        MBook("Test 1", "Running 1", "Me and you", "Hello World"),
        MBook("Test 2", "Running 2", "Me and you", "Hello World"),
        MBook("Test 3", "Running 3", "Me and you", "Hello World"),
        MBook("Test 4", "Running 4", "Me and you", "Hello World"),
    )

    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp)) {
        items(items = listOfBooks) { book ->
            BookRow(book, navController)
        }
    }
}

@Composable
fun BookRow(
    book: MBook,
    navController: NavController
) {
    Card(modifier = Modifier
        .clickable { }
        .fillMaxWidth()
        .height(100.dp)
        .padding(3.dp),
        shape = RectangleShape,
        elevation = 7.dp) {
        Row(modifier = Modifier.padding(5.dp), verticalAlignment = Alignment.Top) {
            val imageUrl =
                "http://books.google.com/books/content?id=6DQACwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            Image(
                painter = rememberImagePainter(data = imageUrl),
                contentDescription = "book image",
                modifier = Modifier
                    .width(80.dp)
                    .fillMaxHeight()
                    .padding(end = 4.dp)
            )
            Column() {
                Text(text = book.title.toString(), overflow = TextOverflow.Ellipsis)
                Text(
                    text = "Author : ${book.authors}",
                    overflow = TextOverflow.Clip,
                    style = MaterialTheme.typography.caption
                )

            }
        }
    }
}
