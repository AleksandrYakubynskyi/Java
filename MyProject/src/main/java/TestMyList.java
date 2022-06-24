public class TestMyList {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();

        myList.add("hello");
        myList.add("sasha");
        myList.remove(1);
        System.out.println(myList);
        System.out.println(myList.indexOf("sasha"));

    }
}
