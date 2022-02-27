package demo.tv.kevin.episode_09.example;

public class ClosureExample3 {

    public static void main(String[] args) {
        int number = 100;
//        number = 1; - final or effectively final
        System.out.println("Anonymous Class");
        testClosure("Anonymous Class" , new Runnable() {
            @Override
            public void run() {
                int number = 40;
                System.out.println(number);
            }
        });

        System.out.println("Lambda");
        testClosure("Lambda Expression", ()-> {
//            int number = 40; <- variable number is already defined in scope
            System.out.println(number);
        });
        System.out.println("===================");
    }


    static void testClosure(String name, Runnable runnable){
        System.out.println("Start " + name + ": ");
        runnable.run();
        System.out.println("=================");
    }
}
