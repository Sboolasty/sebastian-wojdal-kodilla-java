package com.kodilla.testing.collection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.*;
import javax.management.ListenerNotFoundException;
import java.util.*;
import com.kodilla.testing.collection.*;

public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test case: begin");
    }
    @After
    public void after(){
        System.out.println("Test case: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList() {
         //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> emptyList=new ArrayList<Integer>();
        Integer numberList[] = new Integer[]{};
        //When
        ArrayList<Integer> listNumbers=OddNumbersExterminator.exterminate(emptyList);
        //Then
        Assertions.assertTrue(exterminator.exterminate(emptyList).isEmpty());
    }
    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        ArrayList<Integer> list=new ArrayList<Integer>(Arrays.asList(234,567,22,899,12,15,3,5));
        ArrayList<Integer> oddList=new ArrayList<Integer>(Arrays.asList(234,22,12));

        //When
        ArrayList<Integer> listNumbers=OddNumbersExterminator.exterminate(list);
        //Then
        Assert.assertEquals(oddList,listNumbers);
    }
}