package nl.novi.jdemeijervandriel.tailorism.payload;

import java.util.Set;

public class RoleRequest {

    private String username;
    private Set<String> roleName;

    public String getUsername() {
        return username;
    }

    public Set<String> getRoleName() {
        return roleName;
    }

    public void setRoleName(Set<String> roleName) {
        this.roleName = roleName;
    }
}
