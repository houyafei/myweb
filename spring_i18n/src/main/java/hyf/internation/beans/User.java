package hyf.internation.beans;

/**
 * @author yafei.hou
 * Created by yafei.hou on 2017/11/22.
 */
public class User {

    private String loginName;

    private String password ;

    private String userName ;

    public User() {
    }

    public User(String loginName, String password, String userName) {
        this.loginName = loginName;
        this.password = password;
        this.userName = userName;
    }

    public User(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
