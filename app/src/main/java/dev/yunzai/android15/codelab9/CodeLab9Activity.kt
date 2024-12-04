package dev.yunzai.android15.codelab9

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
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yunzai.android15.ui.theme.Android15Theme

class CodeLab9Activity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Android15Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(title = { Text(text = "9. Material 3 구성요소의 인셋 지원 - 1") })
                        },
                        bottomBar = {
                            BottomAppBar(
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
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .consumeWindowInsets(innerPadding)
                        ) {
                            CodeLab9Content(
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
    }
}

@Composable
private fun CodeLab9Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = "사용 편의를 위해 대부분의 내장 Material 3 컴포저블(androidx.compose.material3)은 Material 사양에 따라 앱에 컴포저블이 배치되는 방식에 따라 인셋을 직접 처리합니다.")
        Text(text = "⭐ 참고: Material 2 구성요소(androidx.compose.material)는 인셋 자체를 자동으로 처리하지 않습니다. 하지만 인셋에 액세스하여 수동으로 적용할 수 있습니다. androidx.compose.material 1.6.0 이상에서 windowInsets 매개변수를 사용하여 BottomAppBar, TopAppBar, BottomNavigation, NavigationRail에 인셋을 수동으로 적용합니다. 마찬가지로 Scaffold에는 contentWindowInsets 매개변수를 사용합니다. 그 외에는 수동으로 인셋을 패딩으로 적용합니다.")
        Text(
            text = "1\uFE0F⃣ 앱 바\n" +
                    "TopAppBar/ SmallTopAppBar/ CenterAlignedTopAppBar/ MediumTopAppBar/ LargeTopAppBar: 창 상단에 사용되므로 시스템 막대의 상단 및 가로 측면을 패딩으로 적용합니다.\n" +
                    "BottomAppBar: 시스템 표시줄의 하단 및 가로 측면을 패딩으로 적용합니다."
        )
        Text(
            text = "2\uFE0F⃣ 콘텐츠 컨테이너\n" +
                    "ModalDrawerSheet/ DismissibleDrawerSheet/ PermanentDrawerSheet (모달 탐색 창 내 콘텐츠): 콘텐츠에 세로 및 시작 인셋을 적용합니다.\n" +
                    "ModalBottomSheet: 하단 인셋을 적용합니다.\n" +
                    "NavigationBar : bottom 및 horizontal 인셋을 적용합니다.\n" +
                    "NavigationRail: 세로 및 시작 인셋을 적용합니다."
        )
    }
}

@Preview
@Composable
fun CodeLab9ContentPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CodeLab9Content()
        }
    }
}