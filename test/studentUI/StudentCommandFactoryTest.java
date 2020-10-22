/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentUI;

import dto.StudentDTO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wayne Jnr
 */
public class StudentCommandFactoryTest
{
    
    public StudentCommandFactoryTest()
    {
    }

    @Test
    public void testCreateCommand_int_StudentDTO()
    {
        System.out.println("createCommand");
        int commandType = 0;
        StudentDTO studentDTO = null;
        StudentCommand expResult = null;
        StudentCommand result = StudentCommandFactory.createCommand(StudentCommandFactory.DO_LOGIN, studentDTO);
        assertNotNull(result);
    }
    @Test
    public void testCreateCommand_int_StudentDTO2()
    {
        System.out.println("createCommand");
        int commandType = 0;
        StudentDTO studentDTO = null;
        StudentCommand expResult = null;
        StudentCommand result = StudentCommandFactory.createCommand(StudentCommandFactory.DO_REGISTER, studentDTO);
        assertNotNull(result);
    }

    @Test
    public void testCreateCommand_int_int()
    {
        System.out.println("createCommand");
        int commandType = 0;
        int stuID = 0;
        StudentCommand expResult = null;
        StudentCommand result = StudentCommandFactory.createCommand(StudentCommandFactory.GETTIMETABLE, stuID);
        assertNotNull(result);
    }
    
}
