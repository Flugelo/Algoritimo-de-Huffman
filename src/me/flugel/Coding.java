package me.flugel;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Coding {
     private static Node nodes;

    //Onde criamos a arvore
    public static Node createTree(PriorityQueue<Node> nodePriorityQueue) {
        while (true) {
            Node poll = nodePriorityQueue.poll();
            Node poll1 = nodePriorityQueue.poll();

            Node parente = new Node(poll, poll1);

            if (nodePriorityQueue.isEmpty()) {
                return parente;
            }

            nodePriorityQueue.add(parente);
        }
    }

    //Pega a quantidade que uma Caracter aparece em uma String
    public static PriorityQueue<Node> amountFrenquence(String text) {
        char[] letras = new char[text.length()];
        text.getChars(0, text.length(), letras, 0);
        HashMap<Character, Node> filter = new HashMap<>();
        for (char letra : letras) {
            if (!filter.containsKey(letra)) {
                filter.put(letra, new Node(letra));

            } else filter.get(letra).add();


        }
        return new PriorityQueue<>(filter.values());
    }

    //Criando um MapCode
    public static HashMap<Character, String> mapCodeCreate(){
        HashMap<Character, String> r = new HashMap<>();
        nodes.fillMapCode(r, "");
        return r;
    }
    //Codificação do texto
    public static String code(String text){
        char[] caracters = text.toCharArray();
        nodes = createTree(amountFrenquence(text));
        HashMap<Character, String> characterStringHashMap = mapCodeCreate();

        StringBuilder textCoding = new StringBuilder();

        for (char caracter : caracters) {
            textCoding.append(characterStringHashMap.get(caracter));
        }
        return textCoding.toString();

    }
    //Decodificação do texto
    public static String decode(String code){
        Node node = nodes;

        StringBuilder r = new StringBuilder();

        for (char c : code.toCharArray()) {
            if(c == '0'){
                node = node.getL();
            }else{
                node = node.getR();
            }

            if(node.isLeave()){
                r.append(node.getCaracters());
                node = nodes;
            }
        }
        return r.toString();
    }
}
