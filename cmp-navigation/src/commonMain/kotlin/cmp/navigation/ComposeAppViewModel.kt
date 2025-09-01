/*
 * Copyright 2025 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package cmp.navigation

import androidx.lifecycle.viewModelScope
import com.mifos.core.data.util.NetworkMonitor
import com.mifos.core.datastore.UserPreferencesRepository
import com.mifos.core.datastore.model.DarkThemeConfig
import com.mifos.core.model.objects.LanguageConfig
import com.mifos.core.ui.util.BaseViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ComposeAppViewModel(
    private val userPreferencesRepository: UserPreferencesRepository,
    private val networkMonitor: NetworkMonitor,
) : BaseViewModel<AppState, AppEvent, AppAction>(
    initialState = AppState(
        darkTheme = false,
        isAndroidTheme = false,
        isDynamicColorsEnabled = false,
    ),
) {
    val networkStatus = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false,
        )

    init {
        userPreferencesRepository
            .appTheme
            .onEach { trySendAction(AppAction.Internal.ThemeUpdate(it)) }
            .launchIn(viewModelScope)
    }

    override fun handleAction(action: AppAction) {
        when (action) {
            is AppAction.AppSpecificLanguageUpdate -> handleAppSpecificLanguageUpdate(action)

            is AppAction.Internal.ThemeUpdate -> handleAppThemeUpdated(action)

            is AppAction.Internal.DynamicColorsUpdate -> handleDynamicColorsUpdate(action)
        }
    }

    private fun handleAppSpecificLanguageUpdate(action: AppAction.AppSpecificLanguageUpdate) {
        viewModelScope.launch {
//            userPreferencesRepository.setLanguage(action.appLanguage)
        }
    }

    private fun handleAppThemeUpdated(action: AppAction.Internal.ThemeUpdate) {
        mutableStateFlow.update {
            it.copy(darkTheme = action.theme == DarkThemeConfig.DARK)
        }
        sendEvent(AppEvent.UpdateAppTheme(osValue = action.theme.osValue))
    }

    private fun handleDynamicColorsUpdate(action: AppAction.Internal.DynamicColorsUpdate) {
        mutableStateFlow.update { it.copy(isDynamicColorsEnabled = action.isDynamicColorsEnabled) }
    }
}

data class AppState(
    val darkTheme: Boolean,
    val isAndroidTheme: Boolean,
    val isDynamicColorsEnabled: Boolean,
)

sealed interface AppEvent {
    data class ShowToast(val message: String) : AppEvent

    data class UpdateAppLocale(
        val localeName: String?,
    ) : AppEvent

    data class UpdateAppTheme(
        val osValue: Int,
    ) : AppEvent
}

sealed interface AppAction {
    data class AppSpecificLanguageUpdate(val appLanguage: LanguageConfig) : AppAction

    sealed class Internal : AppAction {

        data class ThemeUpdate(
            val theme: DarkThemeConfig,
        ) : Internal()

        data class DynamicColorsUpdate(
            val isDynamicColorsEnabled: Boolean,
        ) : Internal()
    }
}
