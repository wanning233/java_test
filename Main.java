
import java.util.*;

import static Demo.Main.getSum;

public class Main {
    public static void main(String[] args) {
        System.out.println("<-------第一题------->");
//TODO:在此编写第一题测试代码
        Book javaBook = new Book("Java Programming", "John Smith", 2022);
        javaBook.displayInfo();
        System.out.println("<-------第二题------->");
//TODO:在此编写第二题测试代码
        Car c = new Car("BMW", "black", 6);
        System.out.println(c);
        c.start();
        c.accelerate(60);
        c.brake();
        System.out.println("----------------------------");
        Truck t = new Truck("Benz", "white", 6, 6000);
        System.out.println(t);

        System.out.println("<-------第三题------->");
//TODO:在此编写第三题测试代码
        Calculator myCalculator = new Calculator();
        System.out.println("Addition: " + myCalculator.add(3.0, 2.0));
        System.out.println("Subtraction: " + myCalculator.subtract(5.0, 3.0));
        System.out.println("Multiplication: " + myCalculator.multiply(2.0, 5.0));
        System.out.println("Division: " + myCalculator.divide(10.0, 2.0));
        System.out.println(myCalculator.addB("13829579081298345918257", "438823897418920918472193"));
        System.out.println("<-------第四题------->");
//TODO:在此编写第四题测试代码
        System.out.println("最长公共前缀:" + longestCommonPrefix(new String[]{"abcd", "abs", "abipsd", "abook"}));

        System.out.println("<-------第五题------->");
//TODO:在此编写第五题测试代码
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("接水量为："+trap(height));
    }


    //第三题格式要求,在TODO部分实现代码
    public static String getSum(String a, String b) {
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        String c = "";
        for (int i = a.length() - 1; i >= 0; --i) {
            la.add(a.charAt(i) - '0');
        }
        for (int i = b.length() - 1; i >= 0; --i) {
            lb.add(b.charAt(i) - '0');
        }

        List<Integer> lc = new ArrayList<Integer>();
        int tmp = 0;
        int maxsize = Math.max(la.size(), lb.size());
        for (int i = 0; i < maxsize; i++) {
            if (i < la.size()) {
                tmp += la.get(i);
            }
            if (i < lb.size()) {
                tmp += lb.get(i);
            }
            lc.add(tmp % 10);
            tmp /= 10;
        }

        if (tmp > 0)
            lc.add(tmp % 10);
        for (int i = lc.size() - 1; i >= 0; i--) {
            c += lc.get(i);
        }
        return c;
    }

    //第四题格式要求
    public static String longestCommonPrefix(String[] strs) {
        //https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    //第五题格式要求
    public static int trap(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

}
class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
    }
}

class Vehicle {
    String brand;
    String color;
    int speed;
    int wheels;


    public Vehicle(int wheels, String brand, String color) {
        this.wheels = wheels;
        this.brand = brand;
        this.color = color;
        this.speed = 0;
    }
}

class Car extends Vehicle {

    int loader;

    public Car(String brand, String color, int loader) {
        super(4, brand, color);
        this.loader = loader;
    }

    public void start() {
        System.out.println("Car is started");
    }

    public void accelerate(int speed) {
        this.speed += speed;
        System.out.println("Car is accelerating at speed " + this.speed + " km/h");
    }

    public void brake() {
        System.out.println("Car is braking");
    }

    @Override
    public String toString() {
        return "车轮的个数是：" + wheels + " 车的颜色是：" + color + " 车的速度是：" + speed
                + "\n这是一辆小车，能载6人，实载" + loader + "人"
                + (loader > 6 ? ",你超员了!" : "");
    }
}

class Truck extends Vehicle {
    int loader;
    double payload;

    public Truck(String brand, String color, int loader, double payload) {
        super(6, brand, color);
        this.loader = loader;
        this.payload = payload;
    }

    public void start() {
        System.out.println("Truck is started");
    }

    public void accelerate(int speed) {
        this.speed += speed;
        System.out.println("Truck is accelerating at speed " + this.speed + " km/h");
    }

    public void brake() {
        System.out.println("Truck is braking");
    }

    @Override
    public String toString() {
        return "车轮的个数是：" + wheels + " 车的颜色是：" + color + " 车的速度是：" + speed
                + "\n这是一辆小车，能载6人，实载" + loader + "人"
                + (loader > 3 ? ",你超员了!" : "")
                + "\n这是一辆卡车，核载5000kg，你已装载" + payload + "kg"
                + (payload > 5000 ? ",你超载了!" : "");
    }
}
class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public String addB(String a, String b) {
        return getSum(a, b);
    }

    public double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Cannot divide by zero");
            return Double.NaN;
        }
    }
}


