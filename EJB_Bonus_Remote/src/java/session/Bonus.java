/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;

/**
 *
 * @author azank
 */
@Stateless(mappedName = "Bonus")
public class Bonus implements BonusRemote {

    @Override
    public String doMultiplication(String ssn, String multiplication) {
        try {
            return String.valueOf(Integer.parseInt(multiplication) * Integer.parseInt(ssn));
         } catch (Exception e) {
            return "vide";
         }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
