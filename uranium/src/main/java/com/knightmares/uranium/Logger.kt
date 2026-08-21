package com.knightmares.uranium

import com.knightmares.uranium.transport.Transport
import com.knightmares.uranium.transport.Transports
import java.util.Set
import java.util.function.Consumer

class Logger {

    private var name: String? = null
    private var transports: MutableSet<Transport> = Set.of<Transport>(Transports.CONSOLE)

    fun Logger(name: String?) {
        this.name = name
    }

    fun transports(vararg transports: Transport) {
        this.transports = Set.of<Transport>(*transports)
    }

    fun getName(): String? {
        return name
    }

    fun log(log: Logs) {
        transports.forEach(Consumer { target: Transport -> target!!.accept(log) })
    }

    fun log(level: LogLevel, message: String) {
        log(Logs(this, level, message))
    }

    fun log(level: LogLevel, format: String, vararg args: Any) {
        log(Logs(this, level, String.format(format, *args)))
    }

    fun debug(message: String) {
        log(LogLevel.DEBUG, message)
    }

    fun info(message: String) {
        log(LogLevel.INFO, message)
    }

    fun warn(message: String) {
        log(LogLevel.WARN, message)
    }

    fun error(message: String) {
        log(LogLevel.ERROR, message)
    }

    fun fatal(message: String) {
        log(LogLevel.FATAL, message)
    }

    fun debug(format: String, vararg args: Any) {
        log(LogLevel.DEBUG, format, *args)
    }

    fun info(format: String, vararg args: Any) {
        log(LogLevel.INFO, format, *args)
    }

    fun warn(format: String, vararg args: Any) {
        log(LogLevel.WARN, format, *args)
    }

    fun error(format: String, vararg args: Any) {
        log(LogLevel.ERROR, format, *args)
    }

    fun fatal(format: String, vararg args: Any) {
        log(LogLevel.FATAL, format, *args)
    }
}