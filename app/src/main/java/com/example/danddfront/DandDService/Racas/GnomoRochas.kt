package DandDService.Racas

import DandDService.PersonagemAtributos

class GnomoRochas : Raca {
    override val name = "GnomoRochas"
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