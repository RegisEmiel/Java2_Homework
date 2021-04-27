package Homework_5;

public class Homework_5 {
    static final int SIZE = 10000000;
    static final int h = SIZE / 2;

    static float[] arr = new float[SIZE];

    static float[] a1 = new float[h];
    static float[] a2 = new float[h];

    public static void main(String[] args) {
        for(int i = 0; i < SIZE; i++)
            arr[i] = 1;

        // Один поток
        long a = System.currentTimeMillis();
        calc1();
        System.out.print("Время обработки одним потоком: ");
        System.out.println(System.currentTimeMillis() - a);

        for(int i = 0; i < SIZE; i++)
            arr[i] = 1;

        // Два потока
        a = System.currentTimeMillis();
        try {
            calc2();
        }
        catch(Exception ignored) {}
        System.out.print("Время обработки двумя потоками: ");
        System.out.println(System.currentTimeMillis() - a);
    }

    private static void calc1() {
        for(int i = 0; i < SIZE; i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
    }

    private static void calc2() throws InterruptedException {
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < h; i++)
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        });

        Thread thread2 = new Thread(() -> {
            int i_h = 0;

            for(int i = 0; i < h; i++) {
                i_h = i + h;
                a2[i] = (float) (a2[i] * Math.sin(0.2f + i_h/5) * Math.cos(0.2f + i_h/5) * Math.cos(0.4f + i_h/2));
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
    }
}
