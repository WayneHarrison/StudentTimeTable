/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffUI;

import dto.StaffDTO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wayne Jnr
 */
public class StaffCommandFactoryTest
{
    
    public StaffCommandFactoryTest()
    {
    }

    @Test
    public void testCreateCommand()
    {
        System.out.println("createCommand");
        int commandType = 0;
        StaffDTO staffDTO = null;
        StaffCommand expResult = null;
        StaffCommand result = StaffCommandFactory.createCommand(StaffCommandFactory.DO_REGISTER, staffDTO);
        assertNotNull(result);
        
    }
    @Test
    public void testCreateCommand2()
    {
        System.out.println("createCommand");
        int commandType = 0;
        StaffDTO staffDTO = null;
        StaffCommand expResult = null;
        StaffCommand result = StaffCommandFactory.createCommand(StaffCommandFactory.DO_LOGIN, staffDTO);
        assertNotNull(result);
        
    }
    
}
