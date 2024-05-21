package com.example.solidnote.ui.present.view.updateSolidNote

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun updateSolidScreen(navControl: NavHostController, viewModel: UpdateVM = hiltViewModel()) {
    Scaffold(topBar = { TopAppBar(navigationIcon = {
        IconButton(onClick = { navControl.popBackStack() }) {
            Icon(imageVector = Icons.Default.ArrowBack,contentDescription = "")
        }
    }, title = { Text(text = "Update solid note") })
    }){
        Column(modifier = Modifier
            .padding(it)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)){
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Title") },
                value = viewModel.title,
                onValueChange = {
                    viewModel.title = it
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Content") },
                value = viewModel.content,
                onValueChange = {
                    viewModel.content = it
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {viewModel.updateNota()
                navControl.popBackStack()}){
                Text(text = "Update Solid Note")
            }
        }
    }
}