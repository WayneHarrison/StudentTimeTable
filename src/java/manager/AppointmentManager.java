package manager;

import dto.AppointmentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentManager extends DatabaseOperation {

    public static int appointmentID;

    public boolean makeAppointment(AppointmentDTO appDTO) {
        boolean appointmentOK = false;
        try {
            Connection conn = getConnection();

            PreparedStatement stmtCheck = conn.prepareStatement("SELECT * FROM APPOINTMENT WHERE STAFFID = ? AND APPOINTMENTTIME = ? AND APPOINTMENTDATE = ?");
            stmtCheck.setString(1, appDTO.getStaffID());
            stmtCheck.setString(2, appDTO.getTime());
            stmtCheck.setString(3, appDTO.getDate());
            ResultSet rs = stmtCheck.executeQuery();
            if (!rs.next()) {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO APPOINTMENT (STUDENTID, STAFFID, APPOINTMENTDATE, APPOINTMENTTIME, APPOINTMENTROOM) VALUES (?,?,?,?,?)");
                stmt.setString(1, appDTO.getStudentID());
                stmt.setString(2, appDTO.getStaffID());
                stmt.setString(3, appDTO.getDate());
                stmt.setString(4, appDTO.getTime());
                stmt.setString(5, appDTO.getRoom());
                int rows = stmt.executeUpdate();

                appointmentOK = rows == 1;
                stmt.close();
            }
            stmtCheck.close();
            conn.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return appointmentOK;
    }

    public boolean changeAppointment(AppointmentDTO appDTO, int appID) {
        boolean changeOK = false;

        try {
            Connection conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement("UPDATE APPOINTMENT SET APPOINTMENTDATE = ?, APPOINTMENTTIME = ?, APPOINTMENTROOM = ? WHERE APPOINTMENTID = ?");
            stmt.setString(1, appDTO.getDate());
            stmt.setString(2, appDTO.getTime());
            stmt.setString(3, appDTO.getRoom());
            stmt.setInt(4, appID);
            int rows = stmt.executeUpdate();
            changeOK = rows == 1;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return changeOK;
    }

    public boolean deleteAppointment(int appID) {
        boolean deleteOK = false;

        try {
            Connection conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM APPOINTMENT WHERE APPOINTMENTID = ?");
            stmt.setInt(1, appID);
            deleteOK = stmt.execute();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return deleteOK;
    }

    public ArrayList<AppointmentDTO> getAppointments(int staffID) {

        ArrayList<AppointmentDTO> allAppointments = new ArrayList<>();
        try {
            Connection conn = getConnection();

            PreparedStatement stmtAppointments = conn.prepareStatement("SELECT * FROM APPOINTMENT WHERE STAFFID = ?");
            stmtAppointments.setInt(1, staffID);
            ResultSet rs = stmtAppointments.executeQuery();

            while (rs.next()) {
                AppointmentDTO appointments = new AppointmentDTO(rs.getInt("APPOINTMENTID"), rs.getString("STUDENTID"), rs.getString("STAFFID"),
                        rs.getString("APPOINTMENTDATE"), rs.getString("APPOINTMENTTIME"), rs.getString("APPOINTMENTROOM"));
                allAppointments.add(appointments);
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return allAppointments;
    }
    
    public ArrayList<AppointmentDTO> getStuAppointments(int stuID) {

        ArrayList<AppointmentDTO> allAppointments = new ArrayList<>();
        try {
            Connection conn = getConnection();

            PreparedStatement stmtAppointments = conn.prepareStatement("SELECT * FROM APPOINTMENT WHERE STUDENTID = ?");
            stmtAppointments.setInt(1, stuID);
            ResultSet rs = stmtAppointments.executeQuery();

            while (rs.next()) {
                AppointmentDTO appointments = new AppointmentDTO(rs.getInt("APPOINTMENTID"), rs.getString("STUDENTID"), rs.getString("STAFFID"),
                        rs.getString("APPOINTMENTDATE"), rs.getString("APPOINTMENTTIME"), rs.getString("APPOINTMENTROOM"));
                allAppointments.add(appointments);
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return allAppointments;
    }
    
    public AppointmentDTO getAppointment(int appID){
        AppointmentDTO appointment = null;
        
        try{
            Connection conn = getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM APPOINTMENT WHERE APPOINTMENTID = ?");
            stmt.setInt(1, appID);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                appointment = new AppointmentDTO(rs.getInt("APPOINTMENTID"),
                                                 rs.getString("STUDENTID"),
                                                 rs.getString("STAFFID"),
                                                 rs.getString("APPOINTMENTDATE"),
                                                 rs.getString("APPOINTMENTTIME"),
                                                 rs.getString("APPOINTMENTROOM")
                ); 
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return appointment;
    }

}
