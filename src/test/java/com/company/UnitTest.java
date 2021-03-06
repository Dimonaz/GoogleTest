package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static com.company.GooglePage.*;


/**
 * Created by DimaN on 07.05.2015.
 */
public class UnitTest {

    @Before

    public void initialize(){

        open();

    }

    @After

    public void cleanUp () {

        clean();
    }

    @Test
    public void Test1() throws Exception {

        Assert.assertTrue(verifyIsEmpty(inputField));

    }

    @Test

    public void Test2(){

        Assert.assertEquals("Google Translate", getTitle());

    }

    @Test

    public void Test3()throws Exception{

        Assert.assertTrue(verifyPresent(inputField));
        Assert.assertTrue(verifyPresent(resultField));
        Assert.assertTrue(verifyPresent(translateButton));

    }

    @Test

    public void Test4(){

        Assert.assertTrue(verifyNotEditable(resultField));

    }

    @Test

    public void Test5(){

        Assert.assertTrue(verifyLanguagePresent(getLaunguages(), new String[]{"Greek", "Maltese", "Slovenian"}));
    }

    @Test

    public void Test6()throws Exception{

        setField(inputField, "Hello");
        Assert.assertTrue(verifyPresent(loudspeakerButton));

    }

    @Test

    public void Test7()throws Exception{

        setField(inputField, "Hello");
        Assert.assertTrue(verifyPresent(result));
        Assert.assertTrue(verifyIsNotEmpty(result));

    }

    @Test

    public void Test8()throws Exception{

        Assert.assertEquals("Hola!", getTranslation("English", "Spanish", "Hello!"));

    }

    @Test

    public void Test9()throws Exception{

        setField(inputField, "Hello");
        Assert.assertTrue(verifyPresent(result));
        clearInput();
        Assert.assertTrue(verifyIsEmpty(resultField));

    }
}