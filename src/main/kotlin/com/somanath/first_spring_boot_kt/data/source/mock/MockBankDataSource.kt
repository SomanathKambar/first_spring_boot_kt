package com.somanath.first_spring_boot_kt.data.source.mock

import com.somanath.first_spring_boot_kt.data.model.Bank
import com.somanath.first_spring_boot_kt.data.source.BankDataSource
import org.springframework.stereotype.Repository


@Repository
class MockBankDataSource() : BankDataSource {

    private val banks = listOf(Bank(accountNumber = "1234", trust = 2.0, transactionFee = 1),
        Bank(accountNumber = "5684", trust = 1.0, transactionFee = 2),
        Bank(accountNumber = "1345", trust = 3.0, transactionFee = 20))
    override fun retrieveBanks(): Collection<Bank> {
        return banks
    }
}