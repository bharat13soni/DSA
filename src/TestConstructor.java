public class TestConstructor {
    public static void main(String args[]) {
        (new SpecialPerson()).print();
    }
}

class SpecialPerson {

    String fullName = init();
    String name = "batman";

    public SpecialPerson() {
        name = "superMan";
    }

    private String init() {
        return name;
    }

    public void print() {
        System.out.println(fullName);
    }
}
