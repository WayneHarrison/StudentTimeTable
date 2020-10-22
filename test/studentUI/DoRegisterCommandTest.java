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
import javax.servlet.http.HttpServletRequest;
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
        StudentDTO stuDTO = new StudentDTO(0, "WH01","Wayne","password","password",22);
        
        System.out.println("execute");
        DoRegisterCommand instance = new DoRegisterCommand(stuDTO);
        boolean result = (boolean) instance.execute();
        assertFalse(result);
    }
    
    @Test
    public void testExecute2() throws SQLException
    {
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        StudentDTO stuDTO = new StudentDTO(0, "WH04","Wayne","password","password",22);
        
        System.out.println("execute");
        DoRegisterCommand instance = new DoRegisterCommand(stuDTO);
        boolean result = (boolean) instance.execute();
        assertTrue(result);
    }
    @Test
    public void testExecute3() throws SQLException
    {
        String null1=null;
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        StudentDTO stuDTO = new StudentDTO(0, null1 ,"Wayne","password","password",22);
        
        System.out.println("execute");
        DoRegisterCommand instance = new DoRegisterCommand(stuDTO);
        boolean result = (boolean) instance.execute();
        assertFalse(result);
    }
    
}
