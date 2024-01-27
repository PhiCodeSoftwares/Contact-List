package com.phi.code.contactlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phi.code.contactlist.repository.contacts
import com.phi.code.contactlist.ui.theme.ContactListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val mContact by remember { mutableStateOf(contacts) }
            MainScreen(
                mContact
            )
        }
    }
}

@Composable
fun MainScreen(contacts: List<ContactModel>) {
    ContactListTheme(
        darkTheme = false,
        dynamicColor = false,
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn(
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(contacts) {
                    Card(contactModel = it)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    ContactListTheme {
        MainScreen(contacts)
    }
}