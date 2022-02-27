package demo.tv.kevin.episode_09.example;

public class ClosureExample2 {

    private int number = 999;

    @Override
    public String toString() {
        return "ClosureExample2{" +
                "number=" + number +
                '}';
    }

    public static <T> String toString(T value){
        return "The value is " + String.valueOf(value) + ".";
    }

    public static void main(String[] args) {
        new ClosureExample2().extracted();
    }

    private void extracted() {
        int number = 100;
        System.out.println("Anonymous Class");
        // Anonymous Class 의 this 는 익명 클래스 자체임
        testClosure("Anonymous Class" , new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
                System.out.println(this.toString());
//                System.out.println(this.number);
                System.out.println(ClosureExample2.this.number);
                System.out.println(toString());
//                System.out.println(toString("hi")); //Shadowing
                System.out.println(ClosureExample2.toString("hi"));

            }
        });

        // Lambda Expression 의 this 는 람다 표현식을 가신 Class 임
        // Lambda 자체는 Scope 이 없음
        System.out.println("Lambda");
        testClosure("Lambda Expression",
                ()-> {
                    System.out.println(number);
                    System.out.println(this.toString());

                    System.out.println(this.number);
                    System.out.println(ClosureExample2.this.number);
                    System.out.println(toString());
                    System.out.println(toString("hi"));
                });
        System.out.println("===================");
    }


    static void testClosure(String name, Runnable runnable){
        System.out.println("Start " + name + ": ");
        runnable.run();
        System.out.println("=================");
    }
}
