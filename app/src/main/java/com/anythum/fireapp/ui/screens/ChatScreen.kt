package com.anythum.fireapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class Message(val text: String, val isSentByMe: Boolean)

@Composable
fun ChatScreen(modifier: Modifier = Modifier) {

    var message by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECE5DD))
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Group Chat ",
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
            )
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {

// message in form of Card

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = message,
                onValueChange = {},
                label = {
                    Text("Type your message...", fontStyle = FontStyle.Italic)
                }
            )
            Spacer(modifier = Modifier.sizeIn(4.dp))
            Image(
                imageVector = Icons.Default.Send,
                contentDescription = "Send Message",
                modifier = Modifier
                    .background(color = Color.LightGray, shape = CircleShape)
                    .weight(1f)
                    .weight(8f)
                    .height(40.dp)


            )

        }


    }

}

@Preview
@Composable
private fun ChatScreenPreview() {
    ChatScreen()
}

@Composable
fun MessageItems(
    modifier: Modifier = Modifier,
    message: Message
) {
    Box(
        contentAlignment = if (message.isSentByMe) Alignment.CenterEnd else Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = message.text,
            color = if (message.isSentByMe) Color.White else Color.Black,
            fontSize = 16.sp,
            modifier = Modifier
                .background(
                    color = if (message.isSentByMe) Color(0xFF128C7E) else Color.White,
                    shape = MaterialTheme.shapes.medium
                )
                .padding(8.dp)
        )
    }


}

@Preview
@Composable
private fun MessageItemsPreview() {

    MessageItems(
        message = listOf(
        Message( "Hello", false),
        Message( "Hello", false),
        Message( "Hello", false),
        )
    )
}