package com.example.airlineapp

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun AirlineDetailScreen(airlineId: String?) {
    val viewModel: AirlineViewModel = hiltViewModel()
    val airline = viewModel.airlines.collectAsState().value.find { it.id == airlineId }

    val context = LocalContext.current

    if (airline != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    AsyncImage(
                        model = airline.logo_url,
                        contentDescription = "${airline.name} Logo",
                        modifier = Modifier
                            .height(60.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Text(
                        text = airline.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Country: ${airline.country}",
                        fontSize = 16.sp
                    )

                    Text(
                        text = "Headquarters: ${airline.headquarters}",
                        fontSize = 16.sp
                    )

                    Text(
                        text = "Fleet Size: ${airline.fleet_size}",
                        fontSize = 16.sp
                    )

                    Text(
                        text = "Website",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 16.sp,
                        modifier = Modifier.clickable {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(airline.website))
                            ContextCompat.startActivity(context, intent, null)
                        }
                    )
                }
            }
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            //Text("Airline not found", fontSize = 18.sp)
        }
    }
}
