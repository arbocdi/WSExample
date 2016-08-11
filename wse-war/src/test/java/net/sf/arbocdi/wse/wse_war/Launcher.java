/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.arbocdi.wse.wse_war;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.sf.arbocdi.wse.data.Message;
import net.sf.arbocdi.wse.data.MessageType;
import org.junit.Test;

/**
 *
 * @author arbocdi
 */
public class Launcher {

    @Test
    public void generateTestGson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Message msg = new Message();
        msg.sequence_id = "123";
        msg.type = MessageType.LOGIN_CUSTOMER;
        msg.data.email = "fpi@bk.ru";
        msg.data.password = "123123";
        System.out.println(gson.toJson(msg));
    }
}
