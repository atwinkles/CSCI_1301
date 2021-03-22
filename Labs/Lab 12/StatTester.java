/*
* StatTester.java
* Author: Alexander Winkles
* Submission Date: April 12, 2017
*
* Purpose: A Java application used to test the Stat class
* with various example cases.
* 
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither 
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/

public class StatTester {

    public static void main(String[] args) {

    System.out.println("Example 1\n");

    double[] data = {-5.3,2.5,88.9,0,0.0,28,16.5,88.9,109.5,-90,88.9};
    double[] data2 = {100.34, 50.01, 50.01, -8};
    Stat stat1 = new Stat();

    System.out.println("stat1 data = " + stat1.toString());

    stat1 = new Stat(data);

    System.out.println("stat1 has been altered.");
    System.out.println("stat1 data = " + stat1.toString());

    System.out.println("stat1 min = " + stat1.min());
    System.out.println("stat1 max = " + stat1.max());
    System.out.println("stat1 average = " + stat1.average());
    System.out.println("stat1 mode = " + stat1.mode() + "\n");

    Stat stat2 = new Stat();
    stat2.setData(data2);
    Stat stat3 = new Stat(stat1.getData());
    
    System.out.println("stat2 data = " + stat2.toString());
    System.out.println("stat3 data = " + stat3.toString());
    System.out.println();
    System.out.println("stat1 is equal to stat2 using \"equals()\"?" + stat1.equals(stat2));
    System.out.println("stat1 is equal to stat3 using \"equals()\"?" + stat1.equals(stat3));
    System.out.println("stat1 is equal to stat2 using \"==\"?" + (stat1 == stat3));

    System.out.println("\nExample 2\n");

    double[] data3 = {10.0,20.0,30.0};
    stat1.setData(data3);

    data3[0] = 100.0;
    data3[1] = 200.0;
    data3[2] = 300.0;

    stat2.setData(data3);

    System.out.println("stat1 data = " + stat1.toString());
    System.out.println("stat2 data = " + stat2.toString());
    System.out.println("The two arrays should be diferent");
    
    System.out.println("\nExample 3\n");

    double[] data4 = {10.0,20.0,30.0};
    stat1.setData(data4);
    
    double[] data5 = stat1.getData();

    System.out.println("The arrays are identical: "  + (data4 == data5));

    System.out.println("\nExample 4\n");

    double[] data6 = {10.0,20.0,30.0};
    stat1.setData(data6);
    stat2.setData(data6);
    double[] data7 = stat1.getData();

    System.out.println("The arrays are identical: " + (data6 == data7));
    System.out.println("stat2 equals stat1: " + stat2.equals(stat1));
    System.out.println("stat1 equals stat2: " + stat2.equals(stat1));

    System.out.println("\nExample 5\n");

    Stat stat4 = new Stat();
    System.out.println("stat1 data = " + stat4.toString());
    System.out.println("stat1 min = " + stat4.min());
    System.out.println("stat1 max = " + stat4.max());
    System.out.println("stat1 average = " + stat4.average());
    System.out.println("stat1 mode = " + stat4.mode());
    System.out.println("stat1 data = " + stat4.toString());

    System.out.println("\nExample 6\n");

    double[] data8 = {1,2,2,3,3,4};
    Stat stat5 = new Stat(data8);

    System.out.println("stat1 data = " + stat5.toString());
    System.out.println("stat1 min = " + stat5.min());
    System.out.println("stat1 max = " + stat5.max());
    System.out.println("stat1 average = " + stat5.average());
    System.out.println("stat1 mode = " + stat5.mode());
    System.out.println("stat1 data = " + stat5.toString());

    System.out.println("\nExample7\n");

    double[] data9 = {1};
    Stat stat6 = new Stat(data9);
    Stat stat7 = new Stat(data9);

    System.out.println("stat1 data = " + stat6.toString());
    System.out.println("stat1 min = " + stat6.min());
    System.out.println("stat1 max = " + stat6.max());
    System.out.println("stat1 average = " + stat6.average());
    System.out.println("stat1 mode = " + stat6.mode());
    System.out.println("stat1 data = " + stat6.toString());
    System.out.println("stat6.equals(stat5)?" + stat6.equals(stat5));
    System.out.println("stat6.equals(stat7)?" + stat6.equals(stat7));
    System.out.println("stat7 == stat6? " + (stat7 == stat6));

    }
}
