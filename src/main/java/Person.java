import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private int age = -1;
    private String address;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();

        return child
                .setSurname(this.surname);
    }

    public boolean hasAddress() {
        return !this.address.equals("Адресс неизвестен");
    }

    public void setAddress(String city) {
        this.address = city;
    }

    public String getAddress() {
        return address;
    }


    public void happyBirthday() {
        if (hasAge()) {
            age++;
        } else {
            System.out.println("Мы не знаем сколько человеку лет");
        }
    }

    public boolean hasAge() {
        return age >= 0 && age <= 120;
    }

    public int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        String ageForString;

        if (hasAge()) {
            ageForString = String.valueOf(age);
        } else {
            ageForString = "возраст неизвестен";
        }

        return  name + " " + surname + " " + ageForString + " года ," + " из " + address;
    }

    @Override
    public int hashCode() {
        int hash = 27;

        if (name != null) {
            hash += name.hashCode();
        }
        if (surname != null) {
            hash += surname.hashCode();
        }

        if (age == -1 && address.equals("адресс неизвестен")) {
            return hash;
        } else if (!hasAge()) {
            return hash + address.hashCode();
        } else if (!hasAddress()) {
            return hash + age;
        }
        return hash + age + address.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Person otherPerson = (Person) obj;

        return Objects.equals(name, otherPerson.getName()) &&
                Objects.equals(surname, otherPerson.getSurname()) &&
                age == otherPerson.getAge() &&
                Objects.equals(address, otherPerson.getAddress());
    }
}
