package demo.tv.kevin.episode_09.example;

public class ClosureExample {

    public static void main(String[] args) {
        int number = 100;
//        number = 1; - final or effectively final
        System.out.println("Anonymous Class");
        testClosure("Anonymous Class" , new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
            }
        });

        System.out.println("Lambda");
        testClosure("Lambda Expression", ()-> System.out.println(number));
        System.out.println("===================");
    }


    static void testClosure(String name, Runnable runnable){
        System.out.println("Start " + name + ": ");
        runnable.run();
        System.out.println("=================");
    }
}
