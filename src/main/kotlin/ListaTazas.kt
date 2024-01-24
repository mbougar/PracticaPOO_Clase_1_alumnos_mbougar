/**
 * Clase que representa una lista de tazas.
 */
class ListaTazas {
    /** Lista mutable que almacena las tazas. */
    val tazas = mutableListOf<Taza>()

    /**
     * Agrega una taza a la lista.
     * @param taza La taza a ser agregada a la lista.
     */
    fun agregarTaza(taza: Taza) {
        tazas.add(taza)
    }

    /**
     * Elimina una taza de la lista en la posición especificada.
     * @param pos La posición de la taza a ser eliminada.
     */
    fun eliminarTaza(pos: Int) {
        if (pos in 0 until tazas.size) {
            tazas.removeAt(pos)
            println("Taza número $pos eliminada")
        } else {
            println("No existe ninguna taza con ese número")
        }
    }
}