package collections.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionInterfaces {
    
    // 배열
    @Test
    @DisplayName("배열")
    public void array() {
        String[] names = {"matthew", "marin", "phillip"};
        assertEquals("marin", names[1]);
    }

    // iterable forEach
    @Test
    @DisplayName("iterable")
    public void iterable() {
        Iterable<String> iter = Arrays.asList("matthew", "marin", "phillip");
        iter.forEach(System.out::println);
    }


    // collection
    @Test
    @DisplayName("Collection")
    public void collection() {
        Collection<String> collection = new ArrayList<>();
        collection.add("matthew");
        assertTrue(collection.contains("matthew"));
        assertFalse(collection.contains("john"));
    }

    // List
    @Test
    @DisplayName("list")
    public void list() {
        var names = new ArrayList<String>();
        names.addAll(List.of("matthew", "tomas", "minjun"));
        assertEquals("minjun", names.get(2));
    }

    // Set
    @Test
    @DisplayName("set")
    public void set() {
        var coupons = new HashSet<>(List.of("matthew", "tomas", "minjun", "matthew"));
        assertEquals(3, coupons.size());
    }

    // Map
    @Test
    @DisplayName("map")
    public void map() {
        Map<String, String> persons = new HashMap<>();
        persons.put("a101", "matthew");
        persons.put("a102", "tomas");
        assertEquals("tomas", persons.get("a102"));
    }
}
