
package MytaskManager.Components;

//import MytaskManager.Database.Database;
import java.sql.PreparedStatement;
//import library.database.DatabaseConnection;


public class addTaskController {

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAddtask() {
        return addtask;
    }

    public void setAddtask(String addtask) {
        this.addtask = addtask;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }

    public String getAdddeadline() {
        return adddeadline;
    }

    public void setAdddeadline(String adddeadline) {
        this.adddeadline = adddeadline;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public addTaskController() {
    }

    public addTaskController(String id,String userid, String addtask, String adddate, String adddeadline, String addtime) {
        this.id = id;
        this.userid = userid;
        this.addtask = addtask;
        this.adddate = adddate;
        this.adddeadline = adddeadline;
        this.addtime = addtime;
    }
    public void addTaskToDatabase(){
//        try {
//            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement("insert into todolist(id,userid,todo,date,deadline,time)values(?,?,?,?,?,?)");
//            
//        p.setString(1, id);
//        p.setString(2, userid);
//        p.setString(3, addtask);
//        p.setString(4, adddate);
//        p.setString(5, adddeadline);
//        p.setString(6, addtime);       
//        } 
//        catch (Exception e) {
//            e.printStackTrace();
//        }
 
    }   
    private String id;
    private String userid;
    private String addtask;
    private String adddate;
    private String adddeadline;
    private String addtime;             
}
