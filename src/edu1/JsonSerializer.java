package edu1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class JsonSerializer {
    public static List<Product> getProducts() throws IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader("Products.json");
        try (reader) {
            return gson.fromJson(
                    reader,
                    new TypeToken<List<Product>>() {
                    }.getType());
        }
    }

    public static List<ProductQuality> getProductQuality() throws IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader("ProductQuality.json");
        try (reader) {
            return gson.fromJson(
                    reader,
                    new TypeToken<List<ProductQuality>>() {
                    }.getType());
        }
    }
}
