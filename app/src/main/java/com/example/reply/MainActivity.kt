package com.example.reply

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import com.example.reply.ui.ReplyApp
import com.example.reply.ui.theme.ReplyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReplyTheme {
                val layoutDirection = LocalLayoutDirection.current
                val windowInsets = WindowInsets.safeDrawing.asPaddingValues()
                Scaffold(
                    modifier = Modifier
                        .padding(
                            start = windowInsets.calculateStartPadding(layoutDirection),
                            end = windowInsets.calculateEndPadding(layoutDirection)
                        )
                ) { innerPadding ->
                    ReplyApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyAppCompactPreview() {
    ReplyTheme {
        val layoutDirection = LocalLayoutDirection.current
        val windowInsets = WindowInsets.safeDrawing.asPaddingValues()
        Scaffold(
            modifier = Modifier
                .padding(
                    start = windowInsets.calculateStartPadding(layoutDirection),
                    end = windowInsets.calculateEndPadding(layoutDirection)
                )
        ) { innerPadding ->
            ReplyApp(modifier = Modifier.padding(innerPadding))
        }
    }
}