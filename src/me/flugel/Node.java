package me.flugel;

import java.util.HashMap;

//Para fazer a comparação da Lista prioritaria, necessita de implementear um Comparable.
public class Node implements Comparable<Node> {
    //Aqui é minha POO de node, onde o caracter e salvo e sua quantia;
    private char caracters;
    private int amout;


    private Node l;
    private Node r;

    //Contructor para adição do caracter na POO
    public Node(char caracters){
        this.caracters = caracters;
        this.amout = 1;
    }
    //Contructor para adição das "folhas" da arvore binaria
    public Node(Node l, Node r){
        this.caracters = '+';
        this.l = l;
        this.r = r;
    }

    //Isso faz uma verificação se existe alguma coisa no lado esquerdo e direito da arvore
    public boolean isLeave(){
        return l == null && r == null;
    }
    //metodo para adicionar a quantia de caracter
    public void add(){
        this.amout = amout + 1;
    }
    //Pega o caracters
    public char getCaracters() {
        return caracters;
    }
    //pega a quantidade
    public int getAmout() {
        return amout;
    }
    //pega o Node do lado Lefht
    public Node getL() {
        return l;
    }
    //Pega o node do lado Right
    public Node getR() {
        return r;
    }

    //Pra ser sincero isso so foi add para tirar o erro do Comparable
    @Override
    public int compareTo(Node o) {
        return 0;
    }

    public void setCaracters(char caracters) {
        this.caracters = caracters;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }

    public void setL(Node l) {
        this.l = l;
    }

    public void setR(Node r) {
        this.r = r;
    }

    public void fillMapCode(HashMap<Character, String> mapCode, String w) {
        if (isLeave()) {
            mapCode.put(getCaracters(), w);
            return;
        }
        l.fillMapCode(mapCode, w + "0");
        r.fillMapCode(mapCode, w + "1");
    }


}
