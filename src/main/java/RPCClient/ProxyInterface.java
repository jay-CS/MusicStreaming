/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPCClient;

import com.google.gson.JsonObject;

/**
 *
 * @author samantharain
 */
public interface ProxyInterface {

    
    public JsonObject synchExecution(String remoteMethod, String[] param) throws Exception;
    
}
