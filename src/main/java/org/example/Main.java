package org.example;
/**Класс, тестирующий работу класса Injector
 * @author Дроздова Дария
 * */
public class Main {
    /**Точка входа в приложение**/
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        SomeBean sb = (new Injector()).inject(new SomeBean());
        sb.foo();
    }
}