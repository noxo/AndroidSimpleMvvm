// /Users/noxo/git/AndroidSimpleMvvm/app/src/main/java/com/noxo/evapp/repository/AuthService.kt
package com.noxo.evapp.service

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreAuthService(
    private val context: Context
) : AuthService{

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    private val KEY_AUTH_TOKEN = stringPreferencesKey("auth_token")

    override val authTokenFlow: Flow<String?> = context.dataStore.data
        .map { preferences -> preferences[KEY_AUTH_TOKEN] }

    override suspend fun persistAuthToken(token: String) {
        context.dataStore.edit { settings ->
            settings[KEY_AUTH_TOKEN] = token
        }
    }
}