package ChIP_Seq.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/5/19 0019.
 */
@Entity
@Table(name = "Admin", schema = "dbo", catalog = "ChIP-Seq")
public class AdminBean {
    private int adminId;
    private String adminName;
    private String adminPassword;
    private String adminType;

    @Basic
    @Column(name = "Admin_id", nullable = false, insertable = true, updatable = true)
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "Admin_name", nullable = false, insertable = true, updatable = true)
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Basic
    @Column(name = "Admin_password", nullable = false, insertable = true, updatable = true)
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Basic
    @Column(name = "Admin_type", nullable = false, insertable = true, updatable = true)
    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminBean adminBean = (AdminBean) o;

        if (adminId != adminBean.adminId) return false;
        if (adminName != null ? !adminName.equals(adminBean.adminName) : adminBean.adminName != null) return false;
        if (adminPassword != null ? !adminPassword.equals(adminBean.adminPassword) : adminBean.adminPassword != null)
            return false;
        if (adminType != null ? !adminType.equals(adminBean.adminType) : adminBean.adminType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adminId;
        result = 31 * result + (adminName != null ? adminName.hashCode() : 0);
        result = 31 * result + (adminPassword != null ? adminPassword.hashCode() : 0);
        result = 31 * result + (adminType != null ? adminType.hashCode() : 0);
        return result;
    }
}
