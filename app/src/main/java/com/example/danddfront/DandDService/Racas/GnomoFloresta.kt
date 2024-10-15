package DandDService.Racas

import DandDService.PersonagemAtributos

class GnomoFloresta : Raca {
    override val name = "GnomoFloresta"
    override fun retornarAtributosAdicionais() : PersonagemAtributos {
        return PersonagemAtributos(
            0,
            1,
            0,
            0,
            0,
            0
        )
    }
}