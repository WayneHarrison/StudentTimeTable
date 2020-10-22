package managedbean;

import appointmentUI.AppointmentCommandFactory;
import dto.AppointmentDTO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "appointmentBean")
@RequestScoped

public class MakeAppointmentBean {

    private final int appID = 0;
    private String studentID;
    private String staffID;
    private String date;
    private String time;
    private String room;

    public String makeAppointment() {
        boolean appointmentOK = false;

        AppointmentDTO newAppointment
                = new AppointmentDTO(appID,
                        studentID,
                        staffID,
                        date,
                        time,
                        room);
        appointmentOK = (boolean) AppointmentCommandFactory.createCommand(AppointmentCommandFactory.MAKE_APPOINTMENT, newAppointment)
                .execute();
        return appointmentOK ? "/protected/staffHome?faces-redirect=true" : "";
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStaffID() {
        return staffID;
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
