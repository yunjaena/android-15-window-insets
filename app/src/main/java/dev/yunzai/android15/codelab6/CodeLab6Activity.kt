package dev.yunzai.android15.codelab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemGestures
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.yunzai.android15.ui.theme.Android15Theme

class CodeLab6Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Android15Theme {
                val focusRequest = LocalFocusManager.current

                Column(
                    modifier = Modifier
                        //.safeDrawingPadding()
                        .clickable(
                            indication = null,
                            interactionSource = null,
                            onClick = {
                                focusRequest.clearFocus()
                            }
                        )
                        .fillMaxSize()
                ) {
                    Codelab6Content(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                            .padding(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun Codelab6Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Colelab6Explain(modifier = Modifier.fillMaxWidth())
        Text(text = "인셋 크기 수정자 예시", style = MaterialTheme.typography.titleLarge)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsTopHeight(
                    WindowInsets.systemBars
                )
                .background(Color.Green)
        ) {
            Text(text = "systemBars top 높이")
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsBottomHeight(
                    WindowInsets.systemBars
                )
                .background(Color.Yellow)
        ) {
            Text(text = "systemBars bottom 높이")
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsBottomHeight(
                    WindowInsets.ime
                )
                .background(Color.Red)
        ) {
            Text(text = "ime bottom 높이")
        }

        TextField(value = "눌러보세요", onValueChange = {})

    }
}

@Composable
fun Colelab6Explain(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = "인셋 크기 수정자", style = MaterialTheme.typography.titleLarge)
        Text(text = "다음 수정자는 구성요소의 크기를 인셋의 크기로 설정하여 창 인셋의 크기를 적용합니다.")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                modifier = Modifier.weight(0.4f),
                text = "Modifier.windowInsetsStartWidth(windowInsets: WindowInsets)",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = Color.Blue
                )
            )

            Text(
                modifier = Modifier.weight(0.6f),
                text = "windowInsets의 시작 면을 너비로 적용합니다 (Modifier.width와 같음).",
                style = MaterialTheme.typography.labelMedium
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                modifier = Modifier.weight(0.4f),
                text = "Modifier.windowInsetsEndWidth(windowInsets: WindowInsets)",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = Color.Blue
                )
            )

            Text(
                modifier = Modifier.weight(0.6f),
                text = "windowInsets의 끝 쪽을 너비로 적용합니다 (Modifier.width와 같음).",
                style = MaterialTheme.typography.labelMedium
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                modifier = Modifier.weight(0.4f),
                text = "Modifier.windowInsetsTopHeight(windowInsets: WindowInsets)",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = Color.Blue
                )
            )

            Text(
                modifier = Modifier.weight(0.6f),
                text = "windowInsets의 상단을 높이로 적용합니다 (Modifier.height와 같음).",
                style = MaterialTheme.typography.labelMedium
            )
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                modifier = Modifier.weight(0.4f),
                text = "Modifier.windowInsetsBottomHeight(windowInsets: WindowInsets)",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = Color.Blue
                )
            )

            Text(
                modifier = Modifier.weight(0.6f),
                text = "windowInsets의 하단을 높이로 적용합니다 (Modifier.height와 같음).",
                style = MaterialTheme.typography.labelMedium
            )
        }

        Text(text = "이러한 수정자는 특히 인셋 공간을 차지하는 Spacer의 크기를 조절하는 데 유용합니다.")
    }
}

@Preview
@Composable
fun Codelab6ContentPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Codelab6Content()
        }
    }
}