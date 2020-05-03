import java.io.Serializable;
import java.util.ArrayList;


public class FileObject implements Serializable
{
    String name;
    long size;
    String creationTS;
    String readTS;
    String writeTS;
    int referenceCount;
    int numberOfPages;
    ArrayList<Page> pages;
    
    public FileObject(String name) {
    	this.name = name;
        size = 0;
        creationTS = java.time.LocalDateTime.now().toString();
        readTS = "";
        writeTS = "";
        referenceCount = 0;
        numberOfPages = 0;
        pages = new ArrayList<Page>();
    }
    
    public String getName(){
    	return name;
    }
    
    public Long getSize(){
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
    
    public int getNumberOfPages(){
        return numberOfPages;
    }
    
    public ArrayList<Page> getPages(){
        return pages;
    }

    
    public void setName(String name) { 
    	this.name = name; 
    }

    public void setSize(Long size){
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
    
    public void setNumberOfPages(int numberOfPages){
            this.numberOfPages = numberOfPages;
    }

};