/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentUI;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wayne Jnr
 */
public class StudentCommandTest
{
    
    public StudentCommandTest()
    {
    }

    @Test
    public void testExecute()
    {
        System.out.println("execute");
        StudentCommand instance = new StudentCommandImpl();
        Object expResult = null;
        Object result = instance.execute();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class StudentCommandImpl implements StudentCommand
    {

        public Object execute()
        {
            return null;
        }
    }
    
}
