package MytaskManager.Controller;

import MytaskManager.Database.Database;
import MytaskManager.Model.ModelAddTask;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class addtaskcontroller {
   
    public addtaskcontroller() {
    }
   public void addtasktodatabase(ModelAddTask data) {
    try {
        String sql = "INSERT INTO addtask(userid, task, date, deadline, time) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement p = Database.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, data.getUserid());
        p.setString(2, data.getTask());
        
        // Convert java.util.Date objects to java.sql.Date objects
        java.sql.Date sqlDate = new java.sql.Date(data.getDate().getTime());
        java.sql.Date sqlDeadline = new java.sql.Date(data.getDeadline().getTime());

        p.setDate(3, sqlDate);
        p.setDate(4, sqlDeadline);
        p.setString(5, data.getTime());
        p.execute();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
