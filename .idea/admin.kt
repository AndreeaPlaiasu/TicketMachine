class LoginSystem {
    private val ADMIN_USERNAME = "admin"
    private val ADMIN_PASSWORD = "admin123"

    fun login(): Boolean {
        println("\n=== Admin Login ===")
        print("Username: ")
        val username = readLine() ?: ""

        print("Password: ")
        val password = readLine() ?: ""

        return if (username == ADMIN_USERNAME && password == ADMIN_PASSWORD) {
            println("Login successful!\n")
            true
        } else {
            println("Invalid credentials. Access denied.")
            false
        }
    }
}