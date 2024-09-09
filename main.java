public class Main {
    public static void main(String[] args) throws Exception{
        heap<Integer> h = new heap<>();
        h.insert(5);
        h.insert(2);
        h.insert(20);
        h.insert(10);


//        System.out.println(h.remove());
//        System.out.println(h.remove());
//        System.out.println(h.remove());

        System.out.println(h.heapsort());
    }
}
