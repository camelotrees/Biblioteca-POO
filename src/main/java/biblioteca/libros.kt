package biblioteca

// Clase open: se puede heredar
open class Libro(
    titulo: String,
    anio: Int,
    val autor: String,
    copiasIniciales: Int = 1
) : Material(titulo, anio), Prestable {

    override val tipo: String = "Libro"

    // Setter: evita que las copias sean negativas
    var copias: Int = copiasIniciales
        set(valor) {
            field = if (valor < 0) 0 else valor
        }

    val disponible: Boolean
        get() = copias > 0

    init {
        println("Libro creado: $titulo con $copiasIniciales copia(s)")
    }

    // Constructor secundario: usa el año 2024 y 1 copia
    constructor(titulo: String, autor: String) : this(titulo, 2024, autor, 1)

    override fun descripcion(): String = super.descripcion() + " - autor: $autor"

    override fun prestar() {
        if (disponible) {
            copias -= 1
            println("Prestado: $titulo (quedan $copias)")
        } else {
            println("No hay copias disponibles de $titulo")
        }
    }

    override fun devolver() {
        copias += 1
        println("Devuelto: $titulo (copias: $copias)")
    }
}

// Subclase: un libro digital siempre está disponible
class LibroDigital(
    titulo: String,
    anio: Int,
    autor: String,
    val tamanoMb: Double
) : Libro(titulo, anio, autor, 1) {

    override val tipo: String = "Libro digital"

    override fun descripcion(): String = super.descripcion() + " - $tamanoMb MB"

    override fun prestar() {
        println("Descargando $titulo ($tamanoMb MB)... siempre disponible")
    }

    override fun devolver() {
        println("$titulo se elimina del dispositivo")
    }
}