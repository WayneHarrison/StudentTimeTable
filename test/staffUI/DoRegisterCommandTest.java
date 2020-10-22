/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffUI;

import dto.StaffDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wayne Jnr
 */
public class DoRegisterCommandTest
{
    
    public DoRegisterCommandTest()
    {
    }

    @Test
    public void testExecute() throws SQLException
    {
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        
        StaffDTO staffDTO = new StaffDTO(0,"Staff02","Staff02","password","password");
         
        System.out.println("execute");
        DoRegisterCommand instance = new DoRegisterCommand(staffDTO);
        boolean result = (boolean) instance.execute();
        assertFalse(result);
        
    }
    @Test
    public void testExecute2() throws SQLException
    {
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        
        StaffDTO staffDTO = new StaffDTO(0,"Staff05","Staff05","password","password");
         
        System.out.println("execute");
        DoRegisterCommand instance = new DoRegisterCommand(staffDTO);
        boolean result = (boolean) instance.execute();
        assertTrue(result);
        
    }
    
    @Test
    public void testExecute4() throws SQLException
    {
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        
        StaffDTO staffDTO = new StaffDTO(0,"Staff04","","password","Password");
         
        System.out.println("execute");
        DoRegisterCommand instance = new DoRegisterCommand(staffDTO);
        boolean result = (boolean) instance.execute();
        assertFalse(result);
        
    }
    
}
