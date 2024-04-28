package reflection.exercises.fields_introduction.init;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
//        printDeclaredFieldsInfo(Movie.class);
        printDeclaredFieldsInfo(Movie.MovieStats.class);
//        printDeclaredFieldsInfo(Category.class);
    }

    public static void printDeclaredFieldsInfo(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            System.out.printf(
                    "Field name : %s type : %s%n", field.getName(),
                            field.getType().getName());
            System.out.printf("Is synthetic field : %s%n", field.isSynthetic());

            System.out.println();
        }
    }

    public static class Movie extends Product {
        public static final double MINIMUM_PRICE = 10.99;

        private boolean isReleased;
        private Category category;
        private double actualPrice;

        public Movie(String name, int year, double price, boolean isReleased, Category category) {
            super(name, year);
            this.isReleased = isReleased;
            this.category = category;
            this.actualPrice = Math.max(price, MINIMUM_PRICE);
        }

        // Nested class
        public class MovieStats {
            private double timeWatched;

            public MovieStats(double timeWatched) {
                this.timeWatched = timeWatched;
            }

            public double getRevenue() {
                return timeWatched * actualPrice;
            }
        }
    }

    public static class Product {
        protected String name;
        protected int year;
        protected double actualPrice;

        public Product(String name, int year) {
            this.name = name;
            this.year = year;
        }
    }

    public enum Category {
        ADVENTURE,
        ACTION,
        COMEDY
    }
}
