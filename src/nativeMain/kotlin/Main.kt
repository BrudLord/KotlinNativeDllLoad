import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

import kotlinx.cinterop.*
import liboutline_windows.*

@OptIn(ExperimentalForeignApi::class)
fun main() {
    println("Hello, enter your name:")
    StartOutline("ss://Y2hhY2hhMjAtaWV0Zi1wb2x5MTMwNTpTUU53NFdYc3BZZnRtaEt5dU9ZcEFN@195.201.111.36:40287/?outline=1".cstr)
    val name = readln()
    StopOutline()
}
