public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address = "Адрес неизвестен";

    //методы для заполнения полей билдером

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
//защитились от некорректных возрастов
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Вы ввели некорректные данные");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    //метод построения объекта из инициализированных полей
    public Person build() {
//защитились от ввода недостаточного количества данных для минимального заполнения объекта
        if (name == null || surname == null) {
            throw new IllegalStateException("Вы не ввели обязательные поля");
        }

        return new Person(name, surname, age, address);

    }
}
