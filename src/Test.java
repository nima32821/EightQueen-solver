public class Test
{
    public static void main(String[] args) {

        long time1 = System.currentTimeMillis();
        Solver.solver();
        Solver.printAll();
        System.out.println("Response time: " + (System.currentTimeMillis() - time1) + "ms");
    }
}
