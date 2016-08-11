/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.arbocdi.wse.wse_ejb;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.sf.arbocdi.wse.data.Message;
import net.sf.arbocdi.wse.data.MessageHandlerLocal;
import net.sf.arbocdi.wse.data.MessageType;
import net.sf.arbocdi.wse.wse_ejb.entity.TokenHistory;

/**
 *
 * @author arbocdi
 */
@Stateless
public class HistoryHandler implements MessageHandlerLocal {
    @EJB(beanName = "AuthHandler")
    private MessageHandlerLocal next;
    @PersistenceContext(unitName = "wse")
    private EntityManager em;
    @Resource
    SessionContext ctx;

    @Override
    public Message processMessage(Message request) throws Exception {
        Message response = this.next.processMessage(request);
        if (MessageType.LOGIN_CUSTOMER == request.type&&response.type == MessageType.CUSTOMER_API_TOKEN) {
            //ctx.getBusinessObject(HistoryHandler.class).saveToken(request, response);
            this.saveToken(request, response);
        }
        return response;
    }
    @Asynchronous
    public void saveToken(Message request,Message response) {
        TokenHistory tokenHistory = new TokenHistory();
        tokenHistory.setU_email(request.data.email);
        tokenHistory.setU_token(response.data.api_token);
        tokenHistory.setU_token_expire(response.data.api_token_expiration_date);
        em.persist(tokenHistory);
    }

}
