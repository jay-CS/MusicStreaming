/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPCClient;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author samantharain
 */
public class Proxy {
    
    private CommunicationModuleClient communicationModule;   // This is only for test. it should use the Communication  Module

    private static Proxy proxy = null;

    
    public void init(CommunicationModuleClient communicationModule) {
        this.communicationModule = communicationModule;
    }
    
    
    public JsonObject synchExecution(String remoteMethod, String[] param) throws IOException {
        JsonObject jsonRequest = packRequest(remoteMethod, param);

        JsonParser parser = new JsonParser();
        //String strRet =  this.communicationModule.syncSend(jsonRequest.toString());
        //return parser.parse(strRet).getAsJsonObject();
        return null;
    }


    private JsonObject packRequest(String remoteMethod, String[] param) {
        
        JsonObject jsonRequest = new JsonObject();
        JsonObject jsonParam = new JsonObject();

        Catalog remoteMethodObj = getCatalogMethod(remoteMethod);

        jsonRequest.addProperty("remoteMethod", remoteMethodObj.getremoteMethod());
        jsonRequest.addProperty("objectName", remoteMethodObj.getobjectName());

        ArrayList<param> paramList = remoteMethodObj.getParams();

        for(int i = 0; i < paramList.size(); i++){
            param p = paramList.get(i);

            if(p.getType().equals("String")){
                jsonParam.addProperty(p.getName(), param[i]);
            }
            else if(p.getType().equals("int")){
                jsonParam.addProperty(p.getName(), Integer.parseInt(param[i]));
            } 
            else if(p.getType().equals("Long")) {
                jsonParam.addProperty(p.getName(), Long.parseLong(param[i]));
            }
        }

        jsonRequest.add("param", jsonParam);
        jsonRequest.addProperty("call_semantics", remoteMethodObj.getcall_Semantic());

        return jsonRequest;
    }

    
    public static Catalog getCatalogMethod(String remoteMethod){
        ArrayList<Catalog> catalogList = readCatalogMethods();
        for(Catalog c : catalogList){
            if(c.getremoteMethod().equals(remoteMethod)){
                return c;
            }
        }
        return null;
    }


    public static ArrayList<Catalog> readCatalogMethods(){
        Gson gson = new Gson();
        String fileName = "catalog.json";
        try{
            Type catalogType = new TypeToken<ArrayList<Catalog>>(){}.getType();
            ArrayList<Catalog> catalog = gson.fromJson(new FileReader(fileName), catalogType);
            return catalog;
        }
        catch(FileNotFoundException e){
            System.out.println("Catalog file not found.");
        }
        return null;
    }
    
    
}
