package com.example.playground.domain

import com.example.playground.domain.order.*

class InitialDomainSetter {
    companion object {
        fun getDefaultDomain(): OrderFlowDomain {
            return OrderFlowDomainImpl()
        }
    }
}