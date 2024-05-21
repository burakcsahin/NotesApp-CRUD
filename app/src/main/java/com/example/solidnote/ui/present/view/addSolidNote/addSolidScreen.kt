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
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.solidnote.ui.present.navigate.Screens
import com.example.solidnote.ui.present.view.homeScreen.HomeVM
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun addSolidScreen(navControl: NavHostController, viewModel: AddVM= hiltViewModel()) {
    val snackbarState = remember{
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()
    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarState)}, topBar = { TopAppBar(navigationIcon = {
                                                   IconButton(onClick = { navControl.popBackStack()}) {
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
                value = viewModel.title,
                onValueChange = {
                    viewModel.title=it
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text = "Content")},
                value = viewModel.content,
                onValueChange = {
                    viewModel.content = it
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.addSolidNote()
                    scope.launch {
                        snackbarState.showSnackbar("Note has been created", actionLabel = "ok", duration = SnackbarDuration.Short)
                        navControl.popBackStack()

                    }


                }){
                Text(text = "Add Solid Note")
            }
        }
    }
}