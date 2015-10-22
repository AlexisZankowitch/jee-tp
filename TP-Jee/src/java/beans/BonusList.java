/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author azank
 */
public class BonusList {
    private ArrayList<Map<String,String>> list;

    public ArrayList<Map<String, String>> getList() {
        return list;
    }

    public BonusList() {
        this.list = new ArrayList<>();
    }

    public void setList(Map<String, String> map) {
        this.list.add(map);
    }
    
    
}
