package companies.models

sealed class CompanyCardEvent {
    class Query(val id: Int) : CompanyCardEvent()
}