package com.knightmares.uranium.transport

import android.util.Log
import com.knightmares.uranium.Logs

class ConsoleTransport : Transport {
    public override fun accept(log: Logs) {
        System.out.printf(
            "%s[%-24s] %5s: %s\u001b[0m\n",
            log.level?.getAnsiColor(),
            log.source!!.getName(),
            log.level,
            log.message
        )
    }

}