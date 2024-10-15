package DandDService.Racas

import DandDService.PersonagemAtributos

class MeioOrc : Raca {
    override val name = "MeioOrc"
    override fun retornarAtributosAdicionais(): PersonagemAtributos {
       return PersonagemAtributos(
           2,
           0,
           0,
           0,
           0,
           0
       )
    }
}