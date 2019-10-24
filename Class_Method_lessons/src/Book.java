public class Book {
    // Свойтсва класса == поля == атрибуты//
    private String title; // null название по умолчанию для ссылочных типов.
    private String auther;// private - Доступ к свойству/методу есть тоолько изнутри класса.
    private boolean isforHome;
    private boolean availeble;
    private boolean takeHome;
    // метод, устанавливающий значение свойства title и auther

    // Методы устанавливающие значения называются сеетеры
// alt + ins вызов контекстной менюшки
    public void setTitle(String title) {
        //Войд не возвращает знаечения а только меняет переменную
//        this.title = title; // this - ссылка на текущий объект данного класа.
        // "" != пустая строка.
        if (title != null && !"".equals(title) ) { // в нормальном виде через регулярное значение.
            this.title = title;
        }
    }

    public void setAuther(String auther) {
        this.auther = auther;
        if (auther != null && !"".equals(auther) ) {
            this.auther = auther;
        }
    }

    public void setIsforHome(boolean isforHome) {
        this.isforHome = isforHome;
    }

    public void setAvaileble(boolean availeble) {
        this.availeble = availeble;
    }
    // Вв методах присвоения Войд - ретурн просто прекращает работу метода.
    // методы которые возвращают значения свойст - геттеры тоже alt + enter


    public String getTitle() {
        return title;// return прекращает работу метода и возвращает указанное значение.
    }

    public String getAuther() {
        return auther;
    }

    public boolean isIsforHome() {
        return isforHome;
    }

    public boolean isAvaileble() {
        return availeble;
    }

    public Book() {} // Нужно добавить если есть иной видимый конструктор
    public Book(String title, String auther){
        setTitle(title);
        setAuther(auther);
    }
    public Book(String title, String auther, boolean isforHome, boolean availeble){
        setTitle(title);
        setAuther(auther);
        setIsforHome(isforHome);
        setAvaileble(availeble);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", auther='" + auther + '\'' +
                ", isforHome=" + isforHome +
                ", availeble=" + availeble +
                '}';
    }

}