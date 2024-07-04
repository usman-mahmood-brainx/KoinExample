package com.example.koinexample

class MainRepositoryImp(private val myApi: MyApi) : MainRepository {
    override fun doNetworkCall() {
        myApi.callApi()

    }
}