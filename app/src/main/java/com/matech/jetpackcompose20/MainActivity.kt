package com.matech.jetpackcompose20

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matech.jetpackcompose20.ui.theme.JetpackCompose20Theme
import com.matech.jetpackcompose20.ui.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    private val viewModel = AuthViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose20Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginView(viewModel)
                }
            }
        }

    }
}

@Composable
fun LoginView(viewModel: AuthViewModel) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(
            modifier = Modifier

                .fillMaxWidth()

        ) {
            Image(
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = "",
                Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth,

                )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Text(
                    text = "Welcome",
                    fontSize = 40.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(IntrinsicSize.Max),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "To",
                    fontSize = 24.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(IntrinsicSize.Max),
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(id = R.drawable.awais),
                    contentDescription = "", Modifier.size(150.dp),

                    )

            }
        }
        Text(
            text = "Login",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .width(IntrinsicSize.Max),
            textAlign = TextAlign.Start
        )
        Text(
            text = "To Your Account",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .width(IntrinsicSize.Max),
            textAlign = TextAlign.Start
        )
        val emailValue = viewModel.emailValue.value
        val passwordValue = viewModel.passwordValue.value
        // val emailValue = remember { mutableStateOf("")}
        //  val emailValue = savedInstanceState{""}
        Spacer(modifier = Modifier.padding(16.dp))
        val focusManager = LocalFocusManager.current
        OutlinedTextField(
            value = emailValue,
            colors = TextFieldDefaults.textFieldColors(textColor = Color.Black),
            onValueChange = { newValue ->
                viewModel.onEmailInputChanged(newValue)
            },
            maxLines = 1,
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
            label = { Text("Email", color = Color.Black) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(
            value = passwordValue,
            colors = TextFieldDefaults.textFieldColors(textColor = Color.Black),
            onValueChange = { newValue ->
                viewModel.onPasswordInputChanged(newValue)
            },
            singleLine = true,

            maxLines = 1,
            label = { Text("Password", color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )
        val context = LocalContext.current
        Button(onClick = {
            Toast.makeText(
                context,
                "Email: $emailValue , Password: $passwordValue",
                Toast.LENGTH_SHORT
            ).show()
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "LOGIN")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackCompose20Theme {
        LoginView(viewModel = AuthViewModel())
    }
}