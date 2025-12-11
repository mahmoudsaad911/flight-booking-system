    public class Employee extends Person{
        private double salary;
        private String position;

        public Employee(String name, int birth_year, long id, double salary, String position) {
            super(name, birth_year, id);
            this.salary = salary;
            this.position = position;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }
