package com.swa.sampleapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swa.quicknotify.core.QuickNotify
import com.swa.sampleapp.ui.theme.ToastImageLibraryTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToastImageLibraryTheme {
                // QuickNotifyInit()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(20.dp)) {
                        Greeting("")

                        Button(onClick = {
                            Log.d("QuickToast", "Button click")
                            QuickNotify.showSnackbar(
                                "Hello from QuickNotify - snackbar!",
                                duration = 1000
                            )
                        }) {
                            Text("Show snackbar")
                        }

                        showCustomDialog()
                    }
                }
            }
        }
    }

    @Composable
    fun showCustomDialog() {
        val p = painterResource(R.drawable.ic_profile)
        Button(onClick = {
            Log.d("QuickToast", "Button click")
            QuickNotify.showDialog(
                title = "Delete Account?",
                body = "This action cannot be undone.",
                image = p,
                btn1Text = "Cancel",
                onBtn1Click = { /* handle */ },
                btn2Text = "Delete",
                btn2Color = Color.Red,
                onBtn2Click = { /* handle delete */ },
                btn3Text = "Continue",
                btn3Color = Color.Green,
                onBtn3Click = { /* handle Continue */ }
            )
        }) {
            Text("Show dialog")
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val bitmap: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_profile)

    Button(onClick = {
        Log.d("QuickToast", "Button click")
        QuickNotify.showToast("Hello from QuickNotify!", duration = 5000, icon = bitmap)
    }) {
        Text("Show Toast")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToastImageLibraryTheme {
        Greeting("Android")
    }
}