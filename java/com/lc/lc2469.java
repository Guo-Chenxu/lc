package lc;

/**
 * @program: exercise
 * @description: lc2469
 * @author: 郭晨旭
 * @create: 2023-03-21 12:23
 * @version: 1.0
 **/
public class lc2469 {
    public double[] convertTemperature(double celsius) {
        celsius = (int) celsius * 100000;
        double[] res = new double[2];
        res[0] = (celsius + 273.15 * 100000) / (100000.0);
        res[1] = (celsius * 1.8 + 3200000) / (100000.0);
        return res;
    }
}
