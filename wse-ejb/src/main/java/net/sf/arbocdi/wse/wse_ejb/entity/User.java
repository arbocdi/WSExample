/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.arbocdi.wse.wse_ejb.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author arbocdi
 */
@Data
@Entity
@Table(name = "users", schema = "user_data")
@NamedQueries({
    @NamedQuery(name = "User.findByEmailPw", query = "SELECT u FROM User u WHERE u.u_email = :email AND u.u_pw = :pw"),
    @NamedQuery(name = "User.findToken", query = "SELECT u FROM User u WHERE u.u_token = :token")

})
public class User implements Serializable {

    @Id
    private String u_email;
    private String u_pw;
    private String u_token;
    private Timestamp u_token_expire;
}
