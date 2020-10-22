package studentUI;

import manager.StudentManager;

public class GetTimeTableCommand implements StudentCommand {
    private final StudentManager stuMgr;
    private final int stuID;
    
    public GetTimeTableCommand(int stuID) {
        
        this.stuID = stuID;
        stuMgr = new StudentManager();
    }
    
    @Override
    public Object execute()
    {
        return stuMgr.getTimeTable(stuID);
    }
}
