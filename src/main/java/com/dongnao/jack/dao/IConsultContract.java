package com.dongnao.jack.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dongnao.jack.bean.ConsultContract;

public interface IConsultContract extends
        JpaRepository<ConsultContract, Integer> {
    //    @Transactional
    //    @Modifying
    //    @Query("update consult_contract a set a.psptId = :psptId where a.Contract_ID = :id")
    //    int updateConsultContract(@Param("psptId") String psptId,
    //            @Param("id") int id);
    //    
    //    @Query("select　* from consult_contract")
    //    List<ConsultContract> queryConsultContract();
}
