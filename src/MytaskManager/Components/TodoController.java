/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MytaskManager.Components;
import java.sql.PreparedStatement;

public class TodoController {
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

    public TodoController() {
    }

    public TodoController(String id,String userid, String addtask, String adddate, String adddeadline, String addtime) {
        this.id = id;
        this.userid = userid;
        this.adddate = adddate;
        this.adddeadline = adddeadline;
        this.addtime = addtime;
    }
    public void TodoControllerToDatabase(){
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
    private String adddate;
    private String adddeadline;
    private String addtime;   
}
