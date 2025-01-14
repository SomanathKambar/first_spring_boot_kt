package com.somanath.first_spring_boot_kt.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Bank( @JsonProperty("account_number") val accountNumber:String, @JsonProperty("trust") var trust:Double, @JsonProperty("default_transaction_fee") var transactionFee:Int )
