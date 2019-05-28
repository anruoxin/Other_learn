package reflectdemo;

import java.util.Date;

/**
 * @author admin
 * @title: Dept
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/289:50
 */
public class Dept {
    private String name;
    private Date addtime;
    private Company company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                ", addtime=" + addtime +
                ", company=" + company +
                '}';
    }
}
