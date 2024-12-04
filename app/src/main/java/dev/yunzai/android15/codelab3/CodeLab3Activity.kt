package dev.yunzai.android15.codelab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yunzai.android15.ui.theme.Android15Theme

class CodeLab3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Android15Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)
                        .safeDrawingPadding()
                        .background(Color.Blue)
                        .safeGesturesPadding()
                        .background(Color.Yellow)
                        .safeContentPadding()
                        .background(Color.White)
                ) {
                    Codelab3Content(
                        modifier = Modifier
                            .padding(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun Codelab3Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .size(40.dp, 20.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(text = "<safeDrawingPadding()>", style = MaterialTheme.typography.titleLarge)
                Text(text = "시스템 UI 아래에 그려져서는 안 되는 콘텐츠를 보호합니다. 이는 삽입의 가장 일반적인 용도입니다. 시스템 UI로 부분적으로 또는 완전히 가려진 콘텐츠를 그리지 않도록 합니다. API 21로 백포팅된 IME 애니메이션으로 자동으로 애니메이션 처리됩니다. 또한 이러한 인셋을 사용하는 모든 레이아웃은 인셋 값이 변경될 때 자동으로 애니메이션됩니다.")
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Blue)
                    .size(40.dp, 20.dp)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(text = "<safeGesturesPadding()>", style = MaterialTheme.typography.titleLarge)
                Text(text = "동작으로 콘텐츠를 보호합니다. 이렇게 하면 시스템 동작이 앱 동작 (예: 하단 시트, 캐러셀 또는 게임의 동작)과 충돌하는 것을 방지할 수 있습니다. 안 보이는 경우 네비게이션을 Gesture Navigation으로 바꿔보세요")
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Yellow)
                    .size(40.dp, 20.dp)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(text = "<safeContentPadding()>", style = MaterialTheme.typography.titleLarge)
                Text(text = "safeDrawingPadding + safeGesturesPadding\n(safeContentPadding, safeGesturesPadding을 주석 하면 노란색이 보입니다)")
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color.Red)
                .safeDrawingPadding()
                .background(Color.Blue)
                .safeGesturesPadding()
                .background(Color.Yellow)
                .safeContentPadding()
                .background(Color.Green)
        ) {
            Text(
                text = "여기서 각 safe modifier에서 inset이 cosumed 처리가 되기 때문에 inset이 중복으로 작용하지 않습니다.\n" +
                        "상위 composable modifer를 주석처리해서 확인해보세요!"
            )
        }
    }
}

@Preview
@Composable
fun Codelab3ContentPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Codelab3Content()
        }
    }
}