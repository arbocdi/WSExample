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
public class RouteHandler implements MessageHandlerLocal {

    @EJB(beanName = "HistoryHandler")
    private MessageHandlerLocal authPath;
    @EJB(beanName = "CheckAuthHandler")
    private MessageHandlerLocal actionPath;

    @Override
    public Message processMessage(Message request) throws Exception {
        switch (request.type) {
            case LOGIN_CUSTOMER:
                return this.authPath.processMessage(request);
            default:
                return this.actionPath.processMessage(request);
        }
    }

}
