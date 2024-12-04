package dev.yunzai.android15.codelab15

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsCompat.Type.systemBars
import dev.yunzai.android15.ui.theme.Android15Theme

class CodeLab15Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        setContent {
            var checked by remember { mutableStateOf(false) }

            LaunchedEffect(checked, windowInsetsController) {
                when (checked) {
                    true -> windowInsetsController.hide(systemBars())
                    false -> windowInsetsController.show(systemBars())
                }
            }

            LaunchedEffect(Unit) {
                ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, windowInsets ->
                    checked = !(windowInsets.isVisible(WindowInsetsCompat.Type.navigationBars()) || windowInsets.isVisible(WindowInsetsCompat.Type.statusBars()))
                    ViewCompat.onApplyWindowInsets(view, windowInsets)
                }
            }

            Android15Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Scaffold(
                        bottomBar = {
                            BottomAppBar(
                                windowInsets = WindowInsets(0),
                                containerColor = Color.Transparent
                            ) {
                                Box(
                                    modifier = Modifier
                                        .background(Color.Red)
                                        .fillMaxHeight()
                                        .weight(1f)
                                )
                                Box(
                                    modifier = Modifier
                                        .background(Color.Green)
                                        .fillMaxHeight()
                                        .weight(1f)
                                )
                                Box(
                                    modifier = Modifier
                                        .background(Color.Yellow)
                                        .fillMaxHeight()
                                        .weight(1f)
                                )
                            }
                        }
                    ) { innerPadding ->
                        CodeLab15Content(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .consumeWindowInsets(innerPadding),
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CodeLab15Content(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    Column(
        modifier = modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "일부 콘텐츠는 전체 화면으로 시청하는 것이 좋습니다. 이렇게 하면 사용자에게 더 몰입도 높은 환경을 제공할 수 있습니다. WindowInsetsController 및 WindowInsetsControllerCompat 라이브러리를 사용하여 몰입형 모드의 시스템 표시줄을 숨길 수 있습니다.")
        Text(text = "WindowCompat.getInsetsController를 통해서 몰입형 모드를 설정할 수 있습니다.")
        Switch(
            checked = checked,
            onCheckedChange = {
                onCheckedChange(it)
            }
        )
        Text(text = if (checked) "몰입형 모드 ON" else "몰입형 모드 OFF")
    }
}

@Preview
@Composable
fun CodeLab15ContentPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CodeLab15Content()
        }
    }
}