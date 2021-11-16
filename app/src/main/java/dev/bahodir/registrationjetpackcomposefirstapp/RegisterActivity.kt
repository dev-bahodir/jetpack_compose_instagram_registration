package dev.bahodir.registrationjetpackcomposefirstapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import dev.bahodir.registrationjetpackcomposefirstapp.ui.theme.RegistrationJetpackComposeFirstAppTheme
import dev.bahodir.registrationjetpackcomposefirstapp.ui.theme.Shapes

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistrationJetpackComposeFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    RegisterScreen()
                }
            }
        }
    }
}

@Composable
fun RegisterScreen() {
    val registerActivity = LocalContext.current as RegisterActivity

    Column(modifier = Modifier.padding(20.dp)) {
        Spacer(modifier = Modifier.height(0.dp))
        Back(onClick = {
            registerActivity.finish()
        })
        Spacer(modifier = Modifier.height(60.dp))
        HeaderLogo()
        Spacer(modifier = Modifier.height(40.dp))
        UsernameField()
        Spacer(modifier = Modifier.height(5.dp))
        PasswordField()
        Spacer(modifier = Modifier.height(20.dp))
        ForgotPassword()
        Spacer(modifier = Modifier.height(40.dp))
        ButtonRegister()
        Spacer(modifier = Modifier.height(16.dp))
        ButtonFBRegister()
        Spacer(modifier = Modifier.height(16.dp))
        ConstraintLayoutContent()
        Spacer(modifier = Modifier.height(30.dp))
        ButtonToLogin()
        Spacer(modifier = Modifier.height(80.dp))
        Line()
        Spacer(modifier = Modifier.height(20.dp))
        Info()
    }
}
@Composable
private fun Back(onClick: () -> Unit) {
    Image(
        painter = painterResource(R.drawable.ic_arrow_back),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clickable(onClick = onClick)
            .size(25.dp)

    )
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
private fun UsernameField() {
    var username by remember { mutableStateOf("") }

    OutlinedTextField(
        value = username,
        onValueChange = { username = it },
        label = { Text(text = "Username") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
private fun PasswordField() {
    var email by remember { mutableStateOf("") }

    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text(text = "Password") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
private fun ForgotPassword() {
    Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
        Text("Forgot password?", color = Color(android.graphics.Color.parseColor("#3797EF")))
    }

    /*var password by remember { mutableStateOf("") }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(text = "Password") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )*/
}

@Composable
private fun ButtonRegister() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 1.dp),
        shape = RoundedCornerShape(15),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(android.graphics.Color.parseColor("#3797EF")))
    ) {
        Text("Log in", color = Color.White)
    }
}

@Composable
private fun ButtonFBRegister() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 1.dp),
        shape = Shapes.large,
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.ic_facebook), contentDescription = "")
            Text("  Log in with Facebook", color = Color(android.graphics.Color.parseColor("#3797EF")))
        }
    }
}

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        // Create references for the composables to constrain
        val (div1, text, div2) = createRefs()

        /*Button(
            onClick = { *//* Do something *//* },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }*/
        Divider(
            color = Color.LightGray,
            modifier = Modifier
                .constrainAs(div1) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .width(150.dp)
                .height(1.dp)
        )

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text("OR", Modifier.constrainAs(text) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(div1.end)
            end.linkTo(div2.start)
        },
            color = Color.LightGray
        )

        Divider(
            color = Color.LightGray,
            modifier = Modifier
                .constrainAs(div2) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .width(150.dp)
                .height(1.dp)
        )
    }
}

@Composable
private fun ButtonToLogin() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Text("Don’t have an account?  ", color = Color.LightGray)
        Text("Sign up. ", color = Color(android.graphics.Color.parseColor("#3797EF")), fontWeight = FontWeight.SemiBold)
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
fun Info() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (text) = createRefs()

        Text("Instagram from Facebook", Modifier.constrainAs(text) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        },
            color = Color.LightGray,
            fontSize = 16.sp
        )
    }
}