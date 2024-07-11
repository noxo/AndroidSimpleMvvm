package com.noxo.evapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.noxo.evapp.model.Credentials


@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val loginState by viewModel.uiState.collectAsStateWithLifecycle()
    LoginScreenContent(viewModel::login, loginState)
}

@Composable
fun LoginScreenContent(
    login: (String, String) -> Unit,
    loginState: LoginState
) {

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Row(modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(value = username, onValueChange = { username = it})
            OutlinedTextField(value = password, onValueChange = { password = it},
                visualTransformation = PasswordVisualTransformation())
            Button(onClick = { login(username,password) }) {
                Text(text = "Login")
            }
            if (!loginState.inProgress) return
            CircularProgressIndicator(modifier = Modifier.then(Modifier.size(32.dp)))
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview
fun PreviewLoginScreen() {
    LoginScreenContent(
        login = fun(_: String, _: String) {},
        loginState = LoginState(true, inProgress = false, Credentials(""))
    )
}