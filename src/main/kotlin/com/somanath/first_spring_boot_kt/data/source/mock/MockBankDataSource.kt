package com.somanath.first_spring_boot_kt.data.source.mock

import com.somanath.first_spring_boot_kt.data.model.Bank
import com.somanath.first_spring_boot_kt.data.source.BankDataSource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.ExceptionHandler


@Repository
class MockBankDataSource() : BankDataSource {

    private val banks = mutableListOf(Bank(accountNumber = "1234", trust = 2.0, transactionFee = 1),
        Bank(accountNumber = "5684", trust = 1.0, transactionFee = 2),
        Bank(accountNumber = "1345", trust = 3.0, transactionFee = 20))
    override fun retrieveBanks(): Collection<Bank> {
        return banks
    }

    override fun retrieveBank(accountNumber: String): Bank {
        return banks.firstOrNull() { it.accountNumber == accountNumber}?:throw NoSuchElementException("the given account number $accountNumber does not exist")
    }

    override fun createBank(bank: Bank): Bank {
        if(banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("A Bank with account number ${bank.accountNumber} already exist")
        }
        banks.add(bank)
        return bank
    }
}