package com.ibm.repositories;

import javax.enterprise.context.ApplicationScoped;

import com.ibm.entities.User;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, Long> {

}
