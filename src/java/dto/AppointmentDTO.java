package dto;

import java.io.Serializable;

public class AppointmentDTO implements Serializable {

    private final int appointmentID; 
    private final String studentID;
    private final String staffID;
    private final String date;
    private final String time;
    private final String room;
    
    public AppointmentDTO(int appointmentID ,String studentID, String staffID, String date, String time, String room) {
        this.appointmentID = appointmentID;
        this.studentID = studentID; 
        this.staffID = staffID;
        this.date = date;
        this.time = time;
        this.room = room;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    
    public String getStudentID() {
        return studentID;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }
    
    
    
}
