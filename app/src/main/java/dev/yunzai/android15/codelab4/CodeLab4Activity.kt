package dev.yunzai.android15.codelab4

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
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemGestures
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.yunzai.android15.ui.theme.Android15Theme

class CodeLab4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Android15Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)
                        .windowInsetsPadding(WindowInsets.statusBars)
                        .background(Color.Blue)
                        .windowInsetsPadding(WindowInsets.navigationBars)
                        .background(Color.Yellow)
                        .windowInsetsPadding(WindowInsets.systemGestures)
                        .background(Color.White)
                ) {
                    Codelab4Content(
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
private fun Codelab4Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        val statusBarWindowInsets = WindowInsets.statusBars
        val navigationBarsWindowInsets = WindowInsets.navigationBars
        val systemGesturesWindowInsets = WindowInsets.systemGestures

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .size(40.dp, 20.dp)
            )

            Text(
                text = "<WindowInsets.statusBars>\n" +
                        "- Top Padding(\"${
                            statusBarWindowInsets.asPaddingValues().calculateTopPadding()
                        }\")\n" +
                        "- Bottom Padding(\"${
                            statusBarWindowInsets.asPaddingValues().calculateBottomPadding()
                        }\")\n" +
                        "- Start Padding(\"${
                            statusBarWindowInsets.asPaddingValues()
                                .calculateStartPadding(LayoutDirection.Ltr)
                        }\")\n" +
                        "- End Padding(\"${
                            statusBarWindowInsets.asPaddingValues()
                                .calculateEndPadding(LayoutDirection.Ltr)
                        }\")\n"
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Blue)
                    .size(40.dp, 20.dp)
            )

            Text(
                text = "<WindowInsets.navigationBars>\n" +
                        "- Top Padding(\"${
                            navigationBarsWindowInsets.asPaddingValues().calculateTopPadding()
                        }\")\n" +
                        "- Bottom Padding(\"${
                            navigationBarsWindowInsets.asPaddingValues().calculateBottomPadding()
                        }\"))\n" +
                        "- Start Padding(\"${
                            navigationBarsWindowInsets.asPaddingValues()
                                .calculateStartPadding(LayoutDirection.Ltr)
                        }\")\n" +
                        "- End Padding(\"${
                            navigationBarsWindowInsets.asPaddingValues()
                                .calculateEndPadding(LayoutDirection.Ltr)
                        }\")\n"
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Yellow)
                    .size(40.dp, 20.dp)
            )

            Text(
                text = "<WindowInsets.systemGestures>\n" +
                        "- Top Padding(\"${
                            systemGesturesWindowInsets.asPaddingValues().calculateTopPadding()
                        }\")\n" +
                        "- Bottom Padding(\"${
                            systemGesturesWindowInsets.asPaddingValues().calculateBottomPadding()
                        }\")\n" +
                        "- Start Padding(\"${
                            systemGesturesWindowInsets.asPaddingValues()
                                .calculateStartPadding(LayoutDirection.Ltr)
                        }\")\n" +
                        "- End Padding(\"${
                            systemGesturesWindowInsets.asPaddingValues()
                                .calculateEndPadding(LayoutDirection.Ltr)
                        }\")\n"
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color.Red)
                .windowInsetsPadding(WindowInsets.statusBars)
                .background(Color.Blue)
                .windowInsetsPadding(WindowInsets.navigationBars)
                .background(Color.Yellow)
                .windowInsetsPadding(WindowInsets.systemGestures)
                .background(Color.Green)
        ) {
            Text(
                text = "여기서 각 windowInsetsPadding에서 inset이 cosumed 처리가 되기 때문에 inset이 중복으로 작용하지 않습니다.\n" +
                        "상위 composable modifer를 주석처리해서 확인해보세요!"
            )
        }
    }
}

@Preview
@Composable
fun Codelab4ContentPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Codelab4Content()
        }
    }
}