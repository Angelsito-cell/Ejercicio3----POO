class Persona(val nombre: String, private var altura_: Double?, private var peso_: Double?) {
    // TODO: Cambiar a enum class después
    enum class TipoImc { INSUFICIENTE, SALUDABLE, SOBREPESO, OBESIDAD }

    // Método saludar() simple
    fun saludar() = "Hola, soy $nombre!"  // Usé string template

    // Chequear altura media con valor hardcodeado
    fun alturaEncimaMedia(): Boolean {
        // Media 1.75, pero no está parametrizado
        return altura_?.compareTo(1.75) ?: 0 >= 0  // Algo raro con nulls
    }

    // Chequear peso medio
    fun pesoEncimaMedia() = peso_?.let { it >= 70.0 } ?: false

    // Calcular IMC (copia del ejercicio anterior con error)
    private fun calcularImc(): Double {
        val altura = altura_ ?: 0.0
        // OJO división por cero si altura es 0 (no manejado)
        return (peso_ ?: 0.0) / (altura * altura)
    }

    // Obtener descripción IMC (versión inicial con rangos)
    private fun obtenerDescImc(): String {
        val imcVal = calcularImc()
        // Primera versión usaba if-else anidados
        return when {
            imcVal < 18.5 -> "peso insuficiente"
            imcVal <= 24.9 -> "peso saludable"  // Ah! Aquí estaba el error de < en vez de <=
            imcVal <= 29.9 -> "sobrepeso"
            else -> "obesidad"
        }
    }

    // Descripción completa (formato pedido)
    fun obtenerDesc(): String {
        val alturaTxt = if (alturaEncimaMedia()) "(Por encima de la media)" else "(Por debajo de la media)"
        val pesoTxt = if (pesoEncimaMedia()) "(Por encima)" else "(Por debajo)"  // Nombre poco descriptivo

        // Formatear IMC con 2 decimales
        return "$nombre con altura ${altura_ ?: 0.0}m $alturaTxt y peso ${peso_}kg $pesoTxt tiene IMC de %.2f (${obtenerDescImc()})".format(calcularImc())
    }
}