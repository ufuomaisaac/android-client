package com.mifos.feature.client.clientSearch

import com.mifos.core.model.objects.SearchedEntity

sealed interface SearchResultUiState {
    data object Loading : SearchResultUiState


    data object EmptyQuery : SearchResultUiState

    data object LoadFailed : SearchResultUiState

    data class Success(
        val results: List<SearchedEntity>
    ) : SearchResultUiState {
        fun isEmpty(): Boolean = results.isEmpty()
    }

    /**
     * A state where the search contents are not ready. This happens when the *Fts tables are not
     * populated yet.
     */
    data object SearchNotReady : SearchResultUiState
}