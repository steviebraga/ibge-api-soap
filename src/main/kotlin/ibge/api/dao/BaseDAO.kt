package ibge.api.dao

import org.sql2o.Sql2o

abstract class BaseDAO {

    companion object {
        val url = "jdbc:mysql://localhost:3306/ibge"
        val user = "root"
        val password = "mysql"
        val sql2o = Sql2o(url, user, password)
    }

}