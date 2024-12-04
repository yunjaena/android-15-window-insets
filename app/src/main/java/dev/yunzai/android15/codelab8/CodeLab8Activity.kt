package dev.yunzai.android15.codelab8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yunzai.android15.ui.theme.Android15Theme

class CodeLab8Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Android15Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val focusRequest = LocalFocusManager.current

                    Column(
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = null,
                                onClick = {
                                    focusRequest.clearFocus()
                                }
                            )
                    ) {
                        CodeLab8Content(
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
private fun CodeLab8Content(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(
            Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .windowInsetsTopHeight(WindowInsets.systemBars)
        )

        Column(
            Modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .consumeWindowInsets(
                    WindowInsets.systemBars.only(WindowInsetsSides.Vertical)
                )
                //.consumeWindowInsets(PaddingValues(50.dp))
        ) {
            TextField(value = "눌러보세요", onValueChange = {})

            BoxWithConstraints(
                Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .windowInsetsBottomHeight(WindowInsets.ime)
            ) {
                Text(text = "height : ${this.maxHeight}")
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(text = "Modifier.consumeWindowInsets(paddingValues: PaddingValues)는 WindowInsets 인수가 있는 버전과 매우 유사하게 동작하지만 임의의 PaddingValues를 사용합니다. ")
                Text(text = "이는 일반 Modifier.padding 또는 고정 높이 스페이서와 같이 인셋 패딩 수정자 이외의 다른 메커니즘에서 패딩이나 간격을 제공하는 경우 자식 요소에 알리는 데 유용합니다.")
                Text(text = "소비 없이 원시 창 인셋이 필요한 경우 WindowInsets 값을 직접 사용하거나 WindowInsets.asPaddingValues()를 사용하여 소비의 영향을 받지 않는 인셋의 PaddingValues를 반환합니다. 그러나 아래의 주의사항으로 인해 가능하면 창 인셋 패딩 수정자와 창 인셋 크기 수정자를 사용하는 것이 좋습니다.")
                Text(text = "consumeWindowInsets를 하나씩 주석 처리 해보면서 빨간색 높이를 비교해보세요")
            }
        }

        Box(
            Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .windowInsetsBottomHeight(WindowInsets.systemBars)
        ) {
            Text(text = "systembar bototm height")
        }
    }
}

@Preview
@Composable
fun CodeLab8ContentPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CodeLab8Content()
        }
    }
}