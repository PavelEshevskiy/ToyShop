package ver3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PresenterImpl implements Presenter {
    private List<Toy> toys;

    public PresenterImpl() {
        toys = new ArrayList<>();
    }

    @Override
    public void addNewToy(int id, String name, int quantity, double weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }

    @Override
    public void updateToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    @Override
    public void organizeToyRaffle(String filePath) {
        List<Toy> raffleToys = new ArrayList<>();

        for (Toy toy : toys) {
            int numRaffleToys = (int) (toy.getWeight() / 100 * 100); // игрушки выбираются на основе веса (частоты выпадения)
            for (int i = 0; i < numRaffleToys; i++) {
                raffleToys.add(toy);
            }
        }

        // Выбираем случайную игрушку из списка
        Random random = new Random();
        Toy winningToy = raffleToys.get(random.nextInt(raffleToys.size()));

        // Запись результата розыгрыша в файл
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Победила игрушка:\n");
            writer.write("ID: " + winningToy.getId() + "\n");
            writer.write("Название: " + winningToy.getName() + "\n");
            writer.write("Количество: " + winningToy.getQuantity() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}