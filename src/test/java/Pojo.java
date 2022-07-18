public class Pojo {

    private String firstName;
    private String lastName;
    private String role;
    private String id;
    private String department;

    public Pojo(String firstName, String lastName, String role, String id, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.id = id;
        this.department = department;


    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
