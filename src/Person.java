public class Person {

    private String name;
    private long id;
    private int birth_year;

    public Person(String name, int birth_year, long id) {
        this.name = name;
        this.birth_year = birth_year;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }
}
