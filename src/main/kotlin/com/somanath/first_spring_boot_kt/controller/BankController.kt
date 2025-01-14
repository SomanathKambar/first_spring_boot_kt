package com.somanath.first_spring_boot_kt.controller

import com.somanath.first_spring_boot_kt.data.model.Bank
import com.somanath.first_spring_boot_kt.data.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/banks")
class BankController(private val service :BankService) {


    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFoundException(noSuchElementException: NoSuchElementException): ResponseEntity<String> {
            return ResponseEntity(noSuchElementException.message, HttpStatus.NOT_FOUND)
    }
    @GetMapping
    fun getBanks(): Collection<Bank> = service.getBanks()

    @GetMapping("/{accountNumber}")
    fun getBanks(@PathVariable accountNumber:String) = service.getBank(accountNumber)
}