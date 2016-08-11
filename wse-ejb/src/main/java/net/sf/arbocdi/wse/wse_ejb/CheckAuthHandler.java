package net.sf.arbocdi.wse.wse_ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import net.sf.arbocdi.wse.data.ErrorMessage;
import net.sf.arbocdi.wse.data.Message;
import net.sf.arbocdi.wse.data.MessageHandler;
import net.sf.arbocdi.wse.data.MessageHandlerLocal;
import net.sf.arbocdi.wse.wse_ejb.entity.User;

/**
 *
 * @author arbocdi
 */
@Stateless
public class CheckAuthHandler implements MessageHandlerLocal {

    @PersistenceContext(unitName = "wse")
    private EntityManager em;
    @EJB(beanName = "PingHandler")
    private MessageHandlerLocal next;

    @Override
    public Message processMessage(Message request) throws Exception {
        try {
            User user = em.createNamedQuery("User.findToken", User.class).setParameter("token", request.data.api_token).getSingleResult();
            if (user.getU_token_expire().getTime() <= System.currentTimeMillis()) {
                Message tokenExpired = new Message();
                ErrorMessage.TOKEN_EXPIRED.setToMessage(tokenExpired);
                return tokenExpired;
            } else {
                return next.processMessage(request);
            }
        } catch (NoResultException ex) {
            Message tokenNotFound = new Message();
            ErrorMessage.TOKEN_NOT_FOUND.setToMessage(tokenNotFound);
            return tokenNotFound;
        }

    }

}
