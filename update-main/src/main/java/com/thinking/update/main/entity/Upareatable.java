package com.thinking.update.main.entity;
public class Upareatable {
    private Integer uptype;
    private String flag;
    private Long taskflag;
    private Long relateid;
    private String remarkstr;
    private Long listorder;
    private Integer upareaid;
    private String upareaname;
    private String upcorpname;
    public Upareatable() {
        super();
    }
    public Upareatable(Integer uptype,String flag,Long taskflag,Long relateid,String remarkstr,Long listorder,Integer upareaid,String upareaname,String upcorpname) {
        super();
        this.uptype = uptype;
        this.flag = flag;
        this.taskflag = taskflag;
        this.relateid = relateid;
        this.remarkstr = remarkstr;
        this.listorder = listorder;
        this.upareaid = upareaid;
        this.upareaname = upareaname;
        this.upcorpname = upcorpname;
    }
    public Integer getUptype() {
        return this.uptype;
    }

    public void setUptype(Integer uptype) {
        this.uptype = uptype;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getTaskflag() {
        return this.taskflag;
    }

    public void setTaskflag(Long taskflag) {
        this.taskflag = taskflag;
    }

    public Long getRelateid() {
        return this.relateid;
    }

    public void setRelateid(Long relateid) {
        this.relateid = relateid;
    }

    public String getRemarkstr() {
        return this.remarkstr;
    }

    public void setRemarkstr(String remarkstr) {
        this.remarkstr = remarkstr;
    }

    public Long getListorder() {
        return this.listorder;
    }

    public void setListorder(Long listorder) {
        this.listorder = listorder;
    }

    public Integer getUpareaid() {
        return this.upareaid;
    }

    public void setUpareaid(Integer upareaid) {
        this.upareaid = upareaid;
    }

    public String getUpareaname() {
        return this.upareaname;
    }

    public void setUpareaname(String upareaname) {
        this.upareaname = upareaname;
    }

    public String getUpcorpname() {
        return this.upcorpname;
    }

    public void setUpcorpname(String upcorpname) {
        this.upcorpname = upcorpname;
    }

}
