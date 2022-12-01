package ktor

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import ktor.models.KtorCompany
import ktor.models.KtorCompanyDetail
import models.Company


class KtorCompaniesDataSource(private val httpClient: HttpClient) {
    suspend fun fetchAllCompanies(): List<KtorCompany> {
        return httpClient.get {

            url {
                path("test_task/test.php")
                //setBody(KtorSearchRequest(searchQuery = ""))
            }
        }.body()
    }

    suspend fun detailCompany(id: Int): List<KtorCompanyDetail> {
        return httpClient.get {

            url {
                path("test_task/test.php")
                parameters.append("id", "${id}")
                //setBody(KtorSearchRequest(searchQuery = query))
            }
        }.body()
    }
}