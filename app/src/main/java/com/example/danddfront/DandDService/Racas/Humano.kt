package DandDService.Racas

import DandDService.PersonagemAtributos

class Humano : Raca {
    override val name = "Humano"
    override fun retornarAtributosAdicionais() : PersonagemAtributos {
        return PersonagemAtributos(
            1,
            1,
            1,
            1,
            1,
            1
        )
    }
}