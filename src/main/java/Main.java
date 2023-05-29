public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Юлия")
                .setSurname("Филякина")
                .setAge(30)
                .setAddress("г.Одоев")
                .build();

        Person daughter = mom.newChildBuilder()
                .setName("Милена")
                .setAge(2)
                .build();

        daughter.happyBirthday();
        daughter.setAddress("г.Тула");

        System.out.println("У " + mom + " есть дочь, " + daughter);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-1).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}