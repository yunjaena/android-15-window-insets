package dev.yunzai.android15.codelab7

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
import androidx.compose.foundation.layout.imePadding
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.yunzai.android15.ui.theme.Android15Theme

class CodeLab7Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Android15Theme {
                val focusRequest = LocalFocusManager.current

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .windowInsetsPadding(WindowInsets.statusBars)
                            .clickable(
                                indication = null,
                                interactionSource = null,
                                onClick = {
                                    focusRequest.clearFocus()
                                }
                            )
                            .fillMaxSize()
                    ) {
                        CodeLab7Content(
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CodeLab7Content(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier.imePadding()
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(text = "인셋 소비 - 1", style = MaterialTheme.typography.titleLarge)
                Text(text = "인셋 패딩 수정자 (windowInsetsPadding 및 safeDrawingPadding와 같은 도우미)는 패딩으로 적용되는 인셋의 일부를 자동으로 사용합니다. 컴포지션 트리를 더 깊이 들어가면서 중첩된 인셋 패딩 수정자와 인셋 크기 수정자는 인셋의 일부가 이미 외부 인셋 패딩 수정자에 의해 사용되었음을 알고 있으므로 인셋의 동일한 부분을 두 번 이상 사용하지 않아도 되며, 이로 인해 여백이 너무 많이 생기지 않습니다.")
                Text(text = "인셋 크기 수정자는 인셋이 이미 사용된 경우 인셋의 동일한 부분을 두 번 이상 사용하지 않도록 합니다. 하지만 크기를 직접 변경하므로 자체적으로 인셋을 사용하지 않습니다.")
                Text(text = "따라서 패딩 수정자를 중첩하면 각 컴포저블에 적용되는 패딩의 양이 자동으로 변경됩니다.")
                Text(text = "이전과 동일한 LazyColumn 예시를 보면 LazyColumn가 imePadding 수정자를 사용하여 크기가 조절됩니다. LazyColumn 내에서 마지막 항목은 시스템 표시줄 하단의 높이로 크기가 조정됩니다.")
                Text(text = "맨 밑으로 스크롤 해보고 textfield를 눌러보세요!")
            }
        }
        items(30) {
            Text(text = "$it")
        }
        item {
            TextField(value = "눌러보세요", onValueChange = {})
        }
        item {
            Box(
                Modifier
                    .windowInsetsBottomHeight(
                        WindowInsets.systemBars
                    )
                    .fillMaxWidth()
                    .background(Color.Yellow)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "ime가 없는 상태"
                )
            }
        }
        item {
            Box(
                Modifier
                    .windowInsetsBottomHeight(
                        WindowInsets.navigationBars
                    )
                    .fillMaxWidth()
                    .background(Color.Green)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "navigation bar"
                )
            }
        }
    }
}

@Preview
@Composable
fun CodeLab7ContentPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CodeLab7Content()
        }
    }
}