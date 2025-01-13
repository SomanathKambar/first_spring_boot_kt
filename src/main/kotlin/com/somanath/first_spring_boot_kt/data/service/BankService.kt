package com.somanath.first_spring_boot_kt.data.service

import com.somanath.first_spring_boot_kt.data.source.BankDataSource
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {

    fun getBanks() = dataSource.retrieveBanks()
}