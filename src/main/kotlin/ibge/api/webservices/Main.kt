package ibge.api.webservices

import ibge.api.dao.BaseDAO
import org.flywaydb.core.Flyway
import javax.xml.ws.Endpoint
import javax.xml.ws.WebServiceFeature

fun main(args: Array<String>) {

    val flyway = Flyway()
    flyway.setDataSource(BaseDAO.url, BaseDAO.user, BaseDAO.password)
    flyway.migrate()

    val ibgeWS = IBGEWS()

    val url = "http://localhost:8090/ibgews"

    println("Running ... ")

    Endpoint.publish(url, ibgeWS)

}
