package managedbean;

import appointmentUI.AppointmentCommandFactory;
import dto.AppointmentDTO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named(value = "changeAppointmentBean")

public class ChangeAppointmentBean {

    
    private String studentID;
    private String staffID;
    private String date;
    private String time;
    private String room;

    public String changeAppointment(int appID) {
        boolean changeOK = false;

        AppointmentDTO changeAppointment = new AppointmentDTO(appID,
                                                              "",
                                                              "",
                                                              date,
                                                              time, 
                                                              room);
        changeOK = (boolean) AppointmentCommandFactory.createCommand(
                AppointmentCommandFactory.CHANGE_APPOINTMENT, changeAppointment, appID)
                .execute();
        return changeOK ? "staffHome" : "";

    }

  
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

}
