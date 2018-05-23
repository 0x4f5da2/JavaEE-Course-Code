package javaee.hiberante.dao;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "booklist", schema = "library", catalog = "")
public class BooklistEntity {
    private String isbn;
    private String bname;
    private String publisher;
    private String writer;
    private Date ptime;
    private int number;

    @Id
    @Column(name = "ISBN")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "bname")
    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Basic
    @Column(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Basic
    @Column(name = "writer")
    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Basic
    @Column(name = "ptime")
    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooklistEntity that = (BooklistEntity) o;
        return number == that.number &&
                Objects.equals(isbn, that.isbn) &&
                Objects.equals(bname, that.bname) &&
                Objects.equals(publisher, that.publisher) &&
                Objects.equals(writer, that.writer) &&
                Objects.equals(ptime, that.ptime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(isbn, bname, publisher, writer, ptime, number);
    }
}
