/**
 * Clase que representa una cafetera con capacidad para almacenar café.
 * @param ubicacion Ubicación actual de la cafetera.
 */
class Cafetera(private val ubicacion: String) {

    /** Cantidad actual de café en la cafetera. */
    private var cantidad: Int = 0

    /** Capacidad máxima de la cafetera. */
    private var capacidad: Int = 1000
        set(value) {
            if (value in 0..1000) {
                field = value
            } else {
                throw IllegalArgumentException("La capacidad no puede ser menor que 0 o mayor que 1000")
            }
        }

    /**
     * Constructor secundario que permite especificar la ubicación y capacidad máxima de la cafetera.
     * @param ubicacion La ubicación de la cafetera.
     * @param capacidad La capacidad máxima de la cafetera.
     */
    constructor(ubicacion: String, capacidad: Int) : this(ubicacion) {
        this.capacidad = capacidad
        this.cantidad = this.capacidad
    }

    /**
     * Constructor secundario que permite especificar la ubicación, capacidad máxima y cantidad inicial de la cafetera.
     * @param ubicacion La ubicación de la cafetera.
     * @param capacidad La capacidad máxima de la cafetera.
     * @param cantidad La cantidad inicial de café en la cafetera.
     */
    constructor(ubicacion: String, capacidad: Int, cantidad: Int) : this(ubicacion) {
        this.capacidad = capacidad
        if (cantidad > capacidad) {
            this.cantidad = capacidad
        } else {
            this.cantidad = cantidad
        }
    }

    /** Llena la cafetera hasta su capacidad máxima. */
    fun llenar() {
        this.cantidad = this.capacidad
    }

    /**
     * Llena una taza de café de la cafetera.
     * @param taza Objeto de la clase Taza a llenar con café.
     */
    fun servirTaza(taza: Taza) {
        val tazaTotal = taza.capacidad - taza.cantidad
        if (tazaTotal != 0 && this.cantidad >= tazaTotal) {
            taza.cantidad = taza.capacidad
            this.cantidad -= tazaTotal
        } else if (tazaTotal != 0 && this.cantidad < tazaTotal) {
            taza.cantidad += this.cantidad
            this.cantidad = 0
        }
    }

    /** Vacía la cafetera, dejándola sin café. */
    fun vaciar() {
        this.cantidad = 0
    }

    /**
     * Agrega una cantidad específica de café a la cafetera.
     * @param cantidad La cantidad de café a agregar. Por defecto, se agregan 200 unidades.
     */
    fun agregarCafe(cantidad: Int = 200) {
        this.cantidad += cantidad

        // Ajusta la cantidad si supera la capacidad máxima.
        if (this.cantidad > this.capacidad) {
            this.cantidad = this.capacidad
        }
    }

    /** Representación en cadena de la cafetera. */
    override fun toString(): String {
        return "Cafetera(ubicación = $ubicacion, capacidad = $capacidad c.c., cantidad = $cantidad c.c.)"
    }
}