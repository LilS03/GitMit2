package com.example.features.allusers.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.features.allusers.R
import com.example.features.allusers.domain.model.User

@Composable
fun User(
    user: User
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 6.dp)
            .wrapContentHeight(),
            //.clickable { UserDetailsScreen(user.login) },
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val painter = rememberAsyncImagePainter(model = user.avatarUrl)
            Image(
                painter = painter,
                contentDescription = stringResource(id = R.string.name),
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Text(
                text = user.login,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}