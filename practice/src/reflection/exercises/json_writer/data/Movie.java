package reflection.exercises.json_writer.data;

public class Movie {
    private final String name;
    private final float rating;
    private final String [] categories;
    private final Actor[] actors;
    private final String [][] test;

    public Movie(String name, float rating, String[] categories, Actor[] actors, String[][] test) {
        this.name = name;
        this.rating = rating;
        this.categories = categories;
        this.actors = actors;
        this.test = test;
    }
}
