package FIT;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Node{
    public Node next = null;
    public String data;

    public Node(String data) {
        this.data = data;
    }

    public void addNode(String data){
        Node newNode = new Node(data);
        Node current = this;

        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public Node deleteNode(Node head, String data){
        Node current = head;

        if (current.data.equals(data)) {
            return current.next;
        }

        while(current.next != null){
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }
        return head;
    }

    public List<String> printNodes(){
        Node current = this;
        List<String> list = new ArrayList<>();
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }

        return list;
    }

    public void createCycle(Node targetNode) {
        Node current = this;

        // Traverse to the end of the list
        while (current.next != null) {
            current = current.next;
        }

        // Point the last node to the target node to create a cycle

        current.next = targetNode;

    }
}

public class FitGlobant {

    public static void main(String[] args) {
        Node node = new Node("A");
        node.addNode("B");
        node.addNode("C");
        node.addNode("B");
        node.addNode("E");
        node.addNode("F");

        //node.createCycle(node);

        Map<String, Long> map = node.printNodes().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);


        map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .peek(System.out::println)
                .forEach(i -> node.deleteNode(node, i));
        System.out.println(node.printNodes());
       String val  = node.printNodes().get((node.printNodes().size() - 1) / 2);
       node.deleteNode(node, val);
        System.out.println(node.printNodes());

        Node slow = node;
        Node fast = node;
        while(fast != null && fast.next != null) {
            System.out.println("...");
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                System.out.println("Loop detected" + slow.data);
                break;
            }
        }

        Stream.iterate(new char[]{'A'}, j -> new char[]{(char) (j[0] + 1)})
                .limit(26)
                .forEach(System.out::println);







        //node.deleteNode(node, "C");
        //node.printNodes();
    }

}


