package com.knightmares.uranium.transport

interface Transports {
    companion object {
        val CONSOLE: Transport = ConsoleTransport()
    }
}