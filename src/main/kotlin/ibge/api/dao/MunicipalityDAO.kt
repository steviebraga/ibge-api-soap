package ibge.api.dao

import ibge.api.model.Municipality

class MunicipalityDAO : BaseDAO() {

    private val columns = listOf<String>("code", "name", "gentilic", "state")

    private val findAllSql = "SELECT ${columns.joinToString(", ")} FROM municipalities"

    private val findByStateSql = "$findAllSql WHERE state = :stateCode"

    private val findByNameSql = "$findAllSql WHERE UPPER(name) LIKE :name"

    fun findAll(): List<Municipality> {
        return sql2o
                .open()
                .createQuery(findAllSql)
                .executeAndFetch(Municipality::class.java)
    }

    fun findByState(stateCode: Int): List<Municipality> {
        return sql2o
                .open()
                .createQuery(findByStateSql)
                .addParameter("stateCode", stateCode)
                .executeAndFetch(Municipality::class.java)
    }

    fun findByName(municipalityName: String): List<Municipality> {
        return sql2o
                .open()
                .createQuery(findByNameSql)
                .addParameter("name", "%${municipalityName.toUpperCase()}%")
                .executeAndFetch(Municipality::class.java)
    }

}