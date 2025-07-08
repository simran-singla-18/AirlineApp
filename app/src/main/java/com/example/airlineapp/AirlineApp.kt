import com.example.airlineapp.screens.AirlineDetailScreen
import com.example.airlineapp.screens.AirlineListScreen
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AirlineApp() {
    val isDarkTheme = isSystemInDarkTheme()
    val colorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme()

    MaterialTheme(
        colorScheme = colorScheme // 👈 remove typography for now
    ) {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "list") {
            composable("list") { AirlineListScreen(navController) }
            composable("detail/{id}") { backStack ->
                val id = backStack.arguments?.getString("id")
                AirlineDetailScreen(airlineId = id)
            }
        }
    }
}
