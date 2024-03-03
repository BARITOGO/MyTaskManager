
package MytaskManager.Model;

import java.time.LocalTime;
import java.util.Date;


public class ModelAddTask {

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

 

    public ModelAddTask() {
    }

    public ModelAddTask(String userid, String task, Date date, Date deadline, String time) {
        this.userid = userid;
        this.task = task;
        this.date = date;
        this.deadline = deadline;
        this.time = time;
    }

 
 
    
    
    private String userid;
    private String task;
    private Date date;
    private Date deadline;
    private String time;
}
