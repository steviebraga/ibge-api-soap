package ibge.api.model

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * Representation of a Municipality
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Municipality {

    @XmlElement
    val code: Int = 0

    @XmlElement
    val name: String = ""

    @XmlElement
    val gentilic: String = ""

    val state: State = State()

}