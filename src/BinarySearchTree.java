import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

/*  Metodo insertar de forma iterativa */
    public void insertIterative(int value) {
        if (root == null) {
            root = new Node(value);
        }
        else {
            Node currNode = root;
            Node prNode = null;
            while (currNode != null) {
                prNode = currNode;
                int currNodeValue = currNode.getValue();
                if (value < currNodeValue) {
                    currNode = currNode.getLeftChild();
                }
                else if (value == currNodeValue) {
                    return;
                }
                else {
                    currNode = currNode.getRightChild();
                }
            }
            if (value < prNode.getValue()) {
                prNode.setLeftChild(new Node(value));
            }
            else {
                prNode.setRightChild(new Node(value));
            }
        }
    }

/*  Metodo insertar de forma recursiva */
    public void insertRecursive(int value) {
        if (root == null) {
            root = new Node(value);
        }
        else {
            insertRecursive(root, value);
        }
    }

    private void insertRecursive(Node currNode, int value) {
        if (value > currNode.getValue()) {
            if (currNode.getRightChild() == null) {
                currNode.setRightChild(new Node(value));
            }
            else {
                insertRecursive(currNode.getRightChild(), value);
            }
        }
        else {
            if (currNode.getLeftChild() == null) {
                currNode.setLeftChild(new Node(value));
            }
            else {
                insertRecursive(currNode.getLeftChild(), value);
            }
        }
    }
/*  Metodo que retorna true o false si el nodo es o no una hoja del arbol */
    private boolean isLeaf(Node currNode) {
        return currNode.getLeftChild() == null && currNode.getRightChild() == null;
    }

    public List<Integer> inOrden() {
        List<Integer> inOrden = new ArrayList<>();
        inOrden(root,inOrden);
        return inOrden;
    }

    private void inOrden(Node currNode, List<Integer> inOrden) {
        
    }

}
