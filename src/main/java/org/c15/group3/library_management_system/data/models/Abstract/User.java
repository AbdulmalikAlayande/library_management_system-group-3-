package org.c15.group3.library_management_system.data.models.Abstract;

import org.c15.group3.library_management_system.data.models.enums.Role;
import org.c15.group3.library_management_system.data.models.UserBioData;


public abstract class User {
    private Long id;
    private UserBioData userBioData;
    private Role role;
}
