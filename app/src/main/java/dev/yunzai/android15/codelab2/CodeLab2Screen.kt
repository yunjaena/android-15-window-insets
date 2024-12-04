package dev.yunzai.android15.codelab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yunzai.android15.ui.theme.Android15Theme

@Composable
fun Codelab2Screen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsTopHeight(WindowInsets.statusBars)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "edge-To-edge로 인해 가려지는 부분")
        }
        ProvideTextStyle(value = MaterialTheme.typography.bodyLarge) {
            Text(text = "⋅ Android 플랫폼은 상태 표시줄 및 탐색 메뉴와 같은 시스템 UI를 그리는 역할을 합니다. 이 시스템 UI는 사용자가 사용 중인 앱과 관계없이 표시됩니다.")
            Text(text = "⋅ WindowInsets는 앱이 올바른 영역에 그려지고 UI가 시스템 UI로 가려지지 않도록 시스템 UI에 관한 정보를 제공합니다.")
            Text(text = "⋅ Android 14 (API 수준 34) 이하에서는 앱의 UI가 기본적으로 시스템 표시줄과 디스플레이 컷아웃 아래에 표시되지 않습니다.")
            Text(text = "⭐ 중요: 앱이 SDK 35를 타겟팅하면 Android 15 (API 수준 35) 이상에서 더 넓은 화면(edge-to-edge)이 적용됩니다. 앱이 아직 전체 화면이 아닌 경우 앱의 일부가 숨겨질 수 있으며, 이 경우 인셋을 처리해야 합니다.")
            Text(
                text = "⭐ 인셋 설정\n" +
                        "앱에서 콘텐츠를 그리는 위치를 완전히 제어할 수 있도록 하려면 다음 설정 단계를 따르세요. 이러한 단계를 수행하지 않으면 앱이 시스템 UI 뒤에 검은색 또는 단색을 그리거나 소프트웨어 키보드와 동시에 애니메이션되지 않을 수 있습니다.\n" +
                        "\n" +
                        "1. Android 15 이상에서 전면 전체 화면을 적용하려면 SDK 35 이상을 타겟팅합니다. 앱이 시스템 UI 뒤에 표시됩니다. 인셋을 처리하여 앱의 UI를 조정할 수 있습니다.\n\n" +
                        "2. 원하는 경우 Activity.onCreate()에서 enableEdgeToEdge()를 호출하여 이전 Android 버전에서 앱이 더 넓은 화면을 사용할 수 있도록 합니다.\n\n" +
                        "3. 활동의 AndroidManifest.xml 항목에서 android:windowSoftInputMode=\"adjustResize\"를 설정합니다. 이 설정을 사용하면 앱에서 소프트웨어 IME의 크기를 인셋으로 수신할 수 있습니다. 이 인셋은 IME가 앱에 표시되고 사라질 때 콘텐츠를 적절하게 패딩하고 배치하는 데 사용할 수 있습니다."
            )
            Text(text = "▶\uFE0F enableEdgeToEdge() 주석을 해제해서 API 35 미만에서 차이를 확인해보세요 \uD83D\uDE04")
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsBottomHeight(WindowInsets.navigationBars)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "edge-To-edge로 인해 가려지는 부분")
        }
    }
}

@Preview
@Composable
private fun Codelab2ScreenPreview() {
    Android15Theme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Codelab2Screen()
        }
    }
}