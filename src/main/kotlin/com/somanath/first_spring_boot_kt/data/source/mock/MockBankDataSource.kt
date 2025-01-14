package com.somanath.first_spring_boot_kt.data.source.mock

import com.somanath.first_spring_boot_kt.data.model.Bank
import com.somanath.first_spring_boot_kt.data.source.BankDataSource
import org.springframework.stereotype.Repository


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

    override fun updateBank(bank: Bank): Bank {
        val existingBank = banks.firstOrNull(){it.accountNumber == bank.accountNumber}
        if(existingBank == null) {
            throw NoSuchElementException("the given account number ${bank.accountNumber} does not exist")
        } else {
            banks.forEach { if(it.accountNumber == bank.accountNumber) {
                it.apply {
                    trust = bank.trust
                    transactionFee = bank.transactionFee
                }
            } }
        }
       return bank
    }

    override fun deleteBank(accountNumber: String) {
       val bank : Bank = banks.firstOrNull{it.accountNumber == accountNumber}?: throw  NoSuchElementException("No Account Exist with accountNumber $accountNumber")
        banks.remove(bank)
    }
}