import kotlinx.cinterop.*
import platform.posix.*

@OptIn(ExperimentalForeignApi::class)
fun main() {
    val libraryPath = "/home/brudlord/NIR/KotlinNativeDllLoad/src/nativeInterop/cinterop/linux/liboutline_linux.so"
    val library = dlopen(libraryPath, RTLD_LAZY)
    if (library == null) {
        perror("Failed to load library")
        return
    }
    println("Hello, enter your name:")

    val startOutlineFunc = dlsym(library, "StartOutline")
    val startOutline = startOutlineFunc?.reinterpret<CFunction<(CValuesRef<ByteVar>?) -> Unit>>()

    if (startOutline != null) {
        try {
            startOutline("ss://Y2hhY2hhMjAtaWV0Zi1wb2x5MTMwNTpTUU53NFdYc3BZZnRtaEt5dU9ZcEFN@195.201.111.36:40287/?outline=1".cstr)
            println("StartOutline called successfully.")
        } catch (e: Exception) {
            println("An error occurred while calling StartOutline: ${e.message}")
            e.printStackTrace()
        }
    } else {
        println("Failed to load StartOutline function")
    }
    val name = readln()
    dlclose(library)
}
