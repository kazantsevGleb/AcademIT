package vector_main;

import ru.academits.kazantsev.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new double[]{1, 2, 3, 4, 5});
        System.out.println(vector1);

        System.out.println(vector1.getSize());

        Vector vector2 = new Vector(3, new double[]{1.4, 2, 5.2, 6.2, 10, 11});

        System.out.println(vector2);

        vector1 = new Vector(5);
        System.out.println(vector1);

        vector1.setComponents(new double[]{1, 2, 3, 4, 10});

        System.out.println(vector1);
    }
}
