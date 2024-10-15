package DandDService.Racas

import DandDService.PersonagemAtributos

interface Raca {
    val name: String;
    fun retornarAtributosAdicionais(): PersonagemAtributos
}