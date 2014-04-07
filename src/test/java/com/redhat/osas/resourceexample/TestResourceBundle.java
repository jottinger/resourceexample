package com.redhat.osas.resourceexample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.testng.Assert.assertEquals;

public class TestResourceBundle {
    @DataProvider
    Object[][] getData() {
        return new Object[][] {
                {Locale.ENGLISH, "absolute", "default"},
                {Locale.GERMAN, "absolut", "deutsch"},
        };
    }
    @Test(dataProvider = "getData")
    public void loadResourceBundleAbsolute(Locale locale, String location, String localetext) {
        ResourceBundle r=ResourceBundle.getBundle("AbsoluteBundle", locale);
        assertEquals(r.getString("location"), location);
        assertEquals(r.getString("locale"), localetext);
    }

    @Test
    public void loadDefaultResourceBundleAbsolute() {
        ResourceBundle r=ResourceBundle.getBundle("AbsoluteBundle");
        assertEquals(r.getString("location"), "absolute");
        assertEquals(r.getString("locale"), "default");
    }
}
