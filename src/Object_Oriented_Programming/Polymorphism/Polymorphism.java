/**
 * 
 * Polymorphism allows us to have many methods with same name but different
 * characteristics.
 * 
 * Two Ways to use polymorphism: overloading and method overriding.
 */
public class Polymorphism {

    public static void main(String[] args) {
        // Overloading
        Employee emp = new Employee("Frank", 29);
        emp.getCurEmp();

        // Overriding
        User user = new User();
        user.intro();
        Admin admin = new Admin();
        admin.intro();
    }

    /**
     * Method overloading allow us to have many methods with same name but different
     * parameter and functionality.
     */
    static class Employee {
        private String name;
        private Integer age;

        public Employee() {
            super();
            name = "Unknown";
        }

        public Employee(String name) {
            super();
            this.name = name;
        }

        public Employee(String name, Integer age) {
            super();
            this.name = name;
            this.age = age;
        }

        public void getCurEmp() {
            System.out.println("My name is " + name + " and i am a " + age + " years old");
        }
    }

    /**
     * Method overriding allows us to override the methods of a parent class from
     * its child class.
     */
    static class User {
        public void intro() {
            System.out.println("Hello user!");
        }
    }

    static class Admin extends User {
        public void intro() {
            System.out.println("Hello admin!");
        }
    }
}