import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BinarySearchTree {
    
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }
    public Node getRoot() {
        return root;
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
        inOrden(root, inOrden);
        return inOrden;
    }

    private void inOrden(Node currNode, List<Integer> inOrden) {
        if (currNode != null) {
            inOrden(currNode.getLeftChild(), inOrden);
            inOrden.add(currNode.getValue());
            inOrden(currNode.getRightChild(), inOrden);
        }
    }

    public List<Integer> postOrden() {
        List<Integer> postOrden = new ArrayList<>();
        postOrden(root, postOrden);
        return postOrden;
    }

    private void postOrden(Node currNode, List<Integer> postOrden) {
        if (currNode != null) {
            postOrden(currNode.getLeftChild(), postOrden);
            postOrden(currNode.getRightChild(), postOrden);
            postOrden.add(currNode.getValue());

        }
    }

    public List<Integer> preOrden() {
        List<Integer> preOrden = new ArrayList<>();
        preOrden(root, preOrden);
        return preOrden;
    }

    private void preOrden(Node currNode, List<Integer> preOrden) {
        if (currNode != null) {
            preOrden.add(currNode.getValue());
            preOrden(currNode.getLeftChild(), preOrden);
            preOrden(currNode.getRightChild(), preOrden);

        }
    }
    
    @Override
    public String toString() {
        return "";
    }

/*--------------------------------------------------------------------- */
/*  Funcion que cuenta la cantidad de numeros primos que hay en el arbol */
    public int contarPrimos() {
        return contarPrimos(root);
    }

    private int contarPrimos(Node currNode) {
        if (currNode == null) {
            return 0;
        }
        else {
            if (esPrimo(currNode.getValue())) {
                return 1 + contarPrimos(currNode.getLeftChild()) + 
                    contarPrimos(currNode.getRightChild());
            }
            else {
                return contarPrimos(currNode.getLeftChild()) + 
                    contarPrimos(currNode.getRightChild());
            }
        }
    }

    private boolean esPrimo(int value) {
        for (int i = 2; i < value / 2; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

/*  Funcion que retorna la altura del arbol */
    public int altura() {
        return altura(root);
    }

    private int altura(Node currNode) {
        if (currNode == null) {
            return 0;
        }
        return 1 + Math.max(altura(currNode.getLeftChild()), 
                altura(currNode.getRightChild()));
    }

/*  Funcion que retorna true o false si dado un valor existe o no en el arbol */
    public boolean existe(int val) {
        return existe(root, val);
    }

    private boolean existe(Node currNode, int val) {
        if (currNode == null) {
            return false;
        }
        else {
            if (val == currNode.getValue()) {
                return true;
            }
            else {
                return existe(currNode.getLeftChild(),val) || 
                    existe(currNode.getRightChild(), val);
            }
        }
    }

/*   Funcion que retorna un lista con los valores del arbol que son pares*/
    public List<Integer> mostrarPares() {
        List<Integer> pares = new ArrayList<>();
        mostrarPares(root, pares);
        return pares;
    }

    private void mostrarPares(Node currNode, List<Integer> pares) {
        if (currNode != null) {
            mostrarPares(currNode.getLeftChild(), pares);
            if (currNode.getValue() % 2 == 0) {
                pares.add(currNode.getValue());
            }
            mostrarPares(currNode.getRightChild(), pares);
        }
    }

/*  mostrar los elementos mayores a un elemento dado  */
    public List<Integer> mostrarMayores(int value) {
        List<Integer> mayores = new ArrayList<>();
        mostrarMayores(root, mayores, value);
        return mayores;
    }

    private void mostrarMayores(Node currNode, List<Integer> mayores, int value) {
        if (currNode != null) {
            mostrarMayores(currNode.getLeftChild(), mayores, value);
            if (value < currNode.getValue()) {
                mayores.add(currNode.getValue());
            }
            mostrarMayores(currNode.getRightChild(), mayores, value);
        }
    }

/*  Mostrar los valores de los nodos que son padres */
    public List<Integer> sonPadres() {
        List<Integer> sonPadres = new ArrayList<>();
        sonPadres(root, sonPadres);
        return sonPadres;
    }

    private void sonPadres(Node currNode, List<Integer> sonPadres) {
        if (currNode != null) {
            sonPadres(currNode.getLeftChild(), sonPadres);
            if (!isLeaf(currNode)) {
                sonPadres.add(currNode.getValue());
            }
            sonPadres(currNode.getRightChild(), sonPadres);
        }
    }

/*  Funcion que retorna true o false si dos valores dados son hermanos */
    public AtomicBoolean sonHermanos(int x, int y) {
        AtomicBoolean flag = new AtomicBoolean(false);
        sonHermanos(root, x, y, flag);
        return flag;
    }

    private void sonHermanos(Node currNode, int x, int y, AtomicBoolean flag) {
        if (currNode != null && Node.tieneAmbosHijos(currNode)) {
            if ((currNode.getLeftChild().getValue() == x && 
                currNode.getRightChild().getValue() == y) || 
                (currNode.getLeftChild().getValue() == y && 
                currNode.getRightChild().getValue() == x)) {
                flag.set(true);
            }
            sonHermanos(currNode.getLeftChild(), x, y, flag);
            sonHermanos(currNode.getRightChild(), x, y, flag);
        }
    }
    public boolean sonHermanosV2(int x, int y) {
        return sonHermanosV2(root, x, y);
    }

    private boolean sonHermanosV2(Node currNode, int x, int y) {
        if (currNode == null) {
            return false;
        }
        else {
            if (Node.tieneAmbosHijos(currNode) && Node.esPadreDeAmbos(currNode, x, y)) {
                return true;
            }
            boolean leftFlag = sonHermanosV2(currNode.getLeftChild(), x, y);
            boolean rightflag = sonHermanosV2(currNode.getRightChild(), x, y);
            return (leftFlag || rightflag) ? true : false;
        }
    }

/*  funcion que retorna el valor del nodo padre de un valor dado */
    public int devolverPadre(int value) {
        return devolverPadre(root, value, null);
    }

    public int devolverPadre(Node currNode, int value, Node fatherNode) {
        if (currNode == null) {
            return ;
        }
        else {
            if (value == currNode.getValue()) {
                return fatherNode.getValue();
            }
            else {
                int leftF = devolverPadre(currNode.getLeftChild(), value, currNode);
                int rightF = devolverPadre(currNode.getRightChild(), value, currNode);
            }
        }
    }

/*  funcion que retorna la cantidad de nodos que no tienen ambos hijos */
    public int cantidadIncompletos() {
        return cantidadIncompletos(root);
    }

    private int cantidadIncompletos(Node currNode) {
        if (currNode == null) {
            return 0;
        }
        else {
            if (Node.tieneAlMenosUnHijo(currNode)) {
                return 1 + cantidadIncompletos(currNode.getLeftChild()) +
                    cantidadIncompletos(currNode.getRightChild());
            }
            else {
                return cantidadIncompletos(currNode.getLeftChild()) +
                cantidadIncompletos(currNode.getRightChild()); 
            }
        }
    }


}
