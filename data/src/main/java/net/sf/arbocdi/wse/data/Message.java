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
public class Message {
    public MessageType type;
    public String sequence_id;
    public MessageData data = new MessageData();
}
