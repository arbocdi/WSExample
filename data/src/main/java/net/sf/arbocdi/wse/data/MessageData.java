/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.arbocdi.wse.data;

import java.sql.Timestamp;

/**
 *
 * @author arbocdi
 */
public class MessageData {
    //auth
    public String email;
    public String password;
    //errors
    public String error_description;
    public String error_code;
    //token
    public String api_token;
    public Timestamp api_token_expiration_date;
}
