import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.jetpack.userUI.LOGGIN.loginViewModel
import android.content.Intent
import android.net.Uri

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navToLoginPage: () -> Unit,
    loginViewModel: loginViewModel
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home page Screen") },
                actions = {
                    IconButton(
                        onClick = {
                            loginViewModel.logoutUser { success ->
                                if (success) {
                                    loginViewModel.resetLoginState()
                                    navToLoginPage.invoke()
                                }
                            }
                        }
                    ) {
                        Icon(Icons.Filled.ExitToApp, contentDescription = "Log out")
                    }
                }
            )
        }
    ) {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    val pdfUrl = "https://firebasestorage.googleapis.com/v0/b/tasksmanagerapp-50f82.appspot.com/o/file6144b279-914d-404f-8d5a-445fbd899944?alt=media&token=0a4c0102-9246-4098-819d-8da2e0e2b6a6"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.setDataAndType(Uri.parse(pdfUrl), "application/pdf")
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    context.startActivity(intent)
                },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text("Open PDF")
            }
        }
    }
}
