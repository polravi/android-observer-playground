package com.example.playground.domain

class InitialDomainSetter {
    companion object {
        fun getDefaultDomain(): OrderFlowDomain {
            return OrderFlowDomainImpl()
        }
    }
}