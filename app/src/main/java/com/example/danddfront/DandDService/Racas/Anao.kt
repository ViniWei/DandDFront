package DandDService.Racas

import DandDService.PersonagemAtributos

class Anao : Raca {
    override val name = "Anao"
    override fun retornarAtributosAdicionais() : PersonagemAtributos {
        return PersonagemAtributos(
            0,
            0,
            2,
            0,
            0,
            0
        )
    }
}