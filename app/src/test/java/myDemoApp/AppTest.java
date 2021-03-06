/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package myDemoApp;

import org.junit.jupiter.api.Test;

//import jdk.internal.jline.internal.TestAccessible;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;


class AppTest {

    @Test
    public void correctPrefix()
    {
      ArrayList<String> prefixList = new ArrayList<>(Arrays.asList("Aurelian", "Ali", "Semer", "Ka", "W"));
      ArrayList<String> fullStrings = new ArrayList<>(Arrays.asList("Aurelianus", "Aliye", "Semerkant", "Kara", "Worlds"));    
        assertEquals("aurelian", App.findPrefix(prefixList, fullStrings, 8));
        assertEquals("ali", App.findPrefix(prefixList, fullStrings, 3));
        assertEquals("semer", App.findPrefix(prefixList, fullStrings, 5));
        assertEquals("ka", App.findPrefix(prefixList, fullStrings, 2));
        assertEquals("w", App.findPrefix(prefixList, fullStrings, 1));
    }

    @Test
    public void longerPrefix()
    {
      ArrayList<String> prefixList = new ArrayList<>(Arrays.asList("asdasdasd", "asdasdasdasdasdasd", "asdasd", "asdasdasdasda", "asdasdasd"));
      ArrayList<String> fullStrings = new ArrayList<>(Arrays.asList("asd", "asdadasd", "zxc", "asd", "vbn"));    
        assertEquals("Required prefix cannot be found.", App.findPrefix(prefixList, fullStrings, 8));
    }

    @Test 
    public void falseNum()
    {
      ArrayList<String> prefixList = new ArrayList<>(Arrays.asList("Aurelian", "Ali", "Semer", "Ka", "W"));
      ArrayList<String> fullStrings = new ArrayList<>(Arrays.asList("Aurelianus", "Aliye", "Semerkant", "Kara", "Worlds"));   
      assertEquals("Required prefix cannot be found.", App.findPrefix(prefixList, fullStrings, 9));
      assertEquals("Required prefix cannot be found.", App.findPrefix(prefixList, fullStrings, 0));
      assertEquals("Required prefix cannot be found.", App.findPrefix(prefixList, fullStrings, 10));
    }

    @Test 
    public void emptyArrayList()
    {
      ArrayList<String> prefixList = new ArrayList<>();
      ArrayList<String> fullStrings = new ArrayList<>(Arrays.asList("Aurelianus", "Aliye", "Semerkant", "Kara", "Worlds"));
      assertEquals("Either of word lists are empty.", App.findPrefix(prefixList, fullStrings, 8));
      prefixList = new ArrayList<>(Arrays.asList("Aurelian", "Ali", "Semer", "Ka", "W"));
      fullStrings = new ArrayList<>();
      assertEquals("Either of word lists are empty.", App.findPrefix(prefixList, fullStrings, 8));
    }
 
}
