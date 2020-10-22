package managedbean;

import dto.StaffDTO;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import staffUI.StaffCommandFactory;

@Named(value = "staffLoginBean")
@SessionScoped

public class StaffLoginBean implements Serializable {
    
    private int staffID;
    private String username;
    private String name;
    private String password1;
    private String password2;
    static boolean loginOK = false;

    public String login() {
        boolean loginOK = false;

        StaffDTO loginStaff;
        loginStaff = new StaffDTO(
                staffID,
                username,
                name,
                password1,
                password2
        );
        loginOK = (boolean) StaffCommandFactory.createCommand(StaffCommandFactory.DO_LOGIN, loginStaff)
                .execute();

        return loginOK ? "/protected/staffHome" : "";
    }
    public String logout() throws IOException {
        
        loginOK = false;

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect("../index.xhtml");

        return "";

    }

    public boolean isLoginOK() {
        return loginOK;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword2(String password2) {

        this.password2 = password2;
    }
}
