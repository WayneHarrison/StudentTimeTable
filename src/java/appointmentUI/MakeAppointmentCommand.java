package appointmentUI;

import dto.AppointmentDTO;
import manager.AppointmentManager;

public class MakeAppointmentCommand implements AppointmentCommand{
   private final AppointmentManager appMgr;
   private final AppointmentDTO appDTO;
   
   public MakeAppointmentCommand(AppointmentDTO appDTO){
       this.appDTO = appDTO;
       appMgr = new AppointmentManager();
   
   } 
   
   @Override 
   public Object execute(){
       return appMgr.makeAppointment(appDTO);
   }
   
}
