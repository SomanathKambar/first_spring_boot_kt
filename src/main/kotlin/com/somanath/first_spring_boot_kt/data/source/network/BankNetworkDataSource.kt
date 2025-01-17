package com.somanath.first_spring_boot_kt.data.source.network

import com.somanath.first_spring_boot_kt.data.model.Bank
import com.somanath.first_spring_boot_kt.data.source.BankDataSource
import com.somanath.first_spring_boot_kt.data.source.network.dto.BankList
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.client.getForObject
import java.io.IOException

@Repository("network")
class BankNetworkDataSource(private val restTemplate: RestTemplate): BankDataSource {
    val demo_resource_url = "http://54.193.31.159/banks"
    override fun retrieveBanks(): Collection<Bank> {
        val response: ResponseEntity<BankList> = restTemplate.getForEntity(demo_resource_url)
        return response.body?.results?:throw IOException("Couldn't fetch bank info from server")
    }

    override fun retrieveBank(accountNumber: String): Bank {
        TODO("Not yet implemented")
    }

    override fun createBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun updateBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun deleteBank(accountNumber: String) {
        TODO("Not yet implemented")
    }
}