/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.arbocdi.wse.wse_ejb;

import java.sql.Timestamp;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import net.sf.arbocdi.wse.data.ErrorMessage;
import net.sf.arbocdi.wse.data.Message;
import net.sf.arbocdi.wse.data.MessageHandlerLocal;
import net.sf.arbocdi.wse.data.MessageType;
import net.sf.arbocdi.wse.wse_ejb.entity.User;

/**
 *
 * @author arbocdi
 */
@Stateless
public class AuthHandler implements MessageHandlerLocal {

    @PersistenceContext(unitName = "wse")
    private EntityManager em;
    private final int expirationTime = 10*60 * 1000;//10mins

    @Override
    public Message processMessage(Message request) throws Exception {
        TypedQuery<User> userQuery = this.em.createNamedQuery("User.findByEmailPw", User.class);
        userQuery.setParameter("email", request.data.email);
        userQuery.setParameter("pw", request.data.password);
        Message response = new Message();
        try {
            User u = userQuery.getSingleResult();
            u.setU_token(UUID.randomUUID().toString());
            u.setU_token_expire(new Timestamp(System.currentTimeMillis() + expirationTime));
            response.type = MessageType.CUSTOMER_API_TOKEN;
            response.data.api_token = u.getU_token();
            response.data.api_token_expiration_date = u.getU_token_expire();
        } catch (NoResultException ex) {
            ErrorMessage.CUSTOMER_NOT_FOUND.setToMessage(response);
        }
        return response;
    }

}
