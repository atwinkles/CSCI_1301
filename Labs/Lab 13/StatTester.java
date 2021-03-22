public class StatTester {

    public static void main(String[] args) {
    
        double[] data1 = {};
        Stat stat1 = new Stat(data1);
        System.out.println("stat1 data = " + stat1.toString());
        System.out.println("stat1 min = " + stat1.min());
        System.out.println("stat1 max = " + stat1.max());
        System.out.println("stat1 average = " + stat1.average());
        System.out.println("stat1 mode = " + stat1.mode());
        System.out.println("stat1 variance = " + stat1.variance());
        System.out.println("stat1 standard deviation = " + stat1.standardDeviation());
        System.out.println("stat1 is empty = " + stat1.isEmpty() + "\n");

        double[] data2 = {1,2,3,4,5,6,7,8,9};
        stat1.setData(data2);
        System.out.println("stat1 data = " + stat1.toString());
        System.out.println("stat1 min = " + stat1.min());
        System.out.println("stat1 max = " + stat1.max());
        System.out.println("stat1 average = " + stat1.average());
        System.out.println("stat1 mode = " + stat1.mode());
        System.out.println("stat1 variance = " + stat1.variance());
        System.out.println("stat1 standard deviation = " + stat1.standardDeviation());
        System.out.println("stat1 is empty = " + stat1.isEmpty() + "\n");

        stat1.reset();
        System.out.println("stat1 data = " + stat1.toString());
        System.out.println("stat1 min = " + stat1.min());
        System.out.println("stat1 max = " + stat1.max());
        System.out.println("stat1 average = " + stat1.average());
        System.out.println("stat1 mode = " + stat1.mode());
        System.out.println("stat1 variance = " + stat1.variance());
        System.out.println("stat1 standard deviation = " + stat1.standardDeviation());
        System.out.println("stat1 is empty = " + stat1.isEmpty() + "\n");

        float[] data3 = {10.0F,10.0F};
        stat1.setData(data3);
        System.out.println("stat1 data = " + stat1.toString());
        System.out.println("stat1 min = " + stat1.min());
        System.out.println("stat1 max = " + stat1.max());
        System.out.println("stat1 average = " + stat1.average());
        System.out.println("stat1 mode = " + stat1.mode());
        System.out.println("stat1 variance = " + stat1.variance());
        System.out.println("stat1 standard deviation = " + stat1.standardDeviation());
        System.out.println("stat1 is empty = " + stat1.isEmpty() + "\n");

        long[] data4 = {80L,60L};
        stat1.append(data4);
        System.out.println("stat1 data = " + stat1.toString());
        System.out.println("stat1 min = " + stat1.min());
        System.out.println("stat1 max = " + stat1.max());
        System.out.println("stat1 average = " + stat1.average());
        System.out.println("stat1 mode = " + stat1.mode());
        System.out.println("stat1 variance = " + stat1.variance());
        System.out.println("stat1 standard deviation = " + stat1.standardDeviation());
        System.out.println("stat1 is empty = " + stat1.isEmpty() + "\n");

        double[] data5 = {-5.3,2.5,88.9,0,0.0,28,16.5,88.9,109.5,-90,88.9};
        stat1.reset();

        System.out.println("stat1 data = " + stat1.toString());

        stat1.append(data5);
        System.out.println("stat1 data = " + stat1.toString());
        System.out.println("stat1 min = " + stat1.min());
        System.out.println("stat1 max = " + stat1.max());
        System.out.println("stat1 average = " + stat1.average());
        System.out.println("stat1 mode = " + stat1.mode());
        System.out.println("stat1 variance = " + stat1.variance());
        System.out.println("stat1 standard deviation = " + stat1.standardDeviation());
        System.out.println("stat1 is empty = " + stat1.isEmpty() + "\n");

        double[] data6 = {50.0,60.0};
        float[] data7 = {70.0F,80.0F};
        int[] data8 = {90,100};
        long[] data9 = {100L,110L};

        stat1.reset();
        System.out.println("stat1 data = " + stat1.toString());
        stat1.setData(data6);
        System.out.println("stat1 data = " + stat1.toString());
        stat1.setData(data7);
        System.out.println("stat1 data = " + stat1.toString());
        stat1.setData(data8);
        System.out.println("stat1 data = " + stat1.toString());
        stat1.setData(data9);
        System.out.println("stat1 data = " + stat1.toString());
        data1 = null;
        stat1.setData(data1);
        System.out.println("stat1 data = " + stat1.toString());
    
        stat1.reset();
        System.out.println("stat1 data = " + stat1.toString());
        stat1.append(data6);
        System.out.println("stat1 data = " + stat1.toString());
        stat1.append(data7);
        System.out.println("stat1 data = " + stat1.toString());
        stat1.append(data8);
        System.out.println("stat1 data = " + stat1.toString());
        stat1.append(data9);
        System.out.println("stat1 data = " + stat1.toString());
        stat1.append(data1);
        System.out.println("stat1 data = " + stat1.toString());
        System.out.println("stat1 min = " + stat1.min());
        System.out.println("stat1 max = " + stat1.max());
        System.out.println("stat1 average = " + stat1.average());
        System.out.println("stat1 mode = " + stat1.mode());
        System.out.println("stat1 variance = " + stat1.variance());
        System.out.println("stat1 standard deviation = " + stat1.standardDeviation());
        System.out.println("stat1 is empty = " + stat1.isEmpty() + "\n");

        

    }

}
