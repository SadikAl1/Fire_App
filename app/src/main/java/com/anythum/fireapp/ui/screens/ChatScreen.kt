package com.anythum.fireapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatScreen(modifier: Modifier = Modifier) {
    Box (
        modifier = Modifier.background(
            MaterialTheme.colorScheme.primary
        )
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Group Chat ",
                fontSize = 30.sp,
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
                .padding(bottom = 40.dp)
                .padding(8.dp)
        ) {

        }
        Row(
            Modifier.fillMaxWidth()
        ) {
//            OutlinedTextField(value = "" , onValueChange ="Write ur msg" )
            Image(imageVector = Icons.Default.Send, contentDescription = null)
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun ChatScreenPreview() {


    ChatScreen()
}