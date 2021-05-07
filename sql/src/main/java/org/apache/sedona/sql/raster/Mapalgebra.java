package org.apache.sedona.sql.raster;


import java.text.DecimalFormat;
import java.util.Arrays;

public class Mapalgebra {

    public Mapalgebra() {}

    private double[] localoperation1(double[] b1, double[] b2)
    {
        double[] result = new double[b1.length];
        DecimalFormat f = new DecimalFormat("##.00");

        for(int i=0; i<result.length; i++)
        {

            if(b1[i]==0.0 && b2[i]==0.0)
            {
                b1[i] = b2[i] = -1;
            }

            double temp = (b2[i] - b1[i])/(b1[i] + b2[i]);
            result[i] = (double)Math.round(temp*100)/100;

        }
        return result;
    }

    public double[] ndvi(double[] band1, double[] band2)
    {
        return localoperation1(band1, band2);
    }
    public double mean(double[] band1)
    {
        return Arrays.stream(band1).sum()/band1.length;
    }





}
