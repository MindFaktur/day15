
class MyMapNode{

    int hashcode;
    String key;
    Integer value;
    MyMapNode next;

    MyMapNode(String key,Integer value){
        this.key = key;
        this.value = value;
        this.hashcode = key.hashCode();
        this.next = null;

    }

    public MyMapNode getNext() {
        return next;
    }

}

class AllOperations{

    int arraySize = 10;
    public final MyMapNode[] bucket = new MyMapNode[arraySize];

    Integer returnIndexValueOfHashcode(int hash){
        return Math.abs(hash % arraySize);
    }

    public void putMethod(String key, Integer val){

        Integer index = returnIndexValueOfHashcode(key.hashCode());

        if ( bucket[index] == null ){
            bucket[index] = new MyMapNode(key,val);
        }else if( bucket[index] != null ){
            MyMapNode temp = bucket[index];
            while ( temp.next != null ) {
                if (temp.key.equals(key)) {
                    int newVal = temp.value;
                    newVal++;
                    temp.value = newVal;
                    break;
                }else{
                    temp = temp.getNext();
                }

            }
            if (temp.key.equals(key)) {
                int newVal = temp.value;
                newVal++;
                temp.value = newVal;
            }else{
                temp.next = new MyMapNode(key,val);
            }
        }

    }

    Integer getValue(String key){
        Integer index = returnIndexValueOfHashcode(key.hashCode());
        MyMapNode temp = bucket[index];
        if ( temp.key.equals(key) ){
            return temp.value;
        }
        while( temp.next != null ){
            if ( temp.key.equals(key) ){
                return temp.value;
            }else{
                temp = temp.next;
            }
        }
        return temp.value;
    }

    void removeKeyValue(String key){
        Integer index = returnIndexValueOfHashcode(key.hashCode());
        MyMapNode temp = bucket[index];
        MyMapNode prev = temp;
        if ( temp.key.equals(key) && temp.next == null){
            bucket[index] = null;
        }
        else if( temp.key.equals(key) && temp.next != null ){

            MyMapNode temp1 = temp.next;
            temp = null;
            bucket[index] = temp1;

        }
        else {

            while( temp.next != null ) {
                if (temp.key.equals(key)) {
                    prev.next = temp.next;
                    temp = null;
                } else {
                    temp = temp.next;
                }
            }
        }
        prev.next = null;
        temp = null;
    }

    void printBucket(){
        for ( int i = 0; i < bucket.length; i++ ) {
            MyMapNode temp = bucket[i];
            if (temp != null) {
                while ( temp.next != null ) {
                    System.out.print(" key : " + temp.key + ", value : " + temp.value);
                    temp = temp.next;
                }
                System.out.println(" key : " + temp.key + ", value : " + temp.value);

            }else{
                System.out.println(" null ");
            }

        }
    }
}

public class HashTableProblem {

    public static void main(String[] args) {
        AllOperations allop = new AllOperations();
        String givenValue = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        String[] words = givenValue.split(" ",0);
        System.out.println(givenValue);
        for ( String str : words ) {
            allop.putMethod(str,1);
        }
        allop.printBucket();
        allop.removeKeyValue("avoidable");
        allop.printBucket();

    }
}