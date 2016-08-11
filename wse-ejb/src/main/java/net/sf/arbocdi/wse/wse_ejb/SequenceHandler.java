/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.arbocdi.wse.wse_ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import net.sf.arbocdi.wse.data.Message;
import net.sf.arbocdi.wse.data.MessageHandlerLocal;

/**
 *
 * @author arbocdi
 */
@Stateless
public class SequenceHandler implements MessageHandlerLocal {

    @EJB(beanName = "RouteHandler")
    private MessageHandlerLocal next;

    @Override
    public Message processMessage(Message request) throws Exception {
        Message response = next.processMessage(request);
        response.sequence_id = request.sequence_id;
        return response;
    }

}
