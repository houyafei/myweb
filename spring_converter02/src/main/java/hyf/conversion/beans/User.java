package hyf.conversion.beans;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

/**
 * @author yafei.hou
 * Created by yafei.hou on 2017/11/27.
 */
public class User {

    private String userName ;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday ;

    /**
     * 信用率
     */
    @NumberFormat(style = NumberFormat.Style.PERCENT)
    private double credit;

    /**
     * 资产
     */
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double capital;

    /**
     * 消费
     */
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double consumption;

    public User() {
    }

    public User(String userName, Date birthday, double credit, double capital, double consumption) {
        this.userName = userName;
        this.birthday = birthday;
        this.credit = credit;
        this.capital = capital;
        this.consumption = consumption;
    }

    public User(String userName, Date birthday, double credit, double capital) {
        this.userName = userName;
        this.birthday = birthday;
        this.credit = credit;
        this.capital = capital;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", credit=" + credit +
                ", capital=" + capital +
                ", consumption=" + consumption +
                '}';
    }
}
