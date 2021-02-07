package com.arvin.bat;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class BraveBrowserTest {

    @Test
    public void testGetUrls() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BraveBrowser browser = new BraveBrowser("");
        Method getUrls = BraveBrowser.class.getDeclaredMethod("getUrls");
        boolean origAccessible = getUrls.isAccessible();
        getUrls.setAccessible(true);
        List<String> urls = (List<String>) getUrls.invoke(browser);
        getUrls.setAccessible(origAccessible);
        assert urls != null && urls.size() > 0 && urls.size() < 3092;
    }
}
