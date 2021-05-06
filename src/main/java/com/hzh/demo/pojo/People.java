package com.hzh.demo.pojo;

public class People {
    private int pid;
    private String pname;
    private String pfrom;
    private String pphone;
    private String paddress;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPfrom() {
        return pfrom;
    }

    public void setPfrom(String pfrom) {
        this.pfrom = pfrom;
    }

    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public People(int pid, String pname, String pfrom, String pphone, String paddress) {
        this.pid = pid;
        this.pname = pname;
        this.pfrom = pfrom;
        this.pphone = pphone;
        this.paddress = paddress;
    }

    public People() {
    }

    @Override
    public String toString() {
        return "People{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pfrom='" + pfrom + '\'' +
                ", pphone='" + pphone + '\'' +
                ", paddress='" + paddress + '\'' +
                '}';
    }
}
