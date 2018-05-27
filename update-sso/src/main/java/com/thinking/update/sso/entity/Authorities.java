package com.thinking.update.sso.entity;
public class Authorities {
    private Long id;
    private String authority;
    private String username;
    public Authorities() {
        super();
    }
    public Authorities(Long id,String authority,String username) {
        super();
        this.id = id;
        this.authority = authority;
        this.username = username;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
