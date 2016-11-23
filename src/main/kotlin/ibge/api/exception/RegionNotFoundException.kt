package ibge.api.exception

import javax.xml.ws.WebFault

@WebFault(name = "regionException", messageName = "RegionNotFoundException")
class RegionNotFoundException(override val message: String = "Invalid Region. Available regions are: N, NE, SE, S, CO") : Exception()