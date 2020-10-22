package managedbean;

import dto.StaffDTO;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import staffUI.StaffCommandFactory;

@Named(value = "staffRegisterBean")
@RequestScoped

public class StaffRegisterBean {

    private int staffID;
    private String username;
    private String name;
    private String password1;
    private String password2;

    public String register() {

        boolean staffRegistered = false;
        if (password1.equals(password2)) {

            StaffDTO newStaff
                    = new StaffDTO(
                            staffID,
                            username,
                            name,
                            password1,
                            password2
                    );
            staffRegistered = (boolean) StaffCommandFactory.createCommand(StaffCommandFactory.DO_REGISTER, newStaff)
                    .execute();
        }
        return staffRegistered ? "staffLogin" : "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        try {
            byte[] hash
                    = MessageDigest.getInstance("SHA-256")
                            .digest(password1.getBytes(StandardCharsets.UTF_8));

            password1 = Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
        }
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        try {
            byte[] hash
                    = MessageDigest.getInstance("SHA-256")
                            .digest(password2.getBytes(StandardCharsets.UTF_8));

            password2 = Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
        }
        this.password2 = password2;
    }

}
