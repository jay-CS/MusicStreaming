/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Filess implements Serializable {

	List<FileObject> listOfFiles;
	
	public Filess() {
		listOfFiles = new ArrayList<FileObject>();
    }

        
        
    public List<FileObject> getFile() {
        return this.listOfFiles;
    }
    
    
    public void setFile(List<FileObject> listOfFiles){
        this.listOfFiles = listOfFiles;
    }
    
    public void addFile(FileObject file) {
    	listOfFiles.add(file);
    }

    public ArrayList<Long> getGUIDs(String fileName){
            ArrayList<Long> list = new ArrayList();
            for (FileObject file : listOfFiles){
                if(file.name.equals(fileName)){
                    for(Page p : file.pages){
                    	list.addAll(p.getGuids());

                    }
                }
            }
            return list;
    }


    public void deleteFile(String fileName){
        for (FileObject file : this.listOfFiles){
            if(file.name.equals(fileName)){
                this.listOfFiles.remove(file);
                System.out.println("File Deleted");
                break;
                }
            }
        }


};

    