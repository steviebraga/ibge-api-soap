package ibge.api.dao

import ibge.api.model.State

class StateDAO : BaseDAO() {

    private val columns = listOf<String>("code", "name", "acronym", "capital", "municipalities_number")

    val columnMappings = mapOf("municipalities_number" to "municipalitiesNumber")

    private val findAllSql = "SELECT ${columns.joinToString(", ")} FROM states"

    private val findByRegionSql = "$findAllSql WHERE CAST(code AS CHAR) LIKE :regionCode"

    private val stateCodeExistSql = "SELECT COUNT(*) FROM states WHERE code = :code"

    fun findAll(): List<State> {
        return sql2o
                .open()
                .createQuery(findAllSql)
                .setColumnMappings(columnMappings)
                .executeAndFetch(State::class.java)
    }

    fun findByRegion(regionCode: Int): List<State> {
        return sql2o
                .open()
                .createQuery(findByRegionSql)
                .addParameter("regionCode", "$regionCode%")
                .setColumnMappings(columnMappings)
                .executeAndFetch(State::class.java)
    }

    fun stateExists(stateCode: Int): Boolean {
        return sql2o
                .open()
                .createQuery(stateCodeExistSql)
                .addParameter("code", stateCode)
                .executeScalar(Int::class.java) > 0
    }

}