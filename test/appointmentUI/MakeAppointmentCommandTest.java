/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentUI;

import dto.AppointmentDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import manager.AppointmentManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wayne Jnr
 */
public class MakeAppointmentCommandTest
{
    
    public MakeAppointmentCommandTest()
    {
    }

    @Test
    public void testExecute() throws SQLException
    {
        int appID = 0;
        AppointmentDTO appointment = new AppointmentDTO(appID,
                                                              "1",
                                                              "1",
                                                              "2020-10-14",
                                                              "13:00", 
                                                              "s200");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        AppointmentManager appMgr = new AppointmentManager();
        
        System.out.println("execute");
        MakeAppointmentCommand instance = new MakeAppointmentCommand(appointment);

        boolean result = (boolean) instance.execute();
        assertTrue(result);
    }
    @Test
    public void testExecute2() throws SQLException
    {
        int appID = 0;
        AppointmentDTO appointment = new AppointmentDTO(appID,
                                                              "1",
                                                              "1",
                                                              "2020-10-10",
                                                              "13:00", 
                                                              "s200");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        AppointmentManager appMgr = new AppointmentManager();
        
        System.out.println("execute");
        MakeAppointmentCommand instance = new MakeAppointmentCommand(appointment);

        boolean result = (boolean) instance.execute();
        assertFalse(result);
    }
    @Test
    public void testExecute3() throws SQLException
    {
        int appID = 0;
        AppointmentDTO appointment = new AppointmentDTO(appID,
                                                              "",
                                                              "1",
                                                              "2020-10-13",
                                                              "13:00", 
                                                              "s200");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        AppointmentManager appMgr = new AppointmentManager();
        
        System.out.println("execute");
        MakeAppointmentCommand instance = new MakeAppointmentCommand(appointment);

        boolean result = (boolean) instance.execute();
        assertFalse(result);
    }
    
}
