package org.example;
import java.lang.reflect.*;
import java.io.*;
import java.util.Properties;

import static java.lang.Class.forName;

/**Класс, который осуществляет внедрение зависимостей в любой объект, который содержит поля, помеченные аннотацией**/
public class Injector {
    /**Метод, который принимает в
    качестве параметра объект любого класса и с помощью рефлексии осуществляет поиск полей, помеченных
    этой аннотацией и осуществляе инициализацию этих полей
    экземплярами классов, которые указаны в качестве реализации
    соответствующего интерфейса в некотором файле
    настроек(properites)**/
    public <T> T inject(T obj) throws ClassNotFoundException, IllegalAccessException {

        File file = new File("C:\\I\\java\\L5\\src\\main\\resources\\config.properties");
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(AutoInjectable.class) && field.getType() == SomeInterface.class) {
                try {
                    Object someObject = null;
                    Class<?> clazz = Class.forName(properties.getProperty("SomeInterface"));
                    someObject = clazz.newInstance();
                    field.set(obj, someObject);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (field.isAnnotationPresent(AutoInjectable.class) && field.getType() == SomeOtherInterface.class) {
                try {
                    Object someObject = null;
                    Class<?> clazz = Class.forName(properties.getProperty("SomeOtherInterface"));
                    someObject = clazz.newInstance();
                    field.set(obj, someObject);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    }




