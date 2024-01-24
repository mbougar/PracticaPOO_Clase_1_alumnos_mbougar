/**
 * Clase que representa una taza con características como color, capacidad y cantidad de líquido.
 * @param color El color de la taza.
 * @param capacidad La capacidad máxima de la taza.
 * @param cantidad La cantidad inicial de líquido en la taza.
 */
class Taza(val color: String, val capacidad: Int, var cantidad: Int = 0) {

    init {

        if (this.cantidad > this.capacidad) {
            this.cantidad = this.capacidad
        }

        try {

            val enumColor = Color.valueOf(color)
        } catch (e: IllegalArgumentException) {

            println("Color no válido: $color")
        }
    }

    /** Llena la taza hasta su capacidad máxima. */
    fun llenar() {
        this.cantidad = this.capacidad
    }

    /**
     * Llena la taza hasta la cantidad especificada, ajustando si supera la capacidad máxima.
     * @param cantidad La cantidad de líquido a agregar a la taza.
     */
    fun llenar(cantidad: Int) {
        this.cantidad = cantidad

        // Ajusta la cantidad si supera la capacidad máxima.
        if (this.cantidad > this.capacidad) {
            this.cantidad = this.capacidad
        }
    }

    /** Representación en cadena de la taza. */
    override fun toString(): String {
        return "Taza(color = $color, capacidad = $capacidad c.c., cantidad = $cantidad c.c.)"
    }
}