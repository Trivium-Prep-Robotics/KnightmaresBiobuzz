package com.knightmares.uranium

data class Logs(
    val source: Logger,
    val level: LogLevel?,
    val message: String?
)