
public class Main {
    public static void main(String[] args) {
        Twit system = new Twit();

        User dima = new User("Дима", 10);
        User stas = new User("Стас", 11);
        User vlad = new User("Влад", 12);
        User ira = new User("Ира", 13);
        User vera = new User("Вера", 14);
        User nasty = new User("Настя", 15);

        system.registration(dima);
        system.registration(stas);
        system.registration(vlad);
        system.registration(ira);
        system.registration(vera);
        system.registration(nasty);


        dima.add(new Comment("Первый нах!"));
        stas.add(new Comment("Второй!"));
        vlad.add(new Comment("Третий!"));
        vera.add(new Comment("Хаха. Расчет дураков окончен!"));

        nasty.add("Fuck you1", "Первый нах!");
        vlad.add("Fuck you!", "Второй!");
        dima.add(".!.", "Fuck you!");
        dima.like(".!.");
        stas.like("Хаха. Расчет дураков окончен!");
        system.board();

    }
}
