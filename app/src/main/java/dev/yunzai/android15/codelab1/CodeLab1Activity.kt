package dev.yunzai.android15.codelab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dev.yunzai.android15.ui.theme.Android15Theme

class CodeLab1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Android15Theme {
                Scaffold(
                    contentWindowInsets = WindowInsets(0)
                ) {
                    Codelab1Screen(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}