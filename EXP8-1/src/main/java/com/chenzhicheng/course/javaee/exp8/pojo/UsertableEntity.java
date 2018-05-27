package com.chenzhicheng.course.javaee.exp8.pojo;

import java.util.Collection;
import java.util.Objects;

public class UsertableEntity {
    private int id;
    private String username;
    private String password;
    private int permission;
    private Collection<LytableEntity> lytablesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsertableEntity entity = (UsertableEntity) o;
        return id == entity.id &&
                permission == entity.permission &&
                Objects.equals(username, entity.username) &&
                Objects.equals(password, entity.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, permission);
    }

    public Collection<LytableEntity> getLytablesById() {
        return lytablesById;
    }

    public void setLytablesById(Collection<LytableEntity> lytablesById) {
        this.lytablesById = lytablesById;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return username;
    }
}
