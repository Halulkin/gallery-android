package com.halulkin.gallery.ui.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.halulkin.gallery.domain.model.Image

@Composable
fun ImageWithTitle(
    image: Image,
    onImageClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        AsyncImage(
            model = image.url,
            contentScale = ContentScale.Crop,
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable(
                    onClick = { onImageClick(image.url) },
                )
                .clip(RoundedCornerShape(12.dp)),
        )
        Text(
            text = image.title.ifBlank { "No title" },
            style = MaterialTheme.typography.bodyLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )
    }
}

@Preview(name = "ImageWithTitle")
@Composable
private fun PreviewImageWithTitle() {
    ImageWithTitle(
        image = Image(
            title = "Sample Image",
            url = "https://example.com/sample.jpg",
        ),
        onImageClick = {},
    )
}
