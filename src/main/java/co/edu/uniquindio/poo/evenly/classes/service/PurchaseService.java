package co.edu.uniquindio.poo.evenly.classes.service;

import co.edu.uniquindio.poo.evenly.classes.model.Purchase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PurchaseService {

    private final String PATH =
            "src/main/resources/co/edu/uniquindio/poo/evenly/purchase.json";

    private final Gson gson =
            new GsonBuilder().setPrettyPrinting().create();

    public void savePurchase(Purchase purchase) {

        List<Purchase> purchases = getPurchases();

        purchases.add(purchase);

        saveJson(purchases);
    }

    public List<Purchase> getPurchases() {

        try (FileReader reader = new FileReader(PATH)) {

            Type type = new TypeToken<List<Purchase>>() {}.getType();

            List<Purchase> purchases = gson.fromJson(reader, type);

            return purchases != null ? purchases : new ArrayList<>();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void saveJson(List<Purchase> purchases) {

        try (FileWriter writer = new FileWriter(PATH)) {
            gson.toJson(purchases, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}