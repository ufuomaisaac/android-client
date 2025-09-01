/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package cmp.android.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import cmp.shared.SharedApp
import com.mifos.core.datastore.UserPreferencesRepository
import com.mifos.core.ui.util.ShareUtils
import io.github.vinceglb.filekit.FileKit
import io.github.vinceglb.filekit.dialogs.init
import org.koin.android.ext.android.inject
import java.util.Locale
import kotlin.getValue

/**
 * Main activity class.
 * This class is used to set the content view of the activity.
 *
 * @constructor Create empty Main activity
 * @see ComponentActivity
 */
class MainActivity : ComponentActivity() {
    /**
     * Called when the activity is starting.
     * This is where most initialization should go: calling [setContentView(int)] to inflate the activity's UI,
     */

    private val userPreferencesRepository: UserPreferencesRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var shouldShowSplashScreen = true
        installSplashScreen().setKeepOnScreenCondition { shouldShowSplashScreen }

        val darkThemeConfigFlow = userPreferencesRepository.appTheme

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setupEdgeToEdge(darkThemeConfigFlow)
        ShareUtils.setActivityProvider { return@setActivityProvider this }
        FileKit.init(this)

        /**
         * Set the content view of the activity.
         * @see setContent
         */
        setContent {
            SharedApp(
                handleThemeMode = {
                    AppCompatDelegate.setDefaultNightMode(it)
                },
                handleAppLocale = {
                    it?.let {
                        AppCompatDelegate.setApplicationLocales(
                            LocaleListCompat.forLanguageTags(it),
                        )
                        Locale.setDefault(Locale(it))
                    }
                },
                onSplashScreenRemoved = {
                    shouldShowSplashScreen = false
                },
            )
        }
    }
}
