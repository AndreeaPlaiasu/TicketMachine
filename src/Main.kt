fun main() {
    val machine = TicketMachine()
    val ui = UserInterface(machine)
    ui.start()
    val login = LoginSystem()

    while (true){
        println("\n1. Buy ticket 2. Admin Login 3. Exit")
        print("Choice:")

        when(sc.nextLine()){
            "1" -> ui.start()
            "2" -> {
                print("Username: "); val u = sc.nextLine()
                print("Password: "); val p = sc.nextLine()
            }

        }
    }
}
