public class App {
    public static void main(String[] args) throws Exception {
        Node myNode = new Node(10);
        myNode.setLeftChild(new Node(5));
        myNode.setRightChild(new Node(15));
        System.out.println("El nodo actal es : " + myNode.getValue());
        System.out.println("El hijo izquierdo es : " 
                        + myNode.getLeftChild().getValue());
        System.out.println("El hijo derecho es : " 
                        + myNode.getRightChild().getValue());
    }
}
