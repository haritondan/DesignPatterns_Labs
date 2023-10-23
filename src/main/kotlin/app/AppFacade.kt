package app

class AppFacade(private val app: App) {
    fun start() {
        app.start()
    }
}
