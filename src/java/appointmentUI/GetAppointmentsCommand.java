package appointmentUI;

import manager.AppointmentManager;

public class GetAppointmentsCommand implements AppointmentCommand{
    
    private final AppointmentManager appMgr;
    private final int staffID;
    
    public GetAppointmentsCommand(int staffID){
        appMgr = new AppointmentManager();
        this.staffID = staffID;
    }
    
    @Override 
   public Object execute(){
       return appMgr.getAppointments(staffID);
   }
}
