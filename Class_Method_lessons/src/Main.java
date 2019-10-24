public class Main {
    public static void main(String[] args) {
        Book java = new Book();  // сссылка на классб тип переменной оператор присваивания "="
        System.out.println(java);
        Book cleanCode = new Book(); // 2 разный объекта которых объединяет только общий класс.
        Book forBegginers = new Book("Руководство для начинающих", "Герберт Шилдт");
        Book personal = new Book("Властелин колец", "Толкиен", false, true);
        //       java.title = "Философия Java"; // Для доступа к свойствам объекта нужно указать его имя, поставить точку. и указать свойство
//       cleanCode.title = "Чистый код"; // Доступ к приватному свойству и методу есть только внутри класа (между фигурных скобок класа)
//       java.auther = "Брюс Эккель";
//       cleanCode.auther = "Роберт Мартин";
//        вызов метода Сет тайтл для объекта джава.
        java.setTitle("Философия Джава");
        cleanCode.setTitle("Чистый код");
//        System.out.println(java.getTitle()); // выводим в консоль у объекта джава метод геттайтл.
//        System.out.println(cleanCode.getTitle());
        java.setAuther("Брюс Эккель");
        cleanCode.setAuther("Роберт Мартин");
        System.out.println(java.getAuther());
        System.out.println(cleanCode.getAuther());
        cleanCode.setIsforHome(true);
        java.setIsforHome(true);
//        System.out.println(java.isIsforHome());
//        System.out.println(cleanCode.isIsforHome());
//        System.out.println(personal);
//        System.out.println(java);
//        System.out.println(cleanCode);
//        System.out.println(forBegginers);
        Library library1 = new Library();
        library1.addBook(java);
//        System.out.println(library1);
        library1.addBook(cleanCode, personal, forBegginers);
        System.out.println(library1);
    }
}
