# Вызов динамической библиотеки на Kotlin/Native

1) Перейдите в папку libs и сгенерируйте .so/.dll/.dylib в зависимости от системы (по стандарту их стоит складывать в src/nativeInterop/cinterop)

2) Обновите путь до либы в Main.kt (сейчас для простоты написан абсолютный путь)

3) Из корня проекта вызовите ./gradlew nativeBinaries

4) По пути build/bin/native/releaseExecutable можно найти .kexe файл, запустить от имени администратора




