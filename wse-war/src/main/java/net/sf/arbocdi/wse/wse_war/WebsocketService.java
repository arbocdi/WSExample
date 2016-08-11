/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.arbocdi.wse.wse_war;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.Arrays;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import net.sf.arbocdi.wse.data.Message;
import net.sf.arbocdi.wse.data.MessageHandler;
import net.sf.arbocdi.wse.data.MessageHandlerLocal;

/**
 * @ServerEndpoint gives the relative name for the end point This will be
 * accessed via ws://localhost:8080/EchoChamber/echo Where "localhost" is the
 * address of the host, "EchoChamber" is the name of the package and "echo" is
 * the address to access this class from the server
 */
@ServerEndpoint("/wsservice")
@Stateless
public class WebsocketService {

    @EJB(beanName = "SequenceHandler", beanInterface = MessageHandlerLocal.class)
    private MessageHandler handler;

    /**
     * @OnOpen allows us to intercept the creation of a new session. The session
     * class allows us to send data to the user. In the method onOpen, we'll let
     * the user know that the handshake was successful.
     */
    @OnOpen
    public void onOpen(Session session) {
//        try {
//            session.getBasicRemote().sendText("Connection Established");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

    /**
     * When a user sends a message to the server, this method will intercept the
     * message and allow us to react to it. For now the message is read as a
     * String.
     * @param message
     * @param session
     * @return 
     */
    @OnMessage
    public String onMessage(String message, Session session) {
        Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
        String responseStr;
        try {
            Message request = gson.fromJson(message, Message.class);
            Message response = this.handler.processMessage(request);
            responseStr = gson.toJson(response);
        } catch (Exception ex) {
            responseStr = ex.toString();
        }
        return responseStr;
    }

    /**
     * The user closes the connection.
     *
     * Note: you can't send messages to the client from this method
     */
//    @OnClose
//    public void onClose(Session session) {
//        System.out.println("Session " + session.getId() + " has ended");
//    }
}
