package com.example.solidnote.ui.present.view.homeScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.solidnote.ui.present.navigate.Screens
import kotlinx.coroutines.launch


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreen(navControl: NavHostController, viewModel: HomeVM = hiltViewModel()) {
    val solidNotes = viewModel.notes.collectAsState(initial = emptyList())
    val snackbarState = remember{
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()

    var title by mutableStateOf("")

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarState) },
        topBar = {
            TopAppBar(title = {Text(text = "Solid Notes")})},
        floatingActionButton = { FloatingActionButton(onClick = {
            navControl.navigate(Screens.addSolidScreen.route) }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "") }}

    ) {
        Column(modifier = Modifier
            .padding(it)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Search") },
                value = title,
                onValueChange = {
                    title = it
                },
                placeholder = { Text(text = "Type to search title") }

            )
        }
        //Spacer(modifier = Modifier.height(12.dp))


        LazyColumn(modifier = Modifier.padding(top = 150.dp)) {
            items(solidNotes.value.filter { it.title.contains(title, ignoreCase = true) }) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .border(1.dp, color = Color.Black)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = "# ${solidNotes.value.indexOf(it) + 1}")
                            Spacer(modifier = Modifier.weight(1f))
                            IconButton(onClick = {
                                navControl.navigate(
                                    Screens.UpdateScreen.getById(
                                        it.id
                                    )
                                )
                            }) {
                                Icon(imageVector = Icons.Default.Edit, contentDescription = "")
                            }
                            IconButton(onClick = {

                                viewModel.deleteSolidNote(note = it)
                                scope.launch {
                                    snackbarState.showSnackbar(
                                        "Note has been deleted",
                                        actionLabel = "ok",
                                        duration = SnackbarDuration.Short
                                    )

                                }
                            }) {
                                Icon(imageVector = Icons.Default.Delete, contentDescription = "")
                            }
                        }
                        Text(text = it.title, fontWeight = FontWeight.Bold, fontSize = 25.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = it.content)
                    }
                }
            }
        }


    }
}


