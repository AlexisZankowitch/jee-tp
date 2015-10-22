/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Remote;

/**
 *
 * @author azank
 */
@Remote
public interface BonusRemote {
    public String doMultiplication(String ssn, String multiplication);
}
