package dev.yunzai.android15.codelab11

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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yunzai.android15.ui.theme.Android15Theme
import kotlin.random.Random

class CodeLab11Activity : ComponentActivity() {
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
                        contentWindowInsets = if (checked) WindowInsets(0) else ScaffoldDefaults.contentWindowInsets
                    ) { innerPadding ->
                        CodeLab11Content(
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
private fun CodeLab11Content(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "컴포저블에 전달된 windowInsets 매개변수를 변경하여 컴포저블의 동작을 구성할 수 있습니다. 이 매개변수는 대신 적용할 다른 유형의 창 인셋이거나 빈 인스턴스(WindowInsets(0, 0, 0, 0))를 전달하여 사용 중지할 수 있습니다.")
        Text(text = "Scaffold에는 contentWindowInsets 이 기본으로 systemBars로 설정이 되어있습니다. 전체로 꽉차게 하기 위해서는 contentWindowInsets 을 0으로 설정해주면 됩니다.")
        Switch(
            checked = checked,
            onCheckedChange = {
                onCheckedChange(it)
            }
        )
        Text(text = if (checked) "contentWindowInsets => 0" else "contentWindowInsets => sytemBars")
    }
}

@Preview
@Composable
fun CodeLab11ContentPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CodeLab11Content()
        }
    }
}