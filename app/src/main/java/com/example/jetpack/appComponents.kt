package com.example.jetpack

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HellowWorld(name : String ) {
    Text(

        modifier = Modifier
            .wrapContentWidth(align = Alignment.Start)
            .wrapContentHeight(align = Alignment.Top)
            .background(Color.Blue, shape = RoundedCornerShape(5.dp))
            .border(2.dp, Color.Green, shape = RoundedCornerShape(5.dp))
            .padding(16.dp),

        text = name,
        color = Color.Green,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline,
        maxLines =  2,
        overflow = TextOverflow.Ellipsis,
    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HellowWorldPreview( name: String = "Oscar Adam") {
    HellowWorld(name = name)
}


