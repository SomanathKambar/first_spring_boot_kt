package com.somanath.first_spring_boot_kt.data.service

import com.somanath.first_spring_boot_kt.data.source.BankDataSource
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class BankServiceTest {

    // Use relaxed = true if you don't want to exact behaviour from mock object as original
    val bankDataSource : BankDataSource = mockk(relaxed = true)
    val bankService: BankService = BankService(bankDataSource)
    @Test
    fun `should call it's data source to retrieve banks`() {
        bankService.getBanks()
        verify {
            bankDataSource.retrieveBanks()
        }
    }
}