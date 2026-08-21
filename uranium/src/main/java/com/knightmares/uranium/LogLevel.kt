package com.knightmares.uranium

enum class LogLevel(ansiColor: String) {
    DEBUG("\u001b[37m"),
    INFO("\u001b[37;1m"),
    WARN("\u001b[33;1m"),
    ERROR("\u001b[31m"),
    FATAL("\u001b[31;1m");

    val ansiColor: String

    init {
        this.ansiColor = ansiColor
    }

    fun getAnsiColor(): String {
        return ansiColor
    }
}