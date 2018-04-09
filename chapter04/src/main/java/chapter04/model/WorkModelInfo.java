package chapter04.model;

/**
 * 工作信息
 *
 * @author yafei.hou  on 2018/1/26
 */
public class WorkModelInfo {

    private String workCity;

    public WorkModelInfo() {
    }

    public WorkModelInfo(String workCity) {
        this.workCity = workCity;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    @Override
    public String toString() {
        return "WorkModelInfo{" +
                "workCity='" + workCity + '\'' +
                '}';
    }
}
