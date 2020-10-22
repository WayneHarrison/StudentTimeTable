package managedbean;

import appointmentUI.AppointmentCommandFactory;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="deleteAppointmentBean")
@RequestScoped

public class DeleteAppointmentBean {
    
    public String deleteAppointment(int appID){
        AppointmentCommandFactory.createCommand(AppointmentCommandFactory.DELETE_APPOINTMENT, appID)
                .execute();
        return "/protected/staffHome";
    }
    public String stuDeleteAppointment(int appID){
        AppointmentCommandFactory.createCommand(AppointmentCommandFactory.DELETE_APPOINTMENT, appID)
                .execute();
        return "/protected/studentHome";
    }
    
}
