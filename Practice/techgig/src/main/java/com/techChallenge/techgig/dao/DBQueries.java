package com.techChallenge.techgig.dao;

import jdk.nashorn.internal.ir.LexicalContext;

/**
 * All Generic queries
 */
public interface DBQueries {
    static final String GETALLAVAILABLEROOMS = "From  #className#";
    static final String GETROOMIDANDMEETINGROOMDETAIL = "From #className# where roomName=:roomName and building=:building and floor=:floor";
    static final String DELETEBOOKEDROOMDETAILSWITHREFERNCEID ="delete from #className# where referenceId =:referenceId" ;
    static final String CHECKROOMISALREADYBOOKED = "From #className# where  bookedDateTimeTo <=:bookedDateTimeTo AND bookedDateTimeFrom >=:bookedDateTimeFrom AND roomId =:roomId";
}
