package chapter04.model;

/**
 * 用户信息
 *
 * @author yafei.hou  on 2018/1/26
 */
public class UserModel {

    private String userName;

    private String password;

    private SchoolModelInfo schoolModelInfo;

    private WorkModelInfo workModelInfo;

    public UserModel() {
    }

    public UserModel(String userName, String password, SchoolModelInfo schoolModelInfo, WorkModelInfo workModelInfo) {
        this.userName = userName;
        this.password = password;
        this.schoolModelInfo = schoolModelInfo;
        this.workModelInfo = workModelInfo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SchoolModelInfo getSchoolModelInfo() {
        return schoolModelInfo;
    }

    public void setSchoolModelInfo(SchoolModelInfo schoolModelInfo) {
        this.schoolModelInfo = schoolModelInfo;
    }

    public WorkModelInfo getWorkModelInfo() {
        return workModelInfo;
    }

    public void setWorkModelInfo(WorkModelInfo workModelInfo) {
        this.workModelInfo = workModelInfo;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", schoolModelInfo=" + schoolModelInfo +
                ", workModelInfo=" + workModelInfo +
                '}';
    }
}
