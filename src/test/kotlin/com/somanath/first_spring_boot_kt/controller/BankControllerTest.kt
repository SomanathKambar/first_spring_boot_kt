package com.somanath.first_spring_boot_kt.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.somanath.first_spring_boot_kt.data.model.Bank
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*


@SpringBootTest
@AutoConfigureMockMvc
class BankControllerTest {

    @Autowired
    lateinit var mockMVC: MockMvc
    private val  baseUrl: String = "/api/banks"

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("getBanks()")
    inner class GetBanks {
        @Test
        fun `should return all banks`() {
            //when/then
            mockMVC.get(baseUrl)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[1].accountNumber") { value("1345")}
                }
        }
    }


    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("Get api/banks")
    inner class GetBank{
        @Test
        fun `should return bank with the given account number`() {
            //given
            val accountNumber = "1345"
            mockMVC.get("${baseUrl}/$accountNumber")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.trust") { value("3.0")}
                }
        }

        @Test
        fun `should return NOT Found when account number not exist`() {
            //given
            val accountNumber = "doesn't exist"
            mockMVC.get("$baseUrl/$accountNumber")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("Post api/banks")
    inner class AddBank{

        @Test
        fun `should add the new  bank `() {
            val accountNumber = "2345"
            val trust = 2.1
            val transactionFee = 11
                    val newBank = Bank(accountNumber, trust, transactionFee)
            val postRequest = mockMVC.post(baseUrl){
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newBank)
            }

            postRequest.andDo {
                print()
            }.andExpect {
                    status { isCreated() }
                    content { contentType(MediaType.APPLICATION_JSON)}
                        jsonPath("$.accountNumber") { value(accountNumber)}
                }
        }

        @Test
        fun `should throw BAD Request when bank already exist`() {
            val accountNumber = "1345"
            val trust = 2.1
            val transactionFee = 11
            val newBank = Bank(accountNumber, trust, transactionFee)
            val postRequest = mockMVC.post(baseUrl){
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newBank)
            }

            postRequest.andDo {
                print()
            }.andExpect {
                status { isBadRequest() }
            }
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("Patch api/banks")
    inner class PatchExistingBank{

        @Test
        fun `should update existing bank `() {
            val accountNumber = "1345"
            val trust = 2.5
            val transactionFee = 13
            val newBank = Bank(accountNumber, trust, transactionFee)
            val patchRequest = mockMVC.patch(baseUrl){
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newBank)
            }

            patchRequest.andDo {
                print()
            }.andExpect {
                status { isOk() }
            }
            mockMVC.get("$baseUrl/${newBank.accountNumber}").andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.accountNumber") { value(accountNumber)}
                    jsonPath("$.trust") {value(trust)}
                }
        }
    }

    @Test
    fun `should throw BAD Request if Bank doesn't exist `() {

        val accountNumber = "invalid"
        val trust = 2.1
        val transactionFee = 11
        val newBank = Bank(accountNumber, trust, transactionFee)
        val patchRequest = mockMVC.patch(baseUrl){
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newBank)
        }

        patchRequest.andDo {
            print()
        }.andExpect {
            status { isNotFound() }
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("Delete api/banks/{accountNumber}")
    inner class DeleteExistingBank {

        @Test
        fun `should delete a existing bank `() {
            val accountNumber = "1234"
            mockMVC.delete("$baseUrl/$accountNumber")
                .andDo { print() }.andExpect { status { isOk() } }

        }

        @Test
        fun `should throw NotFound exception if account not exists  `() {
            val accountNumber = "invalid"
            mockMVC.delete("$baseUrl/$accountNumber")
                .andDo { print() }.andExpect { status { isNotFound()} }
        }
    }
}