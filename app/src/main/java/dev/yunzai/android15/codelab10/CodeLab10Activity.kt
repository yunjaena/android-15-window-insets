package dev.yunzai.android15.codelab10

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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yunzai.android15.ui.theme.Android15Theme
import kotlin.random.Random

class CodeLab10Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Android15Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Scaffold { innerPadding ->
                        // consume insets as scaffold doesn't do it by default
                        CodeLab10Content(
                            modifier = Modifier
                                .fillMaxSize()
                                .consumeWindowInsets(innerPadding),
                            contentPadding = innerPadding
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CodeLab10Content(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
) {
    val colors = remember {
        List(100) {
            Color(
                red = Random.nextInt(255),
                green = Random.nextInt(255),
                blue = Random.nextInt(255)
            )
        }
    }
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        item {
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .windowInsetsTopHeight(WindowInsets.statusBars)
            ) {
                Text(text = "consumeWindowInsets not worked!!")
            }
        }
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(text = "기본적으로 Scaffold는 개발자가 사용하고 소비할 수 있도록 매개변수 paddingValues로 인셋을 제공합니다. Scaffold는 콘텐츠에 인셋을 적용하지 않습니다. 이 책임은 개발자에게 있습니다. 예를 들어 Scaffold 내부의 LazyColumn로 이러한 인셋을 사용하려면 아래 예제 처럼 해보세요.")
                Text(text = "consumeWindowInset을 지우고 실행해보세요!")
            }
        }
        items(colors) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(it)
            )
        }
        item {
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .windowInsetsBottomHeight(WindowInsets.navigationBars)
            ) {

            }
        }
    }
}

@Preview
@Composable
fun CodeLab10ContentPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CodeLab10Content()
        }
    }
}