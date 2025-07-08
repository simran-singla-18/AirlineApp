package com.example.airlineapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.airlineapp.network.AirlineViewModel


@Composable
fun AirlineListScreen(
    navController: NavController,
    viewModel: AirlineViewModel = hiltViewModel()
) {
    val airlines = viewModel.airlines.collectAsState().value

    var searchText by remember { mutableStateOf("") }

    val filteredAirlines = airlines.filter {
        it.name.contains(searchText, ignoreCase = true) ||
                it.country.contains(searchText, ignoreCase = true)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            placeholder = { Text("Search by name or country") },
            singleLine = true
        )

        LazyColumn {
            items(filteredAirlines) { airline ->
                ListItem(
                    headlineContent = { Text(airline.name) },
                    supportingContent = { Text(airline.country) },
                    leadingContent = {
                        Image(
                            painter = rememberAsyncImagePainter(airline.logo_url),
                            contentDescription = airline.name,
                            modifier = Modifier.size(50.dp)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("detail/${airline.id}")
                        }
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}


