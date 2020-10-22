package dto;

import java.io.Serializable;

public class StaffDTO implements Serializable {
    
    private final int staffID;
    private final String username;
    private final String name;
    private final String password1;
    private final String password2;

    public StaffDTO(int staffID, String username, String name, String password1, String password2) {
        this.staffID = staffID;
        this.username = username;
        this.name = name;
        this.password1 = password1;
        this.password2 = password2;
    }

    public int getStaffID() {
        return staffID;
    }
    
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword1() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }
}
