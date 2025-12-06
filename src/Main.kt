fun main() {
    val adminSystem = AdminSystem()

    println("=== Train Ticket Admin System (Group Member B) ===")
    adminSystem.displayMenu()
import java.util.Scanner

fun main() {
    val machine = TicketMachine()
    val ui = UserInterface(machine)
    val sc = Scanner(System.`in`)

    while (true) {
        println("\n1. Buy Ticket")
        println("2. Admin Login")
        println("3. Exit")
        print("Choose option: ")

        when (readLine()!!.trim()) {
            "1" -> ui.start()
            "2" -> ui.adminLogin()
            "3" -> return
            else -> println("Invalid choice")
        }
    }

}

fun main() {
    val machine = TicketMachine()
    val ui = UserInterface(machine)
    ui.start()
}
