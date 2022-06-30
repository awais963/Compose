package com.matech.jetpackcompose20

import android.graphics.Matrix
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matech.jetpackcompose20.ui.theme.JetpackCompose20Theme
import com.matech.jetpackcompose20.ui.theme.internationalOrange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose20Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginView()
                }
            }
        }
    }
}

@Composable
fun LoginView() {
    Column() {
        Box(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()

        ) {
            Image(
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = "", Modifier.fillMaxSize(), contentScale = ContentScale.FillWidth,

                )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Welcome",
                    fontSize = 40.sp,
                    modifier = Modifier
                        .fillMaxSize()
                        .width(IntrinsicSize.Max),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "To",
                    fontSize = 24.sp,
                    modifier = Modifier
                        .fillMaxSize()
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
        val email = remember { mutableStateOf(TextFieldValue()) }


    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackCompose20Theme {
        LoginView()
    }
}