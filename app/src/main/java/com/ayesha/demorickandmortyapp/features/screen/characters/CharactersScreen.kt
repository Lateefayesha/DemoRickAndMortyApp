package com.ayesha.demorickandmortyapp.features.screen.characters

import android.content.res.Configuration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.foundation.lazy.items

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems

import com.ayesha.demorickandmortyapp.R
import com.ayesha.demorickandmortyapp.data.data.model.Status
import com.ayesha.demorickandmortyapp.data.data.model.dto.CharacterDto
import com.ayesha.demorickandmortyapp.features.component.RickAndMortyCharacterCard
import com.ayesha.demorickandmortyapp.features.component.RickAndMortyCharacterShimmer
import com.ayesha.demorickandmortyapp.features.component.RickAndMortyScaffold
import com.ayesha.demorickandmortyapp.features.component.RickAndMortyTopBar
import com.ayesha.demorickandmortyapp.utils.Utility.rememberFlowWithLifecycle
import kotlinx.coroutines.flow.Flow

@Composable
fun CharactersScreen (
    viewModel: CharactersViewModel,
    navigateToDetail: (CharacterDto?)->Unit
) {


    val scaffoldState :SnackbarHostState = remember { SnackbarHostState() }
    val viewState = viewModel.uiState.collectAsState().value

    RickAndMortyScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            RickAndMortyTopBar(text = stringResource(id = R.string.characters_screen_title),
            elevation = 10.dp,
                )

        },
        content = {
                  Content(
                      isLoading = viewState.isLoading,
                      pagedData = viewState.pagedData,
                      onTriggerEvent = {
                        viewModel.onTriggerEvent(it)
                      },
                      clickDetails = {
                          navigateToDetail.invoke(it)
                      }
                  )

        },
        backgroundColor = MaterialTheme.colorScheme.background
    )


}
@Composable
private fun Content(isLoading:Boolean=false,
pagedData : Flow<PagingData<CharacterDto>>?=null,
onTriggerEvent: (CharacterViewEvent) -> Unit,
clickDetails: (CharacterDto)->Unit){
    var pagingItems :LazyPagingItems<CharacterDto>? = null
    pagedData?.let {
        pagingItems = rememberFlowWithLifecycle(it).collectAsLazyPagingItems()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp)

    ){
        LazyColumn(
            contentPadding = PaddingValues(vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            if(isLoading){
                items(10){
                    RickAndMortyCharacterShimmer()
                }
            }else if(pagedData!=null && pagingItems!=null){

                items(pagingItems!!.itemSnapshotList){item->
                    RickAndMortyCharacterCard(
                        status = item?.status ?: Status.Unknown,
                        detailClick = {
                            clickDetails.invoke(item!!)
                        },
                        dto = item,
                        onTriggerEvent = {
                            onTriggerEvent.invoke(CharacterViewEvent.updateFavorite(it))
                        }
                    )
                }

            }

        }
    }

}


@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun DetailContentItemViewPreview() {
    CharactersScreen(viewModel = hiltViewModel(), navigateToDetail = {})
}