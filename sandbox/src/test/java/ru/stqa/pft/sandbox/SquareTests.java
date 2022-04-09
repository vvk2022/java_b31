package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

    @Test
    public void testDistance1(){
        Point startPoint = new Point(10, 10);
        Point endPoint = new Point(15, 10);
        Assert.assertEquals(startPoint.distance(endPoint), 5.0);
    }

    @Test
    public void testDistance2(){
        Point startPoint = new Point(0, 0);
        Point endPoint = new Point(0, 0);
        Assert.assertEquals(startPoint.distance(endPoint), 0.0);
    }
}
