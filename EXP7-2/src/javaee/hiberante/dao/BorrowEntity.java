package javaee.hiberante.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "borrow", schema = "library", catalog = "")
public class BorrowEntity {
    private int borrowId;
    private Timestamp btime;
    private Timestamp deadline;
    private Timestamp rtime;

    @Id
    @Column(name = "borrow_id")
    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    @Basic
    @Column(name = "btime")
    public Timestamp getBtime() {
        return btime;
    }

    public void setBtime(Timestamp btime) {
        this.btime = btime;
    }

    @Basic
    @Column(name = "deadline")
    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(name = "rtime")
    public Timestamp getRtime() {
        return rtime;
    }

    public void setRtime(Timestamp rtime) {
        this.rtime = rtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowEntity that = (BorrowEntity) o;
        return borrowId == that.borrowId &&
                Objects.equals(btime, that.btime) &&
                Objects.equals(deadline, that.deadline) &&
                Objects.equals(rtime, that.rtime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(borrowId, btime, deadline, rtime);
    }
}
