package control_structures;


public class Test {

    public static void main(String[] args) {

        Dogs gav1 = Dogs.Dalmatian;
        Dogs gav2 = Dogs.Retriever;

        long startTimeIF1 = System.nanoTime();
        IfElse.dogsWeight(gav1);
        long estimatedTimeIF1 = System.nanoTime() - startTimeIF1;

        long startTimeSC1 = System.nanoTime();
        IfElse.dogsWeight(gav1);
        long estimatedTimeSC1 = System.nanoTime() - startTimeSC1;

        long startTimeIF2 = System.nanoTime();
        IfElse.dogsWeight(gav2);
        long estimatedTimeIF2 = System.nanoTime() - startTimeIF2;

        long startTimeSC2 = System.nanoTime();
        IfElse.dogsWeight(gav2);
        long estimatedTimeSC2 = System.nanoTime() - startTimeSC2;

        if (estimatedTimeIF1 > estimatedTimeSC1) {
            System.out.println("Конструкция switch case работает быстрее " + estimatedTimeSC1 + " чем if else " + estimatedTimeIF1);
        }
        else {
            System.out.println("Конструкция if else работает быстрее " + estimatedTimeIF1 + " чем switch case " + estimatedTimeSC1);
        }
    }
}
