package com.dongnao.jack.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consult_contract")
public class ConsultContract implements Serializable {
    
    private static final long serialVersionUID = 8127035730921338189L;
    
    @Id
    /**主键的产生策略
     * 在java.persistence.GenerationType中定义了几种可以供选择的策略：
    1．  Identity：表自动增长字段，Oracle不支持这种方式；
    2．  AUTO：JPA自动选择合适的策略，是默认选项；
    3．  Sequence：通过序列产生主键，通过@SequenceGenerator注解指定序列名，Mysql不支持这种方式。
    4．  TABLE：通过表产生主键，框架借由表模拟产生主键，使用该策略可以使用更易于数据库的移植。
     */
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contractId;
    
    @Column(nullable = false, name = "PSPTID")
    private String psptId;
    
    @Column(nullable = false, name = "CONTRACT_CODE")
    private String contractCode;
    
    @Column(nullable = true, name = "ACTIVETIME")
    private String activeTime;
    
    @Column(nullable = true, name = "STATE")
    private Integer state;
    
    public Integer getContractId() {
        return contractId;
    }
    
    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }
    
    public String getPsptId() {
        return psptId;
    }
    
    public void setPsptId(String psptId) {
        this.psptId = psptId;
    }
    
    public String getContractCode() {
        return contractCode;
    }
    
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }
    
    public String getActiveTime() {
        return activeTime;
    }
    
    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }
    
    public Integer getState() {
        return state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }
}
