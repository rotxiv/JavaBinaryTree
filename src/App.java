public class App {
    public static void main(String[] args) throws Exception {
        
        BinarySearchTree treeOne = new BinarySearchTree();

        treeOne.insertIterative(20);
        treeOne.insertIterative(5);
        treeOne.insertIterative(35);
        treeOne.insertIterative(10);
        treeOne.insertIterative(30);
        treeOne.insertIterative(32);
        treeOne.insertRecursive(9);
        treeOne.insertRecursive(12);
        treeOne.insertRecursive(3);
        treeOne.insertRecursive(37);
        System.out.println("----------------------------------------");
        System.out.println("los elementos del arbol en inOrden son : " + treeOne.inOrden());
        System.out.println("los elementos del arbol en postOrden son : " + treeOne.postOrden());
        System.out.println("los elementos del arbol en preOrden son : " + treeOne.preOrden());
    
        System.out.println("----------------------------------------");
        System.out.println("El valor de la raiz es : " + treeOne.getRoot().getValue());
        System.out.println("El valor del hijo izquierdo de la raiz es : " + treeOne.getRoot().getLeftChild().getValue());
        System.out.println("El valor del hijo derecho de la raiz es : " + treeOne.getRoot().getRightChild().getValue());
    
        System.out.println("------------------------------------------");
        System.out.println("La cantidad de valores primos en el arbol es : " + treeOne.contarPrimos());

        System.out.println("------------------------------------------");
        System.out.println("La altura actual del arbol es : " + treeOne.altura());
        System.out.println("------------------------------------------");
        System.out.println("Existe el valor 32 en el arbol? " + treeOne.existe(32));
        System.out.println("Existe el valor 11 en el arbol? " + treeOne.existe(11));
        System.out.println("------------------------------------------");
        System.out.println("Los valores pares del arbol son : " + treeOne.mostrarPares());
        System.out.println("------------------------------------------");
        System.out.println("Los elementos mayores al valor 12 son : " + treeOne.mostrarMayores(12));
        System.out.println("-------------------------------------------");
        System.out.println("Los valores que son padres son : " + treeOne.sonPadres());
        System.out.println("-------------------------------------------");
        System.out.println("Los valores 3 y 10 son hermanos? " + treeOne.sonHermanos(3, 10));
        System.out.println("-------------------------------------------");
        System.out.println("Los valores 30 y 10 son hermanos? " + treeOne.sonHermanos(30, 10));
        System.out.println("-------------------------------------------");
        System.out.println("Los valores 9 y 12 son hermanos? version 2 " + treeOne.sonHermanosV2(9, 12));
        System.out.println("-------------------------------------------");
        System.out.println("Los valores 37 y 32 son hermanos? version 2 " + treeOne.sonHermanosV2(37, 32));
        
        //System.out.println("La cantidad de nodos que no tienen ambos hijos son : " + treeOne.cantidadIncompletos());
    }
}
