package DandDService

open class PersonagemAtributos(
    var forca: Int,
    var destreza: Int,
    var constituicao: Int,
    var inteligencia: Int,
    var sabedoria: Int,
    var carisma: Int
    ) {

    fun adicionarAtributos(personagemAtributos: PersonagemAtributos) {
        this.forca += personagemAtributos.forca
        this.destreza += personagemAtributos.destreza
        this.constituicao += personagemAtributos.constituicao
        this.inteligencia += personagemAtributos.inteligencia
        this.sabedoria += personagemAtributos.sabedoria
        this.carisma += personagemAtributos.carisma
    }
}
