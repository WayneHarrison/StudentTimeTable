package managedbean;

import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "logoutBean")
@RequestScoped

public class LogoutBean {

    public String logout() throws IOException {
        
        StaffLoginBean.loginOK = false;
        StudentLoginBean.loginOK = false;

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect("../index.xhtml");

        return "";

    }
}
