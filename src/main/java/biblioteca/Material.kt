package biblioteca

import java.time.Year

// Interfaz: acciones que puede hacer un material que se presta
interface Prestable {
    fun prestar()
    fun devolver()
}

// Clase abstracta: plantilla para todos los materiales
abstract class Material(val titulo: String, val anio: Int) {
    abstract val tipo: String

    // Getter: se calcula cada vez que se consulta
    val antiguedad: Int
        get() = Year.now().value - anio

    init {
        println("Registrando material: $titulo")
    }

    open fun descripcion(): String = "[$tipo] $titulo ($anio)"
}

// Las revistas son solo de consulta (no implementan Prestable)
class Revista(titulo: String, anio: Int, val numero: Int) : Material(titulo, anio) {
    override val tipo: String = "Revista"

    override fun descripcion(): String = super.descripcion() + " - N.º $numero"
}