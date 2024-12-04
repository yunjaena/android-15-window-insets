package dev.yunzai.android15.codelab12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

class CodeLab12Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            var checked by remember { mutableStateOf(false) }
            Android15Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Scaffold(
                        topBar = {
                            CustomTopAppBar(
                                windowInsets = if (checked) WindowInsets(0) else CustomTopBarDefault.windowInsets
                            ) {
                                Text(
                                    text = "12. 기본 인셋 재정의 - 2",
                                    style = MaterialTheme.typography.titleLarge
                                )
                            }
                        },
                        bottomBar = {
                            CustomBottomAppBar(
                                modifier = Modifier
                                    .heightIn(min = 100.dp, max = 100.dp),
                                windowInsets = if (checked) WindowInsets(0) else CustomBottomBarDefault.windowInsets
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
                        CodeLab12Content(
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
private fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    windowInsets: WindowInsets = CustomTopBarDefault.windowInsets,
    content: @Composable () -> Unit = {}
) {
    Surface(
        modifier = modifier
            .windowInsetsPadding(windowInsets)
            .fillMaxWidth()
    ) {
        content()
    }
}

@Composable
private fun CustomBottomAppBar(
    modifier: Modifier = Modifier,
    windowInsets: WindowInsets = CustomBottomBarDefault.windowInsets,
    content: @Composable RowScope.() -> Unit = {}
) {
    Surface(
        modifier = modifier
            .windowInsetsPadding(windowInsets)
            .fillMaxWidth()
    ) {
        Row {
            content()
        }
    }
}

object CustomTopBarDefault {
    val windowInsets: WindowInsets
        @Composable
        get() =
            WindowInsets.systemBars.only(
                WindowInsetsSides.Horizontal + WindowInsetsSides.Top
            )
}

object CustomBottomBarDefault {
    val windowInsets: WindowInsets
        @Composable
        get() =
            WindowInsets.systemBars.only(
                WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
            )
}


@Composable
private fun CodeLab12Content(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Custom으로 topbar와 bottomBar을 만들면 어떻게 해야될까요?\n구현시 windowInsets를 파라미터로 받을수 있게 정의해주고 외부에서 변경할 수 있게 해줍니다")
        Text(text = "⭐ 중요 : windowInset과 contentWindowInsets를 헷갈리면 안됩니다! topbar의 windowInset과 bottomBar windowInset은 contentWindowInsets 영향을 받지 않습니다.")
        Switch(
            checked = checked,
            onCheckedChange = {
                onCheckedChange(it)
            }
        )
        Text(text = if (checked) "contentWindowInsets => 0" else "contentWindowInsets => default")
    }
}

@Preview
@Composable
fun CodeLab12ContentPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CodeLab12Content()
        }
    }
}