package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//341. Flatten Nested List Iterator
public class NestedIterator implements Iterator<Integer> {

    public interface NestedInteger {

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }


    List<Integer> data;
    int cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        cur = 0;
        data = new ArrayList<>();
        if(nestedList != null){
            flattern(nestedList);
        }
    }

    private void flattern(List<NestedInteger> nestedList){
        for(NestedInteger n: nestedList){
            if(n.isInteger()){
                data.add(n.getInteger());
            }else{
                flattern(n.getList());

            }
        }
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return data.get(cur++);
        }else{
            return null;
        }

    }

    @Override
    public boolean hasNext() {

        return cur < data.size();
    }
}
