/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentUI;

import manager.AppointmentManager;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Wayne Jnr
 */
public class DeleteAppointmentCommandTest
{
    
    public DeleteAppointmentCommandTest()
    {
    }

    @Test
    public void testExecute() throws SQLException
    { 
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        AppointmentManager appMgr = new AppointmentManager();
        int appID = 1;
        System.out.println("execute");
        DeleteAppointmentCommand instance = new DeleteAppointmentCommand(appID);
        Object result = instance.execute();
        assertNotNull(result);
        
    }
    
    @Test
    public void testExecute2() throws SQLException
    { 
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        AppointmentManager appMgr = new AppointmentManager();
        int appID = 0;
        System.out.println("execute");
        DeleteAppointmentCommand instance = new DeleteAppointmentCommand(appID);
        Boolean result = (boolean) instance.execute();
        assertFalse(result);
        
    }
    
}
