import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyListTest {
    private MyList<String> myList;

    @Before
    public void setUp() {
        myList = new MyList<>();
    }
    @Test
    public void methodAddShouldAddElementToTheArray() {
        String element = "Hello";

        myList.add(element);

        Assert.assertFalse(myList.isEmpty());
        Assert.assertTrue(myList.size() > 0);
        Assert.assertTrue(myList.contains(element));
    }

    @Test
    public void methodContainsShouldReturnTrueWhenElementIsPresents() {
        String element = "HELLO";
        myList.add(element);

        Assert.assertTrue(myList.contains(element));
    }

    @Test
    public void methodContainsShouldReturnFalseWhenElementIsAbsent() {
        Assert.assertFalse(myList.contains("smth"));
    }

    @Test
    public void methodClearShouldClearArray() {
        myList.add("Clear");

        myList.clear();

        Assert.assertTrue(myList.isEmpty());
    }

    @Test
    public void methodAddShouldAddElementByIndexToTheArray() {
        String expected = "Evgesha";
        myList.add("Hello");
        myList.add("Java");

        myList.add(1, expected);

        Assert.assertEquals(expected, myList.get(1));
    }

    @Test
    public void methodSetShouldChangeElementByIndexToTheArray() {
        String expected = "Hello";
        myList.add("World");
        myList.add("Java");
        int sizeBeforeSet = myList.size();

        myList.set(0, expected);

        Assert.assertEquals(expected, myList.get(0));
        Assert.assertEquals(sizeBeforeSet, myList.size());
    }

    @Test
    public void methodGetShouldReturnElementByIndex() {
        String expected = "Java";
        myList.add("Hello");
        myList.add("World");
        myList.set(1, expected);

        myList.get(1);

        Assert.assertEquals(expected, myList.get(1));
    }

    @Test
    public void methodIndexOfShouldReturnIndexOfElement() {
        String element = "Hello";
        String element2 = "World";
        myList.add(element);
        myList.add(element2);

        myList.indexOf(element);

        Assert.assertEquals(0, myList.indexOf(element));
        Assert.assertEquals(1, myList.indexOf(element2));
    }

    @Test
    public void methodRemoveShouldRemoveElementFromArray() {
        String element = "Hello";
        myList.add(element);

        myList.remove(element);

        Assert.assertFalse(myList.contains(element));
    }

    @Test
    public void methodLastIndexOfShouldReturnLastIndexOfElement() {
        String element = "Hello";
        myList.add(element);
        myList.add(element);

        myList.lastIndexOf(element);

        Assert.assertEquals(1, myList.lastIndexOf(element));
    }

    @Test
    public void methodIsEmptyShouldReturnTrueWhenArrayIsEmpty() {
        Assert.assertTrue(myList.isEmpty());
    }

    @Test
    public void methodIsEmptyShouldReturnFalseWhenArrayIsNotEmpty() {
        myList.add("element");

        Assert.assertFalse(myList.isEmpty());
    }
    @Test
    public void methodRemoveShouldRemoveElementByIndex(){
        myList.add("Hello");
        myList.add("Java");
        myList.indexOf("Hello");

        myList.remove(0);

        Assert.assertFalse(myList.contains("Hello"));
    }
}