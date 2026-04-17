import java.util.HashMap;

public class HashBenchmark {

    static final int N = 100000;

    // Baseline Insert + Lookup
    static void baselineTest() {
        long start = System.nanoTime();

        HashMap<Integer, Integer> map = new HashMap<>();

        // Insert
        for (int i = 0; i < N; i++) {
            map.put(i, i);
        }

        // Lookup
        for (int i = 0; i < N; i++) {
            map.get(i);
        }

        long end = System.nanoTime();
        System.out.println("Baseline (Insert + Lookup): " + (end - start) + " ns");
    }

    // Collision Stress Test
    static void collisionTest() {
        long start = System.nanoTime();

        HashMap<Integer, Integer> map = new HashMap<>();
        int tableSize = 1000;

        // Force collisions
        for (int i = 0; i < N; i++) {
            int key = i * tableSize;
            map.put(key, i);
        }

        // Lookup
        for (int i = 0; i < N; i++) {
            int key = i * tableSize;
            map.get(key);
        }

        long end = System.nanoTime();
        System.out.println("Collision Test: " + (end - start) + " ns");
    }

    static void highLoadTest() {

        long start = System.nanoTime();

        HashMap<Integer, Integer> map = new HashMap<>(16);

        for (int i = 0; i < N; i++) {
            map.put(i, i);
        }

        for (int i = 0; i < N; i++) {
            map.get(i);
        }

        long end = System.nanoTime();
        System.out.println("High Load Factor Test: " + (end - start) + " ns");

    }

    static void insertDeleteTest() {

        long start = System.nanoTime();

        HashMap<Integer, Integer> map = new HashMap<>();

        // Insert
        for (int i = 0; i < N; i++) {
            map.put(i, i);
        }

        // Mixed operations
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                map.remove(i);
            } else {
                map.get(i);
            }
        }

        long end = System.nanoTime();
        System.out.println("Insert/Delete Test: " + (end - start) + " ns");

    }

    static void resizeTest() {

        long start = System.nanoTime();

        HashMap<Integer, Integer> map = new HashMap<>(4);

        for (int i = 0; i < N; i++) {
            map.put(i, i);
        }

        long end = System.nanoTime();
        System.out.println("Resize Test: " + (end - start) + " ns");

    }

    // Driver for benchmark
    public static void main(String[] args) {
        System.out.println("Running Hash Table Benchmarks...\n");

        baselineTest();
        collisionTest();
        highLoadTest();
        insertDeleteTest();
        resizeTest();
    }
}
