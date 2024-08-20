package com.test.bugCompouseSample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.test.bugCompouseSample.ui.theme.BugCompouseSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BugCompouseSampleTheme {
                Scaffold(
                ) { innerPadding ->
                    var value by rememberSaveable {
                        mutableStateOf("")
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        val keyboardController = LocalSoftwareKeyboardController.current
                        val context = LocalContext.current
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Button(
                                modifier = Modifier.weight(0.3f),
                                onClick = {
                                    keyboardController?.hide()
                                    Toast.makeText(
                                        context,
                                        "Called Hide Keyboard",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                                content = {
                                    Text(text = "Hide keyboard")
                                }
                            )
                            BasicTextField(
                                value =value,
                                onValueChange = {
                                    value = it
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .padding(30.dp)
                                    .border(width = 1.dp, color = Color.Gray)
                                    .wrapContentHeight(align = Alignment.CenterVertically),
                            )
                        }
                    }
                }
            }
        }
    }
}
