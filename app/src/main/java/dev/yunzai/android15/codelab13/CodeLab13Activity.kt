package dev.yunzai.android15.codelab13

import android.os.Build
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
import androidx.compose.material3.ScaffoldDefaults
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
import dev.yunzai.android15.ui.theme.Android15Theme

class CodeLab13Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            var checked by remember { mutableStateOf(false) }

            LaunchedEffect(checked) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    window.isNavigationBarContrastEnforced = checked
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
                        CodeLab13Content(
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
private fun CodeLab13Content(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    Column(
        modifier = modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "앱이 SDK 35 이상을 타겟팅하면 가득 채우기(edge-to-edeg) 가 적용됩니다. 시스템 상태 표시줄과 동작 탐색 메뉴는 투명하지만 3버튼 탐색 메뉴는 반투명합니다.")
        Text(text = "기본 반투명 3버튼 탐색 배경 보호를 삭제하려면 Window.setNavigationBarContrastEnforced를 false로 설정합니다.")
        Text(text = "3버튼 탐색으로 변경해서 테스트 해보세요!")
        Switch(
            checked = checked,
            onCheckedChange = {
                onCheckedChange(it)
            }
        )
        Text(text = if (checked) "반투명" else "투명")
    }
}

@Preview
@Composable
fun CodeLab13ContentPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CodeLab13Content()
        }
    }
}