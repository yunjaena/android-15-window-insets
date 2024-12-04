package dev.yunzai.android15.codelab1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yunzai.android15.ui.theme.Android15Theme

@Composable
fun Codelab1Screen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.Yellow)
            .windowInsetsPadding(WindowInsets.statusBars)
            .background(Color.Blue)
            .windowInsetsPadding(WindowInsets.displayCutout)
            .background(Color.Green)
            .windowInsetsPadding(WindowInsets.navigationBars)
            .background(Color.White),
    ) {
        Codelab1Content(
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Composable
private fun Codelab1Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Yellow)
                    .size(40.dp, 20.dp)
            )

            Text(text = " => Status bar")
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Green)
                    .size(40.dp, 20.dp)
            )

            Text(text = " => Navigation bar\n(3버튼 내비게이션 바인 경우 기본 불투명도 80%)")
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Blue)
                    .size(40.dp, 20.dp)
            )

            Text(text = " => Display Cutout (노치 또는 핀홀) \n- 안보이는 경우 -\n개발자 도구 -> Display cutout 설정")
        }
    }
}

@Preview
@Composable
private fun Codelab1ScreenPreview() {
    Android15Theme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Codelab1Screen()
        }
    }
}