package me.whiteship.demospringdata;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "myAccount")
@Table
public class Account {
    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;

    @Temporal(TemporalType.TIME)
    private Date created = new Date();

    @Transient
    private String no;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
