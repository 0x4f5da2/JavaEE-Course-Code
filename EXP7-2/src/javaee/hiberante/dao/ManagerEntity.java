package javaee.hiberante.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "manager", schema = "library", catalog = "")
public class ManagerEntity {
    private int managerId;
    private String passWd;
    private String mname;

    @Id
    @Column(name = "manager_id")
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "pass_wd")
    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    @Basic
    @Column(name = "mname")
    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerEntity that = (ManagerEntity) o;
        return managerId == that.managerId &&
                Objects.equals(passWd, that.passWd) &&
                Objects.equals(mname, that.mname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(managerId, passWd, mname);
    }
}
