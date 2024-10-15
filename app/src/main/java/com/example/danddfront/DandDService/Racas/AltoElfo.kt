package DandDService.Racas

import DandDService.PersonagemAtributos

class AltoElfo : Raca {
    override val name = "AltoElfo"
    override fun retornarAtributosAdicionais() : PersonagemAtributos {
        return PersonagemAtributos(
            0,
            0,
            0,
            1,
            0,
            0
        )
    }
}