package companies

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.fade
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.placeholder
import companies.models.CompaniesEvent
import companies.models.CompaniesViewState
import models.Company
import theme.Theme

@Composable
fun CompaniesView(viewState: CompaniesViewState, eventHandler: (CompaniesEvent) -> Unit) {
//    LaunchedEffect(Unit) {
//
//    }

//    Column {
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

        //val companies = viewState.companies.collectAsLazyPagingItems()

        LazyColumn(
            modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 16.dp,
                vertical = 32.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Companies",
                    style = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
            items(
                items = viewState.companies,
                key = {it.companyId}
            ) {
                CompanyRow(companyModel = it, eventHandler)
            }
//            items(
//                items = companies,
//                key = { it.id }
//            ) {
//                CompanyRow(companyModel = it)
//            }
//            viewState.companies.forEach {
//                item {
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Card(
//                        shape = RoundedCornerShape(16.dp),
//                        elevation = 8.dp
//                    ) {
//                        Row(
//                            modifier = Modifier
//                                .clickable { eventHandler.invoke(CompaniesEvent.CompanyClicked(it)) }
//                                .fillMaxWidth()
//                                .padding(16.dp),
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Image(
//                                painter = rememberAsyncImagePainter(it.companyImg),
//                                contentDescription = it.companyImg,
//                                modifier = Modifier
//                                    .placeholder(
//                                        visible = !viewState.isLoaded,
//                                        highlight = PlaceholderHighlight.fade(),
//                                    )
//                                    .size(64.dp)
//                            )
//                            Spacer(modifier = Modifier.width(16.dp))
//                            Column(
//                                modifier = Modifier.weight(1f)
//                            ) {
//                                Text(
//                                    text = it.companyName,
//                                    modifier = Modifier
//                                        .placeholder(
//                                            visible = !viewState.isLoaded,
//                                            highlight = PlaceholderHighlight.fade(),
//                                        )
//                                        .fillMaxWidth()
//                                )
//                                Spacer(modifier = Modifier.height(8.dp))
//                                Text(
//                                    text = it.companyImg,
//                                    style = MaterialTheme.typography.caption,
//                                    modifier = Modifier
//                                        .placeholder(
//                                            visible = !viewState.isLoaded,
//                                            highlight = PlaceholderHighlight.fade(),
//                                        )
//                                        .fillMaxWidth()
//                                )
//                            }
//                        }
//                    }
//                    Spacer(modifier = Modifier.height(8.dp))
//
//
//
////                    Text(
////                        modifier = Modifier
////                            .clickable { eventHandler.invoke(CompaniesEvent.CompanyClicked(it)) }
////                            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
////                            .placeholder(
////                                visible = it == null,
////                                color = Theme.colors.tagColor,
////                                // optional, defaults to RectangleShape
////                                shape = RoundedCornerShape(4.dp)
////                            ),
////                            text = it.companyName,
////                            color = Theme.colors.secondaryTextColor,
////                            fontWeight = FontWeight.Medium
////                    )
//                }
//            }
        }
//    }
}


@Composable
private fun CompanyRow(
    companyModel: Company?,
    eventHandler: (CompaniesEvent) -> Unit
) {
    Spacer(modifier = Modifier.height(8.dp))
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .clickable { eventHandler.invoke(CompaniesEvent.CompanyClicked(companyModel!!)) }
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(companyModel?.companyImg),
                contentDescription = companyModel?.companyImg ?: "",
                modifier = Modifier
                    .placeholder(
                        visible = companyModel == null,
                        highlight = PlaceholderHighlight.fade(),
                    )
                    .size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = companyModel?.companyName ?: "",
                    modifier = Modifier
                        .placeholder(
                            visible = companyModel == null,
                            highlight = PlaceholderHighlight.fade(),
                        )
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = companyModel?.companyImg ?: "",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .placeholder(
                            visible = companyModel == null,
                            highlight = PlaceholderHighlight.fade(),
                        )
                        .fillMaxWidth()
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}
