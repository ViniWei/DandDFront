package DandDService.Racas

import DandDService.PersonagemAtributos

class AnaoColina : Raca {
    override val name = "AnaoColina"
    override fun retornarAtributosAdicionais() : PersonagemAtributos {
        return PersonagemAtributos(
            0,
            0,
            0,
            0,
            1,
            0
        )
    }
}
