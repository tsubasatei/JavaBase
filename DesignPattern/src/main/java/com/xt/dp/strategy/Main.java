package com.xt.dp.strategy;

/**
 * @author xt
 * @Desc
 */
public class Main {
    public static void main(String[] args) {
        Sort<Dog> dogSort = new Sort<>();
        Dog dog1 = new Dog(1);
        Dog dog2 = new Dog(5);
        Dog dog3 = new Dog(3);
        Dog[] dogs = {dog1, dog2, dog3};
        DogFoodComparator dogFoodComparator = new DogFoodComparator();
        dogSort.sort(dogs, dogFoodComparator);
        for (int i = 0; i < dogs.length; i++) {
            System.out.println(dogs[i]);
        }

        System.out.println("================");

        Sort<Cat> catSort = new Sort<>();
        Cat cat1 = new Cat(1, 1);
        Cat cat2 = new Cat(5, 5);
        Cat cat3 = new Cat(3, 3);
        Cat[] cats = {cat1, cat2, cat3};
        CatHeightComparator catHeightComparator = new CatHeightComparator();
        CatWeightComparator catWeightComparator = new CatWeightComparator();
        catSort.sort(cats, catHeightComparator);
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }
        System.out.println("---------------");
        catSort.sort(cats, catWeightComparator);
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }
    }
}
