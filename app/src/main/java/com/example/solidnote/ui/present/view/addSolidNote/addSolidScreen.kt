package com.example.solidnote.ui.present.view.addSolidNote

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable

fun addSolidScreen(){
    Scaffold(topBar = { TopAppBar(navigationIcon = {
                                                   IconButton(onClick = { /*TODO*/ }) {
                                                       Icon(imageVector = Icons.Default.ArrowBack,contentDescription = "")
                                                   }
    }, title = { Text(text = "New solid note")})}){
        Column(modifier = Modifier
            .padding(it)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)){
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text = "Title")},
                value = "",
                onValueChange = {

                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text = "Content")},
                value = "",
                onValueChange = {

                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}){
                Text(text = "Add Solid Note")
            }
        }
    }
}