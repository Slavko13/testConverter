package ru.sb2.test.domains;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;


public enum  Roles implements GrantedAuthority {
    USER, ADMIN, VIEWER;

    @Override
    public String getAuthority() {
        return name();
    }
}
