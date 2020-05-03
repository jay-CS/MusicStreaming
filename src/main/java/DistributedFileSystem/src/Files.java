import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Files implements Serializable {

	List<FileObject> listOfFiles;
	
	public Files() {
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

    public ArrayList<Integer> getGUIDs(String fileName){
            ArrayList<Integer> list = new ArrayList();
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

    