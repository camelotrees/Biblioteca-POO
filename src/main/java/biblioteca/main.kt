package biblioteca

fun main() {
    val biblioteca = Biblioteca("Biblioteca Central")

    println("=== Creando materiales ===")
    val libro1 = Libro("Cien años de soledad", 1967, "Gabriel García Márquez", 2)
    val libro2 = Libro("El principito", "Antoine de Saint-Exupéry")
    val digital = LibroDigital("Introducción a Kotlin", 2024, "Ana Pérez", 12.5)
    val revista = Revista("Muy Interesante", 2025, 310)

    println("\n=== Agregando al catálogo ===")
    biblioteca.agregar(libro1)
    biblioteca.agregar(libro2)
    biblioteca.agregar(digital)
    biblioteca.agregar(revista)

    println()
    biblioteca.mostrarCatalogo()

    println("\n=== Préstamos (interfaz Prestable) ===")
    libro2.prestar()
    libro2.prestar()
    digital.prestar()
    libro2.devolver()

    println("\n=== Getter y setter ===")
    println("Antigüedad de ${libro1.titulo}: ${libro1.antiguedad} años")
    libro1.copias = -5
    println("Copias tras asignar -5: ${libro1.copias}")
    println("¿Disponible? ${libro1.disponible}")

    println("\n=== Polimorfismo ===")
    val materiales: List<Material> = listOf(libro1, libro2, digital, revista)
    for (m in materiales) {
        if (m is Prestable) {
            println("${m.titulo} se puede prestar")
        } else {
            println("${m.titulo} es solo de consulta")
        }
    }
}