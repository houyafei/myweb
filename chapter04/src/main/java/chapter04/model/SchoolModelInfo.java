package chapter04.model;

/**
 * 学校信息
 *
 * @author yafei.hou  on 2018/1/26
 */
public class SchoolModelInfo {

    private String schoolName;

    public SchoolModelInfo() {
    }

    public SchoolModelInfo(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "SchoolModelInfo{" +
                "schoolName='" + schoolName + '\'' +
                '}';
    }
}
