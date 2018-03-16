package com.mlw.service;

import java.util.Set;

public interface RoleService {
    Set<String> findRoleByUserId(String id);
}
