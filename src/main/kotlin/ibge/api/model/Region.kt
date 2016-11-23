package ibge.api.model

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * Represents a Country Region. There is no record of this in IBGE, it's just a deduction.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Region {

    @XmlElement
    val code: Int = 0

    @XmlElement
    val name: String = ""

    @XmlElement
    val acronym: String = ""

}