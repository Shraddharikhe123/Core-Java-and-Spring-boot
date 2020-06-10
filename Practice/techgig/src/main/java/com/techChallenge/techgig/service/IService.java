package com.techChallenge.techgig.service;

import com.techChallenge.techgig.beans.IGenericVo;
import com.techChallenge.techgig.dao.KeyValue;

import java.util.List;

public interface IService {

    List<IGenericVo> getDataQuery(String getallavailableroomsQuery, List<KeyValue> conditions) throws Exception;

    boolean saveData(IGenericVo bookingDetail) throws Exception;

    boolean deleteBooking(String bookingDetailWithReferenceID, List<KeyValue> conditions) throws Exception;
}
