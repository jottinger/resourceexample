package com.redhat.osas.resourceexample;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * User: jottinge
 * Date: 3/30/14
 * Time: 8:13 AM
 */
public class TestResources {
    @Test
    public void readRelative() {
        InputStream is = this.getClass().getResourceAsStream("packageexample.txt");
        assertNotNull(is);
        Scanner scanner = new Scanner(is);
        String input = scanner.next();
        assertEquals(input, "local");
    }

    @Test
    public void readAbsolute() {
        InputStream is = this.getClass().getResourceAsStream("/absoluteexample.txt");
        assertNotNull(is);
        Scanner scanner = new Scanner(is);
        String input = scanner.next();
        assertEquals(input, "absolute");
    }

    @Test
    public void readProperty() throws IOException {
        InputStream is = this.getClass().getResourceAsStream("/configexample.properties");
        assertNotNull(is);
Properties properties=new Properties();
        properties.load(is);
        assertEquals(properties.getProperty("foo"), "bar");
        assertEquals(properties.getProperty("baz"), "bletch");
        assertEquals(properties.getProperty("quux"), "snafu");
    }


}
