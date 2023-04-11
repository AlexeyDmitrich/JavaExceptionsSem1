package ru.geekbrains.kamenev;

import java.util.Arrays;
import java.util.Random;

public class Main {
static Random rnd = new Random();
    public static void main(String[] args) {
        System.out.println("Задача 1");
        demo1();
        System.out.println("=================================================");
        System.out.println();
        System.out.println("Задача 2");
        demo2();
    }

    /**
     * Задача 1 (основная)
     * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     * и возвращающий новый массив, каждый элемент которого равен разности элементов
     * двух входящих массивов в той же ячейке.
     * Если длины массивов не равны, необходимо как-то оповестить пользователя.
     */
    private static void demo1() {
        for (int i = 1; i <= 10; i++) {     // выполняем метод sumArr на 10 парах случайных массивов
            System.out.println();
            System.out.printf("Проход %d \n", i);
            int[] arr1 = genarr();
            int[] arr2 = genarr();
            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
            try {
                int[] arrRes = sumArr(arr1, arr2);
                System.out.println(Arrays.toString(arrRes));
            } catch (NotEqualArrayLengthException e) {      // Наше исключение ловим и показываем пользователю
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     *  Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     *  и возвращающий новый массив, каждый элемент которого равен частному элементов
     *  двух входящих массивов в той же ячейке.
     *  Если длины массивов не равны, необходимо как-то оповестить пользователя.
     *  Важно: При выполнении метода единственное исключение,
     *  которое пользователь может увидеть - RuntimeException, т.е. ваше.
     */
    private static void demo2() {
        for (int i = 0; i <= 10; i++) {     // выполняем метод sumArr на 10 парах случайных массивов
            System.out.println();
            System.out.printf("Проход %d \n", i);
            int[] arr1 = genarr();
            int[] arr2 = genarr();
            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
            try {
                double[] arrRes = divArr(arr1, arr2);   // теоретически мы можем получить там какое-то исключение
                System.out.println(Arrays.toString(arrRes));
            } catch (NotEqualArrayLengthException e) {      // Наше исключение ловим и показываем пользователю
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * метод для генерации случайного массива
     * @return возвращает массив случайных целых чисел
     */
    public static int[] genarr(){
        int xLength = rnd.nextInt(12-9)+9;  // длина массива от 9 до 11
        int[] res= new int[xLength];
        for (int i = 0; i < res.length; i++) {
            res[i] = rnd.nextInt(16+5)-5;   // генерируемые числа для примера взяты от 5 до 20
        }
        return res;
    }

    /**
     * Метод вычисления поэлементной разности.
     * На вход принимает два равных по длине массива, заполненных целыми числами:
     * @param arr1
     * @param arr2
     * @return возвращает массив целых чисел
     */
    public static int[] sumArr (int[] arr1, int[] arr2){
        if (arr1.length == arr2.length) {       // логика метода выполнится только в том случае, если длины массивов равны
            try {
                int[] res = new int[arr1.length];
                for (int i = 0; i < arr1.length; i++) {
                    res[i] = arr1[i] - arr2[i];
                }
                return res;
            } catch (Exception e){
                throw new AnyException("Произошло какое-то исключение, но Вы увидите только моё");
            }
        }
        else throw new NotEqualArrayLengthException("Длинны массивов не равны");    // если длины массивов не равны - бросаем исключение
    }

    public static double[] divArr (int[] arr1, int[] arr2){
        if (arr1.length == arr2.length) {       // логика метода выполнится только в том случае, если длины массивов равны
            double[] res = new double[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                res[i] = (double) arr1[i]/arr2[i];
            }
            return res;
        }
        else throw new NotEqualArrayLengthException("Длинны массивов не равны");    // если длины массивов не равны - бросаем исключение
    }
}