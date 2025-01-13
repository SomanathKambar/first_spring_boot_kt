package com.somanath.first_spring_boot_kt.data.source.mock

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test


internal class MockBankDataSourceTest {

    private val mockBankDataSource = MockBankDataSource()
    @Test
    fun `should provide a collection of Banks`() {
        val banks = mockBankDataSource.retrieveBanks()
        Assertions.assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide some mock data`() {
        val banks = mockBankDataSource.retrieveBanks()
        Assertions.assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        Assertions.assertThat(banks).anyMatch { it.trust != 0.0 }
        Assertions.assertThat(banks).allMatch { it.transactionFee != 0 }
    }
}