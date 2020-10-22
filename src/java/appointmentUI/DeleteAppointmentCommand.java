package appointmentUI;

import manager.AppointmentManager;

public class DeleteAppointmentCommand implements AppointmentCommand {
    
    private final AppointmentManager appMgr;
    private final int appID;
    
    public DeleteAppointmentCommand(int appID){
        appMgr = new AppointmentManager();
        this.appID = appID;
    }
    
    @Override 
   public Object execute(){
       return appMgr.deleteAppointment(appID);
   }
}
