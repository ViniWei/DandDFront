package DandDService.Racas

import DandDService.PersonagemAtributos

class Elfo : Raca {
    override val name = "Elfo"
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