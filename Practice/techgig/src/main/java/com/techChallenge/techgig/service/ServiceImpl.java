package com.techChallenge.techgig.service;

import com.techChallenge.techgig.beans.IGenericVo;
import com.techChallenge.techgig.dao.IDao;
import com.techChallenge.techgig.dao.KeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Services to insert,update,delete and select data
 */
@Component
public class ServiceImpl implements IService {

    @Autowired
    IDao iDao;


    /**
     * @param getallavailableroomsQuery
     * @param conditions
     * @return
     * @throws Exception
     */
    @Override
    public List<IGenericVo> getDataQuery(String getallavailableroomsQuery,List<KeyValue> conditions) throws Exception {
        return iDao.getRequiredData(getallavailableroomsQuery,conditions);

    }

    /**
     * @param iGenericVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean saveData(IGenericVo iGenericVo) throws Exception {
        return iDao.save(iGenericVo);

    }

    /**
     * @param bookingDetailWithReferenceID
     * @param conditions
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteBooking(String bookingDetailWithReferenceID, List<KeyValue> conditions) throws Exception {
        iDao.deleteData(bookingDetailWithReferenceID,conditions);
        return false;
    }
}
