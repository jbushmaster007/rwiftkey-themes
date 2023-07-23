package rwiftkey.themes.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import rwiftkey.themes.R

@Composable
fun ThemeCard(
    modifier: Modifier = Modifier,
    themeName: String,
    thumbnail: ImageBitmap? = null,
) {
    Card(
        modifier = modifier
            .heightIn(140.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        if (thumbnail != null)
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally),
                bitmap = thumbnail,
                contentDescription = ""
            )
        else
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.palette),
                contentDescription = null
            )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            Text(modifier = Modifier.padding(8.dp), text = themeName, maxLines = 1, fontWeight = FontWeight.Medium)
        }
    }
}