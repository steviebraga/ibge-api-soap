package ibge.api.dao

import ibge.api.model.Region

class RegionDAO : BaseDAO() {

    private val columns = listOf<String>("code", "name", "acronym")

    private val findAllSql = "SELECT ${columns.joinToString(", ")} FROM regions"

    fun findAll(): List<Region> {
        return sql2o
                .open()
                .createQuery(findAllSql)
                .executeAndFetch(Region::class.java)
    }

}