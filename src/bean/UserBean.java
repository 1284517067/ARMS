package bean;

import java.io.Serializable;

public class UserBean implements Serializable {
    private String user;
    private String pwd;
    private String number;
    private String name;
    private String sex;
    private String tel;
    private String site;
    private int credit;

    public UserBean() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setAll(String user,String pwd,String number,String name,String sex,String tel,String site,int credit)
    {
        setUser(user);
        setPwd(pwd);
        setNumber(number);
        setName(name);
        setSex(sex);
        setTel(tel);
        setSite(site);
        setCredit(credit);
    }

    public String getAll()
    {
        return "User = "+ user + ", Pwd = " + pwd +", number = "+ number + ", Name = " + name + ", Sex = " + sex + ", tel = " + tel + ", site = "+ site + ", credit = " + credit;
    }
}
