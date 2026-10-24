package biblioteca

class Biblioteca(val nombre: String) {

    private val materiales = mutableListOf<Material>()

    fun agregar(material: Material) {
        materiales.add(material)
        println("Agregado: ${material.titulo}")
    }

    fun mostrarCatalogo() {
        println("--- Catálogo de $nombre ---")
        for (material in materiales) {
            println(material.descripcion())
        }
    }
}