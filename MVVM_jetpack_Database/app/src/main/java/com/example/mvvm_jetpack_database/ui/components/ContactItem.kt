package com.example.mvvm_jetpack_database.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mvvm_jetpack_database.R
import com.example.mvvm_jetpack_database.data.model.People


@Composable
fun ContactItem(
    people: People,
){


    Card(
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp,
        modifier = Modifier.padding(top = 4.dp)
            .clickable { /*TODO*/  }
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .background(color = MaterialTheme.colors.surface),

            ) {
            val (image, name, metAt, contact, email) = createRefs()

            Image(painter = painterResource(id = R.drawable.persion),
                contentDescription = people.name,
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                    .fillMaxWidth(0.2f)
                    .fillMaxHeight()
            )

            Text(
                text = people.name,
                modifier = Modifier
                    .constrainAs(name) {
                        top.linkTo(parent.top)
                        start.linkTo(image.end)
                    }
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 5.dp),
                style = TextStyle(
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                ),

                )
            Text(
                text = people.contact,
                modifier = Modifier
                    .constrainAs(contact) {
                        top.linkTo(name.bottom)
                        start.linkTo(image.end)
                    }
                    .fillMaxWidth()
                    .padding(top = 7.dp, start = 5.dp),
                style = TextStyle(
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                ),

                )

            Text(
                text = people.metAt,
                modifier = Modifier
                    .constrainAs(metAt) {
                        top.linkTo(contact.bottom)
                        start.linkTo(image.end)
                    }
                    .fillMaxWidth(0.5f)
                    .padding(top = 4.dp, start = 5.dp),
                style = TextStyle(
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Thin
                ),

                )

            Text(
                text = people.email,
                modifier = Modifier
                    .constrainAs(email) {
                        top.linkTo(contact.bottom)
                        start.linkTo(metAt.end)
                    }
                    .fillMaxWidth(0.5f)
                    .padding(top = 4.dp, start = 5.dp),
                style = TextStyle(
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Thin
                ),


                )


        }

    }
}