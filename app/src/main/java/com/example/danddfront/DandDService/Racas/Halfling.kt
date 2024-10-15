package DandDService.Racas

import DandDService.PersonagemAtributos

class Halfling : Raca {
    override val name = "Halfling"
    override fun retornarAtributosAdicionais() : PersonagemAtributos {
        return PersonagemAtributos(
            0,
            2,
            0,
            0,
            0,
            0
        )
    }
}