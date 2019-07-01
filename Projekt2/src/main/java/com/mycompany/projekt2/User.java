/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projekt2;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author kruko
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

     public User() {
    }
     
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "position")
    private String position;

    public String getLogin() {
        return login;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public String getPosition() {
        return position;
    }



    public User(String login, String password, String position) {
        this.login = login;
        this.password = password;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login=" + login + ", password=" + password + ", position=" + position + '}';
    }

}

