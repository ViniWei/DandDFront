package DandDService.Racas

import DandDService.PersonagemAtributos

class HalflingRobusto : Raca {
    override val name = "HalflingRobusto"
    override fun retornarAtributosAdicionais() : PersonagemAtributos {
        return PersonagemAtributos(
            0,
            0,
            1,
            0,
            0,
            0
        )
    }
}