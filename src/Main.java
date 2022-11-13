import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Домашнее задание 1 (Задание 1):");
        Product bananas = new Product("Бананы", 150.0, 2);
        Product garnet = new Product("Гранат", 200.0, 3);
        Product cabbage = new Product("Капуста", 50.0, 6);
        Product zucchini = new Product("Кабачки", 80.0, 5);
        Product oranges = new Product("Апельсины", 100.0, 5);
        Product mandarins = new Product("Мандарины", 80.0, 3);

        List<Product> products = new ArrayList<>();
        products.add(cabbage);
        products.add(bananas);
        products.add(garnet);
        products.add(zucchini);
        checkList(products);

        System.out.println();
        System.out.println("Домашнее задание 2 (Задание 1):");
        Recipes recipe1 = new Recipes("Рецепт коктейля 1 ");
        recipe1.addProduct(bananas,garnet,oranges);
        Recipes recipe2 = new Recipes("Рецепт коктейля 2 ");
        recipe2.addProduct(bananas,garnet,oranges);
        Recipes recipe3 = new Recipes("Рецепт коктейля 3 ");
        recipe3.addProduct(bananas,mandarins,zucchini);

        List<Recipes> recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        checkRecipes(recipes);

        System.out.println();
        System.out.println("Домашнее задание 2 (Задание 2):");
        Set<Integer> list = new HashSet<>();
        for (int i=0; i < 20 ; i++) {
            list.add((int)Math.round(Math.random()*1000));
        }
        list.removeIf(i -> i % 2 != 0);
        System.out.println(list);
    }

    public static void checkList(List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            Product e1 = products.get(i);
            if (e1.getPrice() == 0 || e1.getWeight() == 0 || e1.getName().equals("Default")){
                throw new RuntimeException("Заполните карточку товара полностью");
            }
            for (int j = 0; j < products.size(); j++) {
                if (i == j) continue;
                Product e2 = products.get(j);
                if (e1.equals(e2)) {
                    throw new RuntimeException(products.get(i) + " Рецепт уже существует!");
                }
            }
            System.out.println(e1);
        }
    }

    public static void checkRecipes(List<Recipes> recipes) {
        for (int i = 0; i < recipes.size(); i++) {
            Recipes e1 = recipes.get(i);
            for (int j = 0; j < recipes.size(); j++) {
                if (i == j) continue;
                Recipes e2 = recipes.get(j);
                if (e1.equals(e2)) {
                    throw new RuntimeException(recipes.get(i) + " уже же существует.");
                }
            }
            System.out.println(e1);
        }
    }
}