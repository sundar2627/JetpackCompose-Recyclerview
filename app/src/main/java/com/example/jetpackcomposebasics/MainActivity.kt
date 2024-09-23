package com.example.jetpackcomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeBasicsTheme {
                populateRecyclerview()
            }
        }
    }
}


@Composable
fun EditTextExample() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText -> text = newText },
        label = { Text("Enter your text") },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray, CircleShape),
        singleLine = true
    )
}

@Composable
fun OutlinedEditTextExample() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { newText -> text = newText },
        label = { Text("Enter your text") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        singleLine = false
    )
}
data class Student(val name:String,val age:String)

@Preview
@Composable
fun populateRecyclerview() {

    val testArrays: ArrayList<Student> = ArrayList()

    repeat(25) {
        testArrays.add(Student("sundar", "9597791971"))
    }

    LazyColumn(Modifier.fillMaxSize()) {
        items(testArrays) { test ->

            Card(Modifier.fillMaxWidth().padding(8.dp)) {
              //  Column {

                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            painter = painterResource(id = R.drawable.baseline_supervised_user_circle_24),
                            contentDescription = "ProfileImage",
                            Modifier.padding(top = 8.dp, bottom = 8.dp)
                        )

                        Column( Modifier.padding(top = 8.dp, bottom = 8.dp)
                        ) {
                                Text(
                                    test.name,
                                    Modifier.padding(10.dp),
                                    color = Color.Black,
                                    style = TextStyle(fontSize = 20.sp)
                                )
                                Text(
                                    test.age,
                                    Modifier.padding(10.dp),
                                    color = Color.Blue,
                                    style = TextStyle(fontSize = 16.sp)
                                )
                        }

                        Column( Modifier.padding(top = 8.dp, bottom = 8.dp)
                        ) {
                            Text(
                                test.age,
                                Modifier.padding(10.dp),
                                color = Color.Black,
                                style = TextStyle(fontSize = 20.sp)
                            )
                            Text(
                                test.name,
                                Modifier.padding(10.dp),
                                color = Color.Blue,
                                style = TextStyle(fontSize = 16.sp)

                            )
                        }

                    }
              //  }
            }
        }

        /* LazyRow(Modifier.fillMaxSize()) {
        items(testArrays){test->

            Card(Modifier.width(200.dp).height(100.dp).padding(10.dp)) {

                Column {

                    Text(test.name,Modifier.fillMaxWidth(), color = Color.Black, style = TextStyle(fontSize = 20.sp), textAlign = TextAlign.Center)
                    Text(test.age,Modifier.fillMaxWidth(),color = Color.Blue, style = TextStyle(fontSize = 16.sp), textAlign = TextAlign.Center)
                }
            }
        }
    }
*/
    }

    @Preview
    @Composable
    fun createUI() {

        Box(Modifier.fillMaxSize().background(Color.White).padding(20.dp)) {
            Column {

                Row(Modifier.horizontalScroll(rememberScrollState())) {
                    repeat(50) {
                        Text(
                            "Register",
                            Modifier.fillMaxWidth().padding(20.dp, 40.dp),
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
                    repeat(50) {
                        Text(
                            "Login",
                            Modifier.fillMaxWidth().padding(20.dp, 40.dp),
                            color = Color.Black,
                            textAlign = TextAlign.Start
                        )

                    }
                }
            }
        }

    }
}




