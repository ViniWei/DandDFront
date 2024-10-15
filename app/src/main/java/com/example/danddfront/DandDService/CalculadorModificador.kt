package DandDService

import kotlin.math.ceil

class CalculadorModificador {
    fun calcularModificador(atributo : Int) : Int {
        var modificador = (atributo.toDouble() - 1) / 2 - 5
        modificador = ceil(modificador)

        return modificador.toInt();
    }

}
