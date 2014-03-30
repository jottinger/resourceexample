package com.redhat.osas.resourceexample;

import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;

/**
 * User: jottinge
 * Date: 3/30/14
 * Time: 8:13 AM
 */
public class TestResources {
    @Test
    public void readRelative() {
        InputStream is = this.getClass().getResourceAsStream("packageexample.txt");
        Scanner scanner = new Scanner(is);
        String input = scanner.next();
        assertEquals(input, "local");
    }

    @Test
    public void readAbsolute() {
        InputStream is = this.getClass().getResourceAsStream("/absoluteexample.txt");
        Scanner scanner = new Scanner(is);
        String input = scanner.next();
        assertEquals(input, "absolute");
    }

}
