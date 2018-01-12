package ChIP_Seq.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/5/19 0019.
 */
@Entity
@Table(name = "User", schema = "dbo", catalog = "ChIP-Seq")
public class UserBean {
    private int userId;
    private String userName;
    private String userPassword;
    private String userWork;

    @Basic
    @Column(name = "User_id", nullable = false, insertable = true, updatable = true)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "User_name", nullable = false, insertable = true, updatable = true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "User_password", nullable = false, insertable = true, updatable = true)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "User_work", nullable = false, insertable = true, updatable = true)
    public String getUserWork() {
        return userWork;
    }

    public void setUserWork(String userWork) {
        this.userWork = userWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBean userBean = (UserBean) o;

        if (userId != userBean.userId) return false;
        if (userName != null ? !userName.equals(userBean.userName) : userBean.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(userBean.userPassword) : userBean.userPassword != null)
            return false;
        if (userWork != null ? !userWork.equals(userBean.userWork) : userBean.userWork != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userWork != null ? userWork.hashCode() : 0);
        return result;
    }
}
