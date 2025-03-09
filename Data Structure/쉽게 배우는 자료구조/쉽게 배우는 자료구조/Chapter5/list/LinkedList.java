package list;

public class LinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int numItems;

    public LinkedList(){
        numItems =0;
        head= new Node<>(null,null); //더미헤드드
    }

    //알고리즘 5-10 구현: 연결 리스트에 원소 x삽입하기
    public void add(int index, E item){
        if(index >= 0 && index<=numItems){
            Node<E> prevNode= getNode(index-1);
            Node<E> newNode= new Node<>(item,prevNode.next);
            prevNode.next = newNode;
            numItems++;
        }
    }

    public void append(E item){
        Node<E> prevNode=head; //더미노드
        while(prevNode.next!=null){
            prevNode=prevNode.next;
        }
        Node<E> newNode = new Node<>(item,null);
        prevNode.next=newNode;
        numItems++;
    }

    //알고리즘 5-12 구현: 리스트에 원소 삭제제하기
    public E remove(int index){
        if(index >= 0 && index< numItems){
            Node<E> prevNode= getNode(index-1);
            Node<E> currNode= prevNode.next;
            prevNode.next = currNode.next;
            numItems--;
            return currNode.item;
        }
        else{
            return null;
        }
    }

    public boolean removeItem(E x){
        Node<E> currNode=head; //더미헤드드
        Node<E> prevNode;
        for(int i=0;i<numItems;i++){
            prevNode = currNode;
            currNode = currNode.next;
            if(((Comparable)(currNode.item)).compareTo(x)==0){
                prevNode.next=currNode.next;
                numItems--;
                return true;
            }
        }
        return false; //Not found
    }

    //알고리즘 5-13 구현: 연결 리스트의 k번째 원소 알려주기
    public E get(int index){
        if(index>=0 && index<=numItems -1){
            return getNode(index).item;
        }
        else{
            return null; //에러
        }
    }

    public Node<E> getNode(int index){
        if(index>=-1 && index<=numItems -1){
            Node<E> currNode = head;
            for(int i=0; i<=index; i++){
                currNode = currNode.next;
            }
            return currNode;
        }
        else{
            return null;
        }
    }

    //알고리즘 5-14 구현: 연결 리스트의 k번째 원소를 x로 대체하기
    public void set(int index, E x){
        if(index>=0 && index<=numItems-1){
            getNode(index).item=x;
        }
    }

    //알고리즘 5-15 구현: 원소 x가 연결 리스트의 몇 번째 원소인지 알려주기
    public final int NOT_FOUND=-12345;
    public int indexOf(E x){
        Node<E> currNode = head;
        int i;
        for(i=0;i<numItems;i++){
            currNode=currNode.next;
            if(((Comparable)(currNode.item)).compareTo(x)==0){
                return i;
            }
        }
        return NOT_FOUND;
    }
    
    //알고리즘 5-16(1) 구현: 리스트의 총 원소 수 알려주기
    public int len(){
        return numItems;
    }

    //알고리즘 5-16(2) 구현: 리스트의 비었는지지 알려주기
    public boolean isEmpty(){
        return numItems==0;
    }

    //알고리즘 5-16(3) 구현: 리스트비우기
    public void clear(){
        numItems=0;
        head=new Node<>(null,null);
    }

}
