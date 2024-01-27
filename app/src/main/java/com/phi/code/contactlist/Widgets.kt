package com.phi.code.contactlist

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

data class ContactModel(
    val firstName: MutableState<String>,
    val lastName: MutableState<String>,
    val imageUrl: MutableState<String>,
)

@Composable
fun Card(
    contactModel: ContactModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        AsyncImage(
            modifier = Modifier
                .size(58.dp)
                .clip(CircleShape)
                .background(Color.White),
            model = contactModel.imageUrl.value,
            placeholder = painterResource(id = R.drawable.ic_account),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
                .weight(1F)
        ) {
            Text(
                text = contactModel.firstName.value,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(text = contactModel.lastName.value, fontSize = 14.sp)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun CardPreview() {
    Scaffold(

    ) {
        Card(
            contactModel = ContactModel(
                firstName = remember {
                    mutableStateOf("Phi Code")
                },
                lastName = remember {
                    mutableStateOf("Softwares")
                },
                imageUrl = remember {
                    mutableStateOf("")
                },
            )
        )
    }
}