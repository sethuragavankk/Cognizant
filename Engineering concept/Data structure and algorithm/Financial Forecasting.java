public class Main {
    public static double forecast(double currentValue,double growthRate,int years) {
        if (years == 0) {
            return currentValue;
        }
        return forecast(currentValue * (1 + growthRate),growthRate, years - 1);
    }
    public static void main(String[] args) {

        double presentValue = 1000;
        double growthRate = 0.10; // 10% sample
        int years = 3;
        double futureValue =forecast(presentValue, growthRate, years);
        System.out.println("Future Value = " + futureValue);
    }
}