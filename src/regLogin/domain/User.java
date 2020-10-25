package regLogin.domain;

public class User {

    private int id;
    private String name;
    private String pwd;
    private String pwdl;
    private String dizhi;
    private String tel;
    private int dongjie;
    private String tishi;
    private String huida;
    private String truename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwdl() {
        return pwdl;
    }

    public void setPwdl(String pwdl) {
        this.pwdl = pwdl;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getDongjie() {
        return dongjie;
    }

    public void setDongjie(int dongjie) {
        this.dongjie = dongjie;
    }

    public String getTishi() {
        return tishi;
    }

    public void setTishi(String tishi) {
        this.tishi = tishi;
    }

    public String getHuida() {
        return huida;
    }

    public void setHuida(String huida) {
        this.huida = huida;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", pwdl='" + pwdl + '\'' +
                ", dizhi='" + dizhi + '\'' +
                ", tel='" + tel + '\'' +
                ", dongjie=" + dongjie +
                ", tishi='" + tishi + '\'' +
                ", huida='" + huida + '\'' +
                ", truename='" + truename + '\'' +
                '}';
    }
}
