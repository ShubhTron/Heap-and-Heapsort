import java.util.ArrayList;
import java.util.List;
public class heap<T extends Comparable<T>> {
    private ArrayList<T> list;
    public heap(){
        list = new ArrayList<>();
    }
    private void swap(int first, int sec){
        T temp = list.get(first);
        list.set(first , list.get(sec));
        list.set(sec , temp);

    }
    private int parent(int index){
        return (index - 1)/2;
    }

    private int left(int index){
        return index * 2 + 1;
    }
    private int right(int index){
        return index * 2 + 2;
    }

    public void insert(T value){
        list.add(value);
        upheap(list.size() - 1);
    }

    public void upheap(int index){
        if(index == 0){
            return;
        }
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p)) < 0){
            swap(index, p);
        }
        upheap(p);
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("NOT COOL");
        }

        T temp = list.get(0);

        T last = list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }
    public void downheap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);

        if(left < list.size() && list.get(left).compareTo(list.get(min)) < 0){
            min = left;
        }
        if(right < list.size() && list.get(right).compareTo(list.get(min)) < 0){
            min = right;
        }

        if(min != index){
            swap(min, index);
            downheap(min);
        }
    }
    public ArrayList<T> heapsort() throws Exception{
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()){
            data.add(this.remove());
        }
        return data;
    }
}
