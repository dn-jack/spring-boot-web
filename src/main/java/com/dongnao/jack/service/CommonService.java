package com.dongnao.jack.service;

import java.util.List;
import java.util.Map;

import com.dongnao.jack.bean.ConsultConfigArea;
import com.dongnao.jack.bean.ConsultContent;
import com.dongnao.jack.bean.User;

public interface CommonService {
    
    List<ConsultContent> queryContent(Map map);
    
    //    int updateConsultContract(String psptId, int id);
    //    
    //    List<ConsultContract> queryConsultContract();
    
    public List<ConsultConfigArea> qryArea(Map param);
    
    int saveArea(ConsultConfigArea area);
    
    int saveAreaToBase(ConsultConfigArea area);
    
    public List<ConsultConfigArea> qryAreaFromBase(Map param);
    
    public User findUserByName(String username);
}
