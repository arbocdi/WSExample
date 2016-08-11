/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.arbocdi.wse.wse_ejb;

import javax.ejb.Stateless;
import net.sf.arbocdi.wse.data.Message;
import net.sf.arbocdi.wse.data.MessageHandler;
import net.sf.arbocdi.wse.data.MessageHandlerLocal;
import net.sf.arbocdi.wse.data.MessageType;

/**
 *
 * @author arbocdi
 */
@Stateless
public class PingHandler implements MessageHandlerLocal {

    @Override
    public Message processMessage(Message request) throws Exception {
        Message response = new Message();
        response.type = MessageType.PING;
        return response;
    }

}
