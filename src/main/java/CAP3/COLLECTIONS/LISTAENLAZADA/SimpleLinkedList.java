package CAP3.COLLECTIONS.LISTAENLAZADA;


import java.util.function.BooleanSupplier;

@FunctionalInterface
interface GetObjectNode{
    Node node(Object dato);
}

public class SimpleLinkedList {
    private Node first;


    public SimpleLinkedList(){
        this.first = null;
    }

    public void push(Object obj){
        GetObjectNode getObjectNode = Node::new;
        Node node = getObjectNode.node(obj);
        node.setNext(this.first);
        this.first = node;
        System.out.println("******" + this.first.value() +" - "+node.value());
    }

    public Node pop(){
        Node temp = this.first;
        this.first = this.first.next();

        return temp;
    }

    public Node delete(Object val){
        System.out.println("here " + this.first.value());
        Node currentNode = this.first;
        Node previousNodse = this.first;

        while(!currentNode.value().equals(val)){
            if(currentNode.next() == null){
                return null;
            }else{
                previousNodse = currentNode;
                currentNode = currentNode.next();
            }
        }

        if(currentNode == this.first){
            this.first = this.first.next();
        }else{
            System.out.println("here");
            previousNodse.setNext(currentNode.next());
        }
        return currentNode;
    }

    public void printContent(){
        Node currentNode = first;

        System.out.println("Mostrar Elementos de la lista enlazada");
        while(currentNode != null){
            currentNode.showContent();
            currentNode = currentNode.next();
        }
    }

    public boolean isEmpty(){
        BooleanSupplier isEmpty = ()-> this.first == null;
        return isEmpty.getAsBoolean();
    }

    public Node contains(Object val){
        Node currentNode = this.first;
        Node finalCurrentNode = currentNode;
        BooleanSupplier isNull = ()-> finalCurrentNode.next() == null;

        while(!currentNode.value().equals(val)){
            if(isNull.getAsBoolean()){
                return null;
            }else{
                currentNode = currentNode.next();
            }
        }

        return currentNode;
    }

    public Node insert(Object value, Object newValue){
        Node newNode = new Node(newValue);
        Node currentNode = this.first;

        while(!currentNode.value().equals(value)){
            if(currentNode.next() == null){
                return null;
            }else{
                currentNode = currentNode.next();
            }

        }

        newNode.setNext(currentNode.next());
        currentNode.setNext(newNode);
        return newNode;
    }


}
