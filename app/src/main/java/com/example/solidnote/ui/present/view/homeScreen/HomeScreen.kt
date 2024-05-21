package com.example.solidnote.ui.present.view.homeScreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable

fun Home(){
    HomeScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreen(){

    Scaffold(
        topBar = {
            TopAppBar(title = {Text(text = "Solid Notes")})
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)){
            items(14){
                Box(modifier = Modifier.padding(16.dp).border(1.dp,color = Color.Black)){
                    Column(modifier = Modifier.padding(20.dp)){
                        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                            Text(text = "# ${it+1}")
                            Spacer(modifier = Modifier.weight(1f))
                            IconButton(onClick = {}){
                                Icon(imageVector= Icons.Default.Edit, contentDescription = "")
                            }
                            IconButton(onClick = {}){
                                Icon(imageVector= Icons.Default.Delete, contentDescription = "")
                            }
                        }
                        Text(text = "Title")
                        Text(text = "Content")
                    }
                }
            }
        }
    }
}