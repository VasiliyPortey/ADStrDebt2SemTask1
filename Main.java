import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int arrayLength = sc.nextInt();
        ArrayList<Integer> numbersArray = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++) {
            numbersArray.add(new Integer(randomEntering(-10, 10)));
        }
        System.out.println("Получившийся массив: ".concat(numbersArray.toString()));
        System.out.println("Отсортированный массив: ".concat(quickSort(numbersArray).toString()));
    }

    private static int randomEntering(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private static ArrayList<Integer> quickSort(ArrayList<Integer> numsArr) {
        if (numsArr.size() <= 1)
            return numsArr;
        int middle = numsArr.get(numsArr.size() / 2);
        ArrayList<Integer> leftNums = new ArrayList<>();
        ArrayList<Integer> middleNums = new ArrayList<>();
        ArrayList<Integer> rightNums = new ArrayList<>();
        for (int i = 0; i < numsArr.size(); i++) {
            if (numsArr.get(i) < middle)
                leftNums.add(new Integer(numsArr.get(i)));
            else if (numsArr.get(i) > middle)
                rightNums.add(new Integer(numsArr.get(i)));
            else
                middleNums.add(new Integer(numsArr.get(i)));
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(quickSort(leftNums));
        result.addAll(middleNums);
        result.addAll(quickSort(rightNums));
        return result;
    }
}