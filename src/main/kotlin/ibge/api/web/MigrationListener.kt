package ibge.api.web

import ibge.api.dao.BaseDAO
import org.flywaydb.core.Flyway
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener

/**
 * Listener used to migrate the database on deployment to an application server
 */
class MigrationListener : ServletContextListener {

    override fun contextInitialized(servletContextEvent: ServletContextEvent) {
        val flyway = Flyway()
        flyway.setDataSource(BaseDAO.url, BaseDAO.user, BaseDAO.password)
        flyway.migrate()
    }

    override fun contextDestroyed(servletContextEvent: ServletContextEvent) {

    }

}