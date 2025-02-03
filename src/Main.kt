fun main() {
    val personas = listOf(
        Persona("Ana", 1.68, 65.0),  // Altura debajo, peso debajo
        Persona("Luis", 1.80, 80.0),  // Ambos encima
        Persona("", null, null)  // Caso extremo para probar nulos
    )

    // Recorrer y mostrar (falta manejo de nulls)
    personas.forEach { p ->
        println(p.saludar())
        println(p.obtenerDesc())
        // println(p.obtenerDescImc())  // No debería ser accesible (debería ser private)
    }

    // Corrección posterior: Inicializar altura_ y peso_ a 0 si son null
    // y añadir check en calcularImc()
}