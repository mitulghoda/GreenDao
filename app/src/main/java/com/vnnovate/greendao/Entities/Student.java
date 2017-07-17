package com.vnnovate.greendao.Entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Vnnovate on 17-Jul-17.
 */
@Entity
public class Student {


    @org.greenrobot.greendao.annotation.Id(autoincrement = true)
    private Long ID;

    private  String name;
    private  String division;
    private  int standard;
    private  String fathername;
    private  String  mothername;
    private  String contactnumber;
    @Generated(hash = 1114431440)
    public Student(Long ID, String name, String division, int standard,
            String fathername, String mothername, String contactnumber) {
        this.ID = ID;
        this.name = name;
        this.division = division;
        this.standard = standard;
        this.fathername = fathername;
        this.mothername = mothername;
        this.contactnumber = contactnumber;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getID() {
        return this.ID;
    }
    public void setID(Long ID) {
        this.ID = ID;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDivision() {
        return this.division;
    }
    public void setDivision(String division) {
        this.division = division;
    }
    public int getStandard() {
        return this.standard;
    }
    public void setStandard(int standard) {
        this.standard = standard;
    }
    public String getFathername() {
        return this.fathername;
    }
    public void setFathername(String fathername) {
        this.fathername = fathername;
    }
    public String getMothername() {
        return this.mothername;
    }
    public void setMothername(String mothername) {
        this.mothername = mothername;
    }
    public String getContactnumber() {
        return this.contactnumber;
    }
    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

}
