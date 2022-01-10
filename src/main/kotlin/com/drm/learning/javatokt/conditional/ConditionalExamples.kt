package com.drm.learning.javatokt.conditional

import java.util.*

class ConditionalExamples {
    fun getTransactionId(transactionId : String?) {
        val result = if (transactionId.isNullOrBlank()) {
            UUID.randomUUID().toString()
        } else {
            transactionId
        }
    }
}