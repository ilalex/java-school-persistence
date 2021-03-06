package com.digdes.school.serialization;

import java.io.*;

/**
 * Simple use of standard serialization
 * <p>
 * Usage examples you can find in {@link com.digdes.school.serialization.JavaSerializationTest}
 *
 * @author Ilya Ashikhmin (ashikhmin.ilya@gmail.com)
 */
@SuppressWarnings("JavadocReference")
public class JavaSerialization implements Marshaller {

    public void saveObject(Object obj, String fileName) throws IOException {
        File file = new File(fileName);
        if (file.exists())
            System.out.println(String.format("WARN: File [%s] exists. Overwriting it.", fileName));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(obj);
        } catch (IOException ioe) {
            //noinspection ResultOfMethodCallIgnored
            file.delete();
            throw ioe;
        }
    }

    public <T> T loadObject(String fileName, Class<T> klass) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println(String.format("WARN: File [%s] not exists. Returning null.", fileName));
            return null;
        }

        Object obj = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            obj = ois.readObject();
        }

        return (T) obj;
    }
}
