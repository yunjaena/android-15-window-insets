package dev.yunzai.android15

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.yunzai.android15.codelab1.CodeLab1Activity
import dev.yunzai.android15.codelab10.CodeLab10Activity
import dev.yunzai.android15.codelab11.CodeLab11Activity
import dev.yunzai.android15.codelab12.CodeLab12Activity
import dev.yunzai.android15.codelab13.CodeLab13Activity
import dev.yunzai.android15.codelab14.CodeLab14Activity
import dev.yunzai.android15.codelab15.CodeLab15Activity
import dev.yunzai.android15.codelab2.CodeLab2Activity
import dev.yunzai.android15.codelab3.CodeLab3Activity
import dev.yunzai.android15.codelab4.CodeLab4Activity
import dev.yunzai.android15.codelab5.CodeLab5Activity
import dev.yunzai.android15.codelab6.CodeLab6Activity
import dev.yunzai.android15.codelab7.CodeLab7Activity
import dev.yunzai.android15.codelab8.CodeLab8Activity
import dev.yunzai.android15.codelab9.CodeLab9Activity
import dev.yunzai.android15.ui.theme.Android15Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android15Theme {
                val activityList = remember {
                    listOf(
                        CodeLab1Activity::class.java,
                        CodeLab2Activity::class.java,
                        CodeLab3Activity::class.java,
                        CodeLab4Activity::class.java,
                        CodeLab5Activity::class.java,
                        CodeLab6Activity::class.java,
                        CodeLab7Activity::class.java,
                        CodeLab8Activity::class.java,
                        CodeLab9Activity::class.java,
                        CodeLab10Activity::class.java,
                        CodeLab11Activity::class.java,
                        CodeLab12Activity::class.java,
                        CodeLab13Activity::class.java,
                        CodeLab14Activity::class.java,
                        CodeLab15Activity::class.java,
                    )
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Android 15 코드랩") }
                        )
                    }
                ) { innerPadding ->
                    MainScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .consumeWindowInsets(innerPadding),
                        startCodeLab = {
                            val activity = activityList.getOrNull(it) ?: return@MainScreen
                            val intent = Intent(this@MainActivity, activity)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun MainScreen(
    modifier: Modifier = Modifier,
    startCodeLab: (Int) -> Unit = {}
) {
    val title = remember {
        listOf(
            "1. System UI 정의",
            "2. edge-to-edge",
            "3. 고수준(Higher level) WindowInsets API",
            "4. 저수준(Lower level) WindowInsets API",
            "5. 패딩 수정자",
            "6. 인셋 크기 수정자",
            "7. 인셋 소비 - 1",
            "8. 인셋 소비 - 2",
            "9. Material 3 구성요소의 인셋 지원 - 1",
            "10. Material 3 구성요소의 인셋 지원 - 2",
            "11. 기본 인셋 재정의 - 1",
            "12. 기본 인셋 재정의 - 2",
            "13. 시스템 표시줄 보호",
            "14. xml(Android view) - 인셋을 사용하여 중복 처리",
            "15. 부록 - 몰입형 모드",
        )
    }
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(20.dp)
    ) {
        item {
            Text(
                text = "Android 15 코드랩입니다! 순차적으로 진행해주세요!\n기본으로 API 35 기기에서 실행해주세요!",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
        }
        itemsIndexed(title) { index, item ->
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { startCodeLab(index) }) {
                Text(text = item)
            }
        }
    }
}