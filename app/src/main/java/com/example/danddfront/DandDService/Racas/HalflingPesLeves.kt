package DandDService.Racas

import DandDService.PersonagemAtributos

class HalflingPesLeves : Raca {
    override val name = "HalflingPesLeves"
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