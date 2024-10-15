package DandDService.Racas

import DandDService.PersonagemAtributos

class Drow : Raca {
    override val name = "Drow"
    override fun retornarAtributosAdicionais() : PersonagemAtributos {
        return PersonagemAtributos(
            0,
            0,
            0,
            0,
            0,
            1
        )
    }
}
