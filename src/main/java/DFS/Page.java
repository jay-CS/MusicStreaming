/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Page implements Serializable
{
    ArrayList<Long> guids;
    int size;
    String creationTS;
    String readTS;
    String writeTS;
    int referenceCount;
    
    public Page()
    {
        creationTS = String.valueOf(new Date().getTime());
        writeTS = String.valueOf(new Date().getTime());
        referenceCount = 0;
    }
    
    public ArrayList<Long> getGuids(){
        return this.guids;
    }
    
    public long getSize(){
        return size;
    }
    
    public String getCreationTS(){
        return creationTS;
    }
    
    public String getReadTS(){
        return readTS;
    }
    
    public String getWriteTS(){
        return writeTS;
    }
    
    public int getReferenceCount(){
        return referenceCount;
    }
    
    public void setGuids(ArrayList<Long> guids){
        this.guids = guids;
    }
    
    public void setSize(int size){
        this.size = size;
    }
    
    public void setCreationTS(String creationTS){
        this.creationTS = creationTS;
    }
    
    public void setReadTS(String readTS){
        this.readTS = readTS;
    }
    
    public void setWriteTS(String writeTS){
        this.writeTS = writeTS;
    }
    
    public void setReferenceCount(int referenceCount){
            this.referenceCount = referenceCount;
    }

   

};