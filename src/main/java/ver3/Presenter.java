package ver3;

public interface Presenter {
    void addNewToy(int id, String name, int quantity, double weight);
    void updateToyWeight(int id, double weight);
    void organizeToyRaffle(String filePath);
}