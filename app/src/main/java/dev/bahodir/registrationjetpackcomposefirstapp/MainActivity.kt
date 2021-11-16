package dev.bahodir.registrationjetpackcomposefirstapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.bahodir.registrationjetpackcomposefirstapp.ui.theme.RegistrationJetpackComposeFirstAppTheme
import dev.bahodir.registrationjetpackcomposefirstapp.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistrationJetpackComposeFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginScreen(context = this)
                }
            }
        }
    }
}

@Composable
private fun LoginScreen(context: Context) {
    Column(modifier = Modifier.padding(20.dp)) {
        Spacer(modifier = Modifier.height(120.dp))
        HeaderLogo()
        Spacer(modifier = Modifier.height(50.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
            content = {
                Spacer(modifier = Modifier.height(0.dp))
                Profile()
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
            content = {
                Spacer(modifier = Modifier.height(0.dp))
                Username()
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        ButtonLogin(context = context)
        Spacer(modifier = Modifier.height(40.dp))
        ButtonFBLogin()
        Spacer(modifier = Modifier.height(200.dp))
        Line()
        Spacer(modifier = Modifier.height(20.dp))
        SignUp()
    }
}

@Composable
private fun HeaderLogo() {
    Image(
        painter = painterResource(R.drawable.ic_instagram_logo),
        contentDescription = "",
        contentScale = ContentScale.Fit,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun Profile() {
    Image(
        painter = painterResource(R.drawable.profile),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .border(1.dp, Color.Gray, CircleShape),
        alignment = Alignment.Center
    )
}

@Composable
private fun Username() {
    Text(text = "@dev_bahodir" ,color = Color.Black, fontSize = 16.sp)
}

@Composable
private fun ButtonLogin(context: Context) {
    Button(
        onClick = {
            context.startActivity(Intent(context, RegisterActivity::class.java))
        },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 1.dp),
        shape = RoundedCornerShape(15),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(android.graphics.Color.parseColor("#3797EF")))
    ) {
        Text("Log in", color = Color.White)
    }
}

@Composable
private fun ButtonFBLogin() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Text("Switch accounts", color = Color(android.graphics.Color.parseColor("#3797EF")))
    }
}

@Composable
private fun Line() {
    Divider(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
    )
}

@Composable
private fun SignUp() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Text("Don’t have an account?  ", color = Color.LightGray)
        Text(
            "Sign up",
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
    }
}