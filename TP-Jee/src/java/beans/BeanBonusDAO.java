/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;

/**
 *
 * @author azank
 */
@Stateless
public class BeanBonusDAO{
    
    private String ssn;
    private String multiplier;
    private String bonus;

     public BeanBonusDAO(){
        
    }
    
    public BeanBonusDAO(String ssn, String multiplier) {
        this.ssn = ssn;
        this.multiplier = multiplier;
    }
    
    

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplicator) {
        this.multiplier = multiplicator;
    }

    public String getBonus() {
        return bonus;
    }
    
    public void setBonus(String bonus){
        this.bonus = bonus;
    }
}
