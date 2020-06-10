package com.techChallenge.techgig.dao;


import com.techChallenge.techgig.beans.IGenericVo;
import com.techChallenge.techgig.beans.RoomDetail;

import java.util.List;

/**
 * DAO layer interface
 */
public interface IDao {


    /**
     * @param getallavailableroomsQuery
     * @param conditions
     * @return
     * @throws Exception
     */
    List<IGenericVo> getRequiredData(String getallavailableroomsQuery, List<KeyValue> conditions) throws Exception;

    /**
     * @param iGenericVo
     * @return
     * @throws Exception
     */
    boolean save(IGenericVo iGenericVo) throws Exception;

    /**
     * @param bookingDetailWithReferenceID
     * @param conditions
     * @return
     * @throws Exception
     */
    boolean deleteData(String bookingDetailWithReferenceID, List<KeyValue> conditions) throws Exception;
}
