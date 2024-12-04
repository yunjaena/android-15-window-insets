package dev.yunzai.android15.codelab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemGestures
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.yunzai.android15.ui.theme.Android15Theme

class CodeLab5Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Android15Theme {
                Column(
                    modifier = Modifier
                        .safeDrawingPadding()
//                        .windowInsetsPadding(
//                            WindowInsets.systemBars
//                                .union(WindowInsets.ime)
//                                .union(WindowInsets.displayCutout)
//                        )
                        .fillMaxSize()
                ) {
                    Codelab5Content(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun Codelab5Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = "패딩 수정자", style = MaterialTheme.typography.titleLarge)
        Text(text = "Modifier.windowInsetsPadding(windowInsets: WindowInsets)는 주어진 창 인셋을 패딩으로 적용하여 Modifier.padding와 마찬가지로 작동합니다.")
        Text(text = "Modifier.windowInsetsPadding(WindowInsets.safeDrawing)는 안전한 그리기 인셋을 4면 모두에 패딩으로 적용합니다.")
        Text(text = "가장 일반적인 인셋 유형을 위한 몇 가지 내장 유틸리티 메서드도 있습니다. Modifier.safeDrawingPadding()는 Modifier.windowInsetsPadding(WindowInsets.safeDrawing)와 동일한 이러한 메서드 중 하나입니다. 다른 인셋 유형에도 유사한 수정자가 있습니다.")
        ProvideTextStyle(value = MaterialTheme.typography.labelLarge) {
            Text(text = "▶\uFE0F safeDrawingPadding은  windowInsetsPadding을 사용해서 systemBars + ime + displayCutout padding으로 이루어져있습니다.")
            Text(text = "▶\uFE0F 상위 composable modifier에서 safeDrawingPadding 과 windowInsetsPadding를 확인해보세요.")
        }
    }
}

@Preview
@Composable
fun Codelab5ContentPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Codelab5Content()
        }
    }
}