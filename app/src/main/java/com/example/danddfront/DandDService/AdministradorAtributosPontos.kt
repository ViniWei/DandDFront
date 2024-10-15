package DandDService

class AdministradorAtributosPontos {
    var pontos = 27;

    fun VerificarAdicaoAtributoEDiminuirPontos(atributo : Int) : Boolean {
        if (atributo >= 15) {
            return false
        }

        if (atributo > 7 && atributo < 13) {
            if (this.pontos - 1 < 0) { return false }

            this.pontos -= 1
            return true
        }

        if (atributo >= 13) {
            if (this.pontos - 2 < 0) { return false }

            this.pontos -= 2
            return true
        }

        return false
    }

    fun VerificarSubtracaoAtributoEaumentarPontos(atributo : Int) : Boolean {
        if (atributo <= 8) {
            return false
        }

        if (atributo <= 13) {
            this.pontos += 1
            return true
        }

        if (atributo <= 15) {
            this.pontos += 2
            return true
        }

        return false
    }
}
