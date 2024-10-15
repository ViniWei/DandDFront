package DandDService.Racas

import DandDService.PersonagemAtributos

class MeioElfo : Raca {
    override val name = "MeioElfo"
    override fun retornarAtributosAdicionais() : PersonagemAtributos {
        return PersonagemAtributos(
            0,
            0,
            0,
            0,
            0,
            2
        )
    }
}