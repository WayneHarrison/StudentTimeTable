package managedbean;

import appointmentUI.AppointmentCommandFactory;
import dto.AppointmentDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named(value = "viewAppointmentBean")

public class ViewAppointmentBean implements Serializable {

    int staffID = manager.StaffManager.staffID;
    int stuID = manager.StudentManager.stuID;
    private AppointmentDTO appDetails = null;

    public ArrayList<AppointmentDTO> getAppointments() {
        ArrayList<AppointmentDTO> appointments
                = (ArrayList<AppointmentDTO>) AppointmentCommandFactory.createCommand(
                        AppointmentCommandFactory.GET_APPOINTMENTS, staffID)
                        .execute();

        return appointments;
    }
    
    public ArrayList<AppointmentDTO> getStuAppointments() {
        ArrayList<AppointmentDTO> stuAppointments
                = (ArrayList<AppointmentDTO>) AppointmentCommandFactory.createCommand(
                        AppointmentCommandFactory.GET_APPOINTMENTS, stuID)
                        .execute();

        return stuAppointments;
    }
    
    
    public String getAppointment(int appID){
        appDetails = (AppointmentDTO) AppointmentCommandFactory.createCommand(
                AppointmentCommandFactory.GET_APPOINTMENT, appID)
                .execute();
        return "/protected/changeAppointment";
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public AppointmentDTO getAppDetails() {
        return appDetails;
    }

    public void setAppDetails(AppointmentDTO appDetails) {
        this.appDetails = appDetails;
    }
    

}
