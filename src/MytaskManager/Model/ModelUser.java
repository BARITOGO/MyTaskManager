
package MytaskManager.Model;


public class ModelUser {

   
    public String getUserId() {
        return userId;
    }

    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

   
    public char[] getPassWord() {
        return passWord;
    }

    
    public void setPassWord(char[] passWord) {
        this.passWord = passWord;
    }

    public ModelUser(String userId, String userName, char[] passWord) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
    }
    

    public ModelUser() {
    }
   
    
    private String userId;
    private String userName;
    private char [] passWord;
}
