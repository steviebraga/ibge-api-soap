package ibge.api.webservices

import ibge.api.dao.MunicipalityDAO
import ibge.api.dao.RegionDAO
import ibge.api.dao.StateDAO
import ibge.api.exception.RegionNotFoundException
import ibge.api.exception.StateNotFoundException
import ibge.api.model.Municipality
import ibge.api.model.Region
import ibge.api.model.State
import javax.jws.WebMethod
import javax.jws.WebParam
import javax.jws.WebResult
import javax.jws.WebService
import javax.xml.ws.RequestWrapper
import javax.xml.ws.ResponseWrapper

/**
 * Class used to generate the WSDL
 */
@WebService(serviceName = "IBGEService")
class IBGEWS {

    val regionDAO = RegionDAO()
    val stateDAO = StateDAO()
    val municipalityDAO = MunicipalityDAO()

    /**
     * Search for all country regions
     *
     * @return A list with all regions
     */
    @WebMethod
    @ResponseWrapper(localName = "regionsList")
    @WebResult(name = "region")
    open fun getRegions(): List<Region> {
        return regionDAO.findAll()
    }

    /**
     * Search for all states
     *
     * @return A list with all states
     */
    @WebMethod
    @ResponseWrapper(localName = "statesList")
    @WebResult(name = "state")
    open fun getStates(): List<State> {
        return stateDAO.findAll()
    }

    /**
     * Search for the states of a given region
     *
     * @param region The code of the desired states' region
     * @return A list with all the states of the given region
     * @throws {@RegionNotFoundException} when an unknown region code is given
     */
    @WebMethod
    @RequestWrapper(localName = "regionParam")
    @ResponseWrapper(localName = "statesByRegionList")
    @WebResult(name = "state")
    @Throws(RegionNotFoundException::class)
    open fun getStatesByRegion(@WebParam(name = "region") region: Int): List<State> {
        return stateDAO.findByRegion(region)
    }

    /**
     * Search for all municipalities
     *
     * @return A list with all municipalities
     */
    @WebMethod
    @ResponseWrapper(localName = "municipalities")
    @WebResult(name = "municipality")
    open fun getMunicipalities(): List<Municipality> {
        return municipalityDAO.findAll()
    }

    /**
     * Search for the municipalities of a given state
     *
     * @param stateCode The code of the desired municipalities' state
     * @return A list with all the municipalities of the given state
     * @throws {@StateNotFoundException} when an unknown state code is given
     */
    @WebMethod
    @RequestWrapper(localName = "stateParam")
    @ResponseWrapper(localName = "municipalitiesByState")
    @WebResult(name = "municipality")
    @Throws(StateNotFoundException::class)
    open fun getMunicipalitiesByState(@WebParam(name = "state") stateCode: Int): List<Municipality> {
        if (stateDAO.stateExists(stateCode))
            return municipalityDAO.findByState(stateCode)
        else
            throw StateNotFoundException("State not found.")
    }

    @WebMethod
    @RequestWrapper(localName = "nameParam")
    @ResponseWrapper(localName = "municipalitiesByName")
    @WebResult(name = "municipality")
    open fun getMunicipalitiesByName(@WebParam(name = "municipalityName") municipalityName: String): List<Municipality> {
        return municipalityDAO.findByName(municipalityName)
    }

}