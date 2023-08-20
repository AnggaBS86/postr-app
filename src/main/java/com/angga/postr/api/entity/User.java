package com.angga.postr.api.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This entities used for table `users` purposed
 * <p>
 * This is the SQL query syntax generator of this table :
 * <p>
 * CREATE TABLE `users` (
 * `id` int NOT NULL AUTO_INCREMENT,
 * `active` int DEFAULT NULL,
 * `username` varchar(50) COLLATE utf8_bin NOT NULL,
 * `password` varchar(45) COLLATE utf8_bin DEFAULT NULL,
 * `roles` varchar(255) COLLATE utf8_bin DEFAULT NULL,
 * PRIMARY KEY (`id`,`username`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
 *
 * @author Angga Bayu Sejati<anggabs86@gmail.com>
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String username;
    private String password;
    private String roles;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @JoinColumn(name = "post_id")
    private Post post;

    /**
     * Get ID
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Set ID
     *
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get `username`
     *
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username value
     *
     * @param username String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get Password
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password value
     *
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get roles
     *
     * @return String
     */
    public String getRoles() {
        return roles;
    }

    /**
     * Set roles value
     *
     * @param roles String
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }
}
