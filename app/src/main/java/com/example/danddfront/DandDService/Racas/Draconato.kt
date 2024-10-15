package DandDService.Racas

import DandDService.PersonagemAtributos

class Draconato : Raca {
    override val name = "Draconato"
    override fun retornarAtributosAdicionais() : PersonagemAtributos {
        return PersonagemAtributos(
            2,
            0,
            0,
            0,
            0,
            1
        )
    }

}
