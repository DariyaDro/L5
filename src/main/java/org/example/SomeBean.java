package org.example;
/**Класс для проверки автоматической инициализации полей**/
class SomeBean {
    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface field2;
    public void foo(){
        field1.doSomething();
        field2.doSomething();
    }
}
