package ibge.api.exception

import javax.xml.ws.WebFault

@WebFault(name = "StateNotFoundException", messageName = "StateNotFoundException")
class StateNotFoundException(override val message: String) : Exception()