import java.util.Scanner

fun main() {
    val machine = TicketMachine()
    val ui = UserInterface(machine)
    val sc = Scanner(System.`in`)

    while (true) {
        println("\n1. Buy Ticket  2. Admin  3. Exit")
        print("> ")

        when (sc.nextLine()) {
            "1" -> ui.start()
            "2" -> {
                print("User: "); val u = sc.nextLine()
                print("Pass: "); val p = sc.nextLine()
                if (login(u, p)) {
                    var logged = true
                    while (logged) {
                        println("\n1. View  2. Add  3. Search  4. Delete  5. Logout")
                        print("> ")
                        when (sc.nextLine()) {
                            "1" -> viewOffers()
                            "2" -> {
                                print("Station: "); val s = sc.nextLine()
                                print("Discount: "); val d = sc.nextLine().toDoubleOrNull() ?: 0.0
                                print("Start: "); val st = sc.nextLine()
                                print("End: "); val e = sc.nextLine()
                                addOffer(s, d, st, e)
                            }
                            "3" -> { print("Station: "); searchOffers(sc.nextLine()) }
                            "4" -> { print("ID: "); val id = sc.nextLine().toIntOrNull() ?: 0; deleteOffer(id) }
                            "5" -> { logged = false; println("Bye!") }
                        }
                    }
                } else println("Wrong!")
            }
            "3" -> return
        }
    }
}

