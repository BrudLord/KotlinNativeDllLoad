import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

import kotlinx.cinterop.*
import liboutline_windows.*
import platform.windows.*

@OptIn(ExperimentalForeignApi::class)
fun main() {
    val library = LoadLibraryA("C:/Users/brudlord/IdeaProjects/KotlinNativeDllLoad/src/nativeInterop/cinterop/liboutline_windows.dll")
    if (library == null) {
        error("Failed to load library: ${GetLastError()}")
    }
    println("Hello, enter your name:")
    val startOutlineFunc = GetProcAddress(library, "StartOutline")
    val startOutline = startOutlineFunc?.reinterpret<CFunction<(CValuesRef<ByteVar>?) -> Unit>>()
    try {
        if (startOutline != null) {
            startOutline("ss://Y2hhY2hhMjAtaWV0Zi1wb2x5MTMwNTpTUU53NFdYc3BZZnRtaEt5dU9ZcEFN@195.201.111.36:40287/?outline=1".cstr)
        } else {
            println("Failed to load library")
        }
        println("StartOutline called successfully.")
    } catch (e: Exception) {
        println("An error occurred while calling StartOutline: ${e.message}")
        e.printStackTrace()
    }
    val name = readln()
//    StopOutline()
}
