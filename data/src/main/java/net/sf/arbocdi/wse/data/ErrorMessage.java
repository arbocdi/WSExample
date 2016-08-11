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
public class ErrorMessage {

    public static final ErrorMessage CUSTOMER_NOT_FOUND = new ErrorMessage(MessageType.CUSTOMER_ERROR,
            "Customer not found",
            "customer.notFound");
    public static final ErrorMessage TOKEN_NOT_FOUND = new ErrorMessage(MessageType.CUSTOMER_ERROR,
            "Token not found",
            "token.notFound");
    public static final ErrorMessage TOKEN_EXPIRED = new ErrorMessage(MessageType.CUSTOMER_ERROR,
            "Token expired",
            "token.expired");

    

    public ErrorMessage(
            MessageType messageType,
            String error_descriprion,
            String error_code) {
        this.messageType = messageType;
        this.error_descriprion = error_descriprion;
        this.error_code = error_code;
    }

    public void setToMessage(Message message) {
        message.type = this.messageType;
        message.data.error_description = this.error_descriprion;
        message.data.error_code = this.error_code;
    }

    public MessageType messageType;
    public String error_descriprion;
    public String error_code;

}
