package com.somanath.first_spring_boot_kt.controller

import com.somanath.first_spring_boot_kt.data.model.Bank
import com.somanath.first_spring_boot_kt.data.service.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/banks")
class BankController(private val service :BankService) {

    @GetMapping
    fun getBanks(): Collection<Bank> = service.getBanks()
}