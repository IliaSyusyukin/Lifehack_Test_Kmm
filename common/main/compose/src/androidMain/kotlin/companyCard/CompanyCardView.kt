package companyCard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIconDefaults.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import companies.models.CompaniesEvent
import companies.models.CompaniesViewState
import companies.models.CompanyCardEvent
import companies.models.CompanyCardViewState
import theme.Theme

@Composable
fun CompanyCardView(viewState: CompanyCardViewState, eventHandler: (CompanyCardEvent) -> Unit) {
    Column {
//        TextField(
//            modifier = Modifier
//                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
//                .fillMaxWidth()
//                .height(56.dp),
//            value = viewState.query,
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color(0xFF1F2430),
//                textColor = Color(0xFF696C75),
//                cursorColor = Theme.colors.highlightTextColor,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent
//            ),
//            placeholder = { Text("Search Game", color = Theme.colors.hintTextColor) },
//            shape = RoundedCornerShape(10.dp),
//            onValueChange = {
//                eventHandler.invoke(CompaniesEvent.QueryChanged(it))
//            })

        LazyColumn {
            viewState.companyDetail.forEach {
                item {
                    Text(
                        modifier = Modifier
                            .clickable { }
                            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                        text = it.companyCardDesc,
                        color = Theme.colors.secondaryTextColor,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}
