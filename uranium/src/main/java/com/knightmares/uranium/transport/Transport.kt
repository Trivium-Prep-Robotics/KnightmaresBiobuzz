package com.knightmares.uranium.transport

import com.knightmares.uranium.Logs

fun interface Transport {
    fun accept(logs: Logs)
}