package ver3;

public class Main {
    public static void main(String[] args) {
        Presenter presenter = new PresenterImpl();

        // Добавление новых игрушек
        presenter.addNewToy(1, "Мяч", 10, 30);
        presenter.addNewToy(2, "Кукла", 5, 25);
        presenter.addNewToy(3, "Машинка", 7, 45);

        // Изменение веса (частоты выпадения) игрушки
        presenter.updateToyWeight(2, 50);

        // Розыгрыш игрушек с записью результата в файл
        presenter.organizeToyRaffle("результат_розыгрыша.txt");
    }
}