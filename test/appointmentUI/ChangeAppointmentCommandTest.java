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
public class ChangeAppointmentCommandTest
{
    
    public ChangeAppointmentCommandTest()
    {
    }

    @Test
    public void testExecute() throws SQLException
    {
        int appID = 2;
        AppointmentDTO changeAppointment = new AppointmentDTO(appID,
                                                              "",
                                                              "",
                                                              "2020-10-10",
                                                              "13:00", 
                                                              "s200");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        AppointmentManager appMgr = new AppointmentManager();
        
        System.out.println("execute");
        ChangeAppointmentCommand instance = new ChangeAppointmentCommand(changeAppointment, appID);
        Object result = instance.execute();
        assertNotNull(result);
    }
    @Test
    public void testExecute2() throws SQLException
    {
        int appID = 1;
        String null1 = null;
        AppointmentDTO changeAppointment = new AppointmentDTO(appID,
                                                              "",
                                                              "",
                                                              null1,
                                                              "13:00", 
                                                              "s200");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        AppointmentManager appMgr = new AppointmentManager();
        
        System.out.println("execute");
        ChangeAppointmentCommand instance = new ChangeAppointmentCommand(changeAppointment, appID);
        boolean result = (boolean) instance.execute();
        assertFalse(result);
    }
    
}
