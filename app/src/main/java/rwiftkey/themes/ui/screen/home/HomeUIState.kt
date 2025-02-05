package rwiftkey.themes.ui.screen.home

import androidx.compose.runtime.mutableStateListOf

enum class HomeToast {
    NONE,
    INSTALLATION_FINISHED,
    INSTALLATION_FAILED
}

enum class AppOperationMode {
    INCOMPATIBLE,
    ROOT,
    XPOSED
}

data class ThemePatch(
    val title: String = "",
    val thumbnail: String = "",
    val url: String = "",
)

data class PatchCollection(
    val title: String = "",
    val patches: List<ThemePatch> = mutableStateListOf(),
    val selectedPatch: Int = -1
)

data class HomeUIState(
    val operationMode: AppOperationMode = AppOperationMode.XPOSED,
    val homeToast: HomeToast = HomeToast.NONE,
    val keyboardThemes: MutableList<KeyboardTheme> = mutableStateListOf(),
    val isLoadingVisible: Boolean = false,
    val hasNoKeyboardsAvail: Boolean = false,
    val selectedTheme: KeyboardTheme? = null,

    val isPatchMenuVisible: Boolean = false,
    val hasAlreadyLoadedPatches: Boolean = false,
    val patchCollection: MutableList<PatchCollection> = mutableStateListOf()
)
