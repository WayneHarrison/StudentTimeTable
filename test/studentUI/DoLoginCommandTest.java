/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentUI;

import dto.StudentDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wayne Jnr
 */
public class DoLoginCommandTest
{
    
    public DoLoginCommandTest()
    {
    }

    @Test
    public void testExecute() throws SQLException        
    {
        StudentDTO stuDTO = new StudentDTO(0,"WH04","","password","",0);
        
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        System.out.println("execute");
        DoLoginCommand instance = new DoLoginCommand(stuDTO);
        boolean result = (boolean) instance.execute();
        assertTrue(result);

    }
    @Test
    public void testExecute2() throws SQLException        
    {
        StudentDTO stuDTO = new StudentDTO(0,"WayneH01","","password","",0);
        
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        System.out.println("execute");
        DoLoginCommand instance = new DoLoginCommand(stuDTO);
        boolean result = (boolean) instance.execute();
        assertFalse(result);

    }
    
}
