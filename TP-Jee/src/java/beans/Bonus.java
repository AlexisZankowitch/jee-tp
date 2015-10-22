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
public class Bonus{
    
    private int ssn;
    private int multiplier;
    private String bonus;

     public Bonus(){
        
    }
    
    public Bonus(int ssn, int multiplier) {
        this.ssn = ssn;
        this.multiplier = multiplier;
    }
    
    

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplicator) {
        this.multiplier = multiplicator;
    }

    public String getBonus() {
        return bonus;
    }
    
    public void setBonus(String bonus){
        this.bonus = bonus;
    }
}
