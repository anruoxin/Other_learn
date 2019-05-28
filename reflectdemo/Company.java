package reflectdemo;

/**
 * @author admin
 * @title: Company
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/289:50
 */
public class Company {

    private long id;
    private String name;
    private String address;
    private Integer sum;

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sum=" + sum +
                '}';
    }
}
