package samplelambda;

public class Main {
    public static void main(String[] args) {
/*        new Thread(() -> {
            System.out.println("Printing line one");
            System.out.println("Printing line two");
        }).start();*/

        Employee emp1 = new Employee("Chetan", 31);
        Employee emp2 = new Employee("Nithesh", 30);

/*        UpperAndConcat uc = new UpperAndConcat() {
            @Override
            public String execute(Employee s1, Employee s2) {
                return s1.getName().toUpperCase()+" - "+s2.getName().toUpperCase();
            }
        };
        String sillyString = uc.execute(emp1,emp2);
        System.out.println(sillyString);*/

        UpperAndConcat uc = (s1, s2) -> {
            String result = String.format("%s - %s", s1.toUpperCase(), s2.toUpperCase());
            return result;
        };

        //UpperAndConcat uc = (s1,s2) -> s1.getName().toUpperCase()+" - "+s2.getName().toUpperCase();
        String sillyString = doStringStuff(uc, emp1.getName(), emp2.getName());
        System.out.println(sillyString);

        ///////////////////
        AnotherClass ac = new AnotherClass();
        System.out.println(ac.doSomething());
        AnotherClassLambda acl = new AnotherClassLambda();
        System.out.println(acl.doSomething());
    }

    public static String doStringStuff(UpperAndConcat uc, String str1, String str2) {
        return uc.execute(str1, str2);
    }
}

interface UpperAndConcat {
    public String execute(String s1, String s2);
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class AnotherClass {
    public String doSomething() {
        System.out.println("AnotherClass's name is = " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperAndConcat() {
            @Override
            public String execute(String s1, String s2) {
                //Anonymous class will have no name.
                System.out.println("Anonymous class's name is = " + getClass().getSimpleName());
                return String.format("%s - %s", s1.toUpperCase(), s2.toUpperCase());
            }
        }, "String1", "String2");
    }
}

//Difference between AnotherClass and this is , here it's lambda expression compared to anonymous class.
class AnotherClassLambda {
    public String doSomething() {
        //Lambda expression wont be considered as Anonymous class,
        //Lambda will be considered as nested block of code
        UpperAndConcat uc = (s1, s2) -> {
            System.out.println("Lambda expression class's name is = " + getClass().getSimpleName());
            String result = String.format("%s - %s", s1, s2);
            return result;
        };
        System.out.println("AnotherClass's name is = " + getClass().getSimpleName());
        return Main.doStringStuff(uc,"String3","String4");
    }
}

//Notes:
//Local variables used inside the lambdas must be final or effectively final.
//lambdas are not anonymous class, but they are nested block of code.
//Whatever lambdas can do, anonymous class can do the same.