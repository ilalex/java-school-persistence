package com.digdes.school.serialization;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.NotSerializableException;
import java.util.Date;

/**
 * Test for java serialization
 *
 * @author Ilya Ashikhmin (ashikhmin.ilya@gmail.com)
 */
public class JavaSerializationTest extends AbstractSerializationTest {

    @Before
    public void setUp() {
        fileName = "pojo.bin";
        marshaller = new JavaSerialization();
    }

    @Test(expected = NotSerializableException.class)
    public void testForgotInterfaceDeclaration() throws IOException {
        class NoSerializable {
            String someStr;
        }
        NoSerializable ns = new NoSerializable();
        ns.someStr = "test";

        marshaller.saveObject(ns, fileName);
    }

    @Test
    public void testSavingAndLoading() throws IOException, ClassNotFoundException {
        SimplePojo pojo = buildPojo();
        marshaller.saveObject(pojo, fileName);
        SimplePojo loaded = marshaller.loadObject(fileName, SimplePojo.class);
        Assert.assertNotNull(loaded);
        Assert.assertNull(loaded.getSkipSaving());
        Assert.assertEquals(pojo, loaded);
    }
}


