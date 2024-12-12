package ict.android.steamdex.ui.components.buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun <T> RadioDialog(
    showDialog: Boolean,
    title: String,
    currentValue: T,
    optionListNames: List<String>,
    optionListValues: List<T>,
    onDismissDialog: () -> Unit,
    onItemClick: (T) -> Unit,
    modifier: Modifier = Modifier
) {
    if (showDialog) {
        Dialog(onDismissDialog) {
            Card(modifier.fillMaxWidth(0.9F)) {
                Column(Modifier.padding(16.dp)) {
                    Text(
                        text = title,
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                    optionListNames.forEachIndexed { index, themeOption ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onItemClick(optionListValues[index])
                                    onDismissDialog()
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = optionListValues[index] == currentValue,
                                onClick = {
                                    onItemClick(optionListValues[index])
                                    onDismissDialog()
                                }
                            )
                            Text(
                                themeOption,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    CancelButton(onDismissDialog)
                }
            }
        }
    }
}

@PreviewSteam
@Composable
private fun RadioDialogPreview() {
    var currentValue: Boolean? by remember {
        mutableStateOf(null)
    }
    val namesList = listOf("True", "False", "Maybe")
    val valueList = listOf(true, false, null)
    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            RadioDialog(
                showDialog = true,
                title = "Preview",
                currentValue = currentValue,
                optionListNames = namesList,
                optionListValues = valueList,
                onDismissDialog = {},
                onItemClick = {
                    currentValue = it
                }
            )
        }
    }
}
