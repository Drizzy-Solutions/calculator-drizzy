package com.example.calculator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
class MainActivity: ComponentActivity() { override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); setContent { App() } } }
@Composable fun App() {
    var a by remember { mutableStateOf("") }
    var b by remember { mutableStateOf("") }
    var out by remember { mutableStateOf("—") }
    MaterialTheme {
        Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(a, { a = it }, label = { Text("A") })
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(b, { b = it }, label = { Text("B") })
            Spacer(Modifier.height(8.dp))
            Button(onClick = { val x=a.toDoubleOrNull(); val y=b.toDoubleOrNull(); out = if (x!=null&&y!=null) (x+y).toString() else "NaN" }) { Text("Add") }
            Spacer(Modifier.height(12.dp))
            Text("Result: " + out)
        }
    }
}
