package DandDService.Racas;

import DandDService.PersonagemAtributos

public class AnaoMontanha : Raca {
    override val name = "AnaoMontanha"
    override fun retornarAtributosAdicionais() : PersonagemAtributos {
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
