package ibge.api.model

import java.math.BigDecimal
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * Representation of a State
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class State {

    @XmlElement
    val code: Int = 0

    @XmlElement
    val name: String = ""

    @XmlElement
    val acronym: String = ""

    @XmlElement
    val capital: String = ""

    @XmlElement
    val municipalitiesNumber = 0

}