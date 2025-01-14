package com.somanath.first_spring_boot_kt.data.source

import com.somanath.first_spring_boot_kt.data.model.Bank

interface BankDataSource {
    fun retrieveBanks():Collection<Bank>
    fun retrieveBank(accountNumber: String): Bank
     fun createBank(bank: Bank): Bank
     fun updateBank(bank: Bank): Bank
}