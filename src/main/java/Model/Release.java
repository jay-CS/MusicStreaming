package Model;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samantharain
 */
public class Release implements Serializable{
	
        private int id;
	private String name;
	
	public Release(int id, String name) {
            this.id = id;
            this.name = name;
	}
	
	public void setID(int ID) {
            this.id = ID;
	}
	
	public void setName(String name) {
            this.name = name;
	}
	
	public int getID() {
            return id;
	}
	
	public String getName() {
            return getName();
	}
}
