/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPCClient;

import java.util.ArrayList;

/**
 *
 * @author samantharain
 */
public class Catalog {
    
        private String remoteMethod;
        private String objectName;
        private ArrayList<param> params;
        private String call_semantic;
        private String returnType;
        
        public Catalog(String remoteMethod, String objectName, ArrayList<param> params, String call_semantic, String returnType ) {
                this.remoteMethod = remoteMethod;
                this.objectName = objectName;
                this.params = params;
                this.call_semantic = call_semantic;
                this.returnType = returnType;      
        }
        
        public String getremoteMethod() {
            return remoteMethod;
        }
        
        public String getobjectName() {
            return objectName;
        }
        
        public ArrayList<param> getParams() {
            return params;
        }
        
        public String getcall_Semantic() {
            return call_semantic;
        }
        
        public String getreturnType() {
            return returnType;
        }
        
        public void setremoteMethod(String remoteMethod) {
            this.remoteMethod = remoteMethod;
        }
        
        public void setobjectName(String objectName) {
            this.objectName = objectName;
        }
        
        public void setParams(ArrayList<param> params) {
            this.params = params;
        }
        
        public void setcall_Semantic(String call_semantic) {
            this.call_semantic = call_semantic;
        }
        
        public void setreturnType(String returnType) {
            this.returnType = returnType;
        }
        
        
}
