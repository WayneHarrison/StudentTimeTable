package appointmentUI;

import dto.AppointmentDTO;
import manager.AppointmentManager;

public class ChangeAppointmentCommand implements AppointmentCommand {

    private final AppointmentManager appMgr;
    private final AppointmentDTO appDTO;
    private final int appID;
    
    public ChangeAppointmentCommand(AppointmentDTO appDTO, int appID){
        
        appMgr = new AppointmentManager();
        this.appID = appID;
        this.appDTO = appDTO;
    }
@Override 
   public Object execute(){
       return appMgr.changeAppointment(appDTO, appID);
   }
}
