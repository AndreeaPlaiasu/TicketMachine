fun main() {
    val machine = TicketMachine()
    val ui = UserInterface(machine)
    ui.start()
    val login = LoginSystem()
}
