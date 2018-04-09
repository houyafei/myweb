package reports.entity;

/**
 * @author yafei.hou
 * Created by yafei.hou on 2017/12/25.
 */
public class User {

    private String name;

    private String password;

    private String token;

    private long userId;

    public User() {
    }

    public User(String name, String password, String token, long userId) {
        this.name = name;
        this.password = password;
        this.token = token;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", userId=" + userId +
                '}';
    }
}
