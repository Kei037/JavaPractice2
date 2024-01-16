package test.contactTest;

public class Contacts {
    static int count;
    private String name;
    private String tel;
    private String email;

    public Contacts(String name, String tel, String email) {
        this.name = name;
        this.tel = tel;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Conteacts{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }
}
