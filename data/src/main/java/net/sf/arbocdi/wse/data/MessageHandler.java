/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.arbocdi.wse.data;

/**
 *
 * @author arbocdi
 */
public interface MessageHandler {
    Message processMessage(Message request) throws Exception;
}
