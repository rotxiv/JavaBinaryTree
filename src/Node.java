public class Node {
    
    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getValue() {
        return this.value;
    }
    
    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

/*--------------------------------------------------------------- */
    public static boolean tieneAlMenosUnHijo(Node currNode) {
        return currNode.leftChild != null || currNode.rightChild != null;
    }

    public static boolean tieneAmbosHijos(Node currNode) {
        return currNode.leftChild != null && currNode.rightChild != null;
    }

    public static boolean esPadreDeAmbos(Node currNode, int x, int y) {
        return (currNode.getLeftChild().getValue() == x && 
                currNode.getRightChild().getValue() == y) || 
                (currNode.getLeftChild().getValue() == y && 
                currNode.getRightChild().getValue() == x);
    }

}
