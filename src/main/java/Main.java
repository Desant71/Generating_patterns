public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Любовь")
                .setSurname("Филякина")
                .setAge(53)
                .setAddress("с.Никитское")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Никитa")
                .setSurname("Филякин")
                .setAge(28)
                .build();

        son.happyBirthday();
        son.setAddress("г.Тула");

        System.out.println("У " + mom + " есть сын, " + son);

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