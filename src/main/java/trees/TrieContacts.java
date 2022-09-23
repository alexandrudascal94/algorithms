package trees;

import java.util.ArrayList;
import java.util.List;

class TrieContacts {

    public static class Trie {
        public ArrayList<Trie> nodes = new ArrayList<>();
        public char value;
        public int wordCount = 0;
    }

    public static List<Integer> contacts(List<List<String>> queries) {
        List<Integer> result = new ArrayList<>();
        Trie contacts = new Trie();

        if (queries == null || queries.isEmpty()) {
            return result;
        }

        for (List<String> query : queries) {
            String operation = query.get(0);
            String name = query.get(1);

            if (operation.toLowerCase().equals("add")) {
                addName(name, contacts);
            } else if (operation.toLowerCase().equals("find")) {
                result.add(findName(name, contacts));
            }
        }
        return result;
    }

    private static void addName(String name, Trie contacts) {
        char[] letters = name.toCharArray();

        addLetter(contacts, letters, 0);

    }

    private static void addLetter(Trie nodes, char[] letters, int i) {
        if (i >= letters.length) {
            return;
        }

        Trie foundNode = null;
        for (Trie node : nodes.nodes) {
            if (node.value == letters[i]) {
                foundNode = node;
                break;
            }
        }

        if (foundNode != null) {
            foundNode.wordCount++;
            addLetter(foundNode, letters, i + 1);
        } else {
            Trie newNode = new Trie();
            newNode.value = letters[i];
            nodes.nodes.add(newNode);
            newNode.wordCount++;
            addLetter(newNode, letters, i + 1);
        }
    }

    private static int findName(String nameStart, Trie contacts) {
        char[] chars = nameStart.toCharArray();
        return findLetter(contacts, chars, 0);
    }

    private static int findLetter(Trie node, char[] letters, int i) {
        if (i >= letters.length) {
            return node.wordCount;
        } else {
            Trie foundNode = null;
            for (Trie n : node.nodes) {
                if (n.value == letters[i]) {
                    foundNode = n;
                    break;
                }
            }

            if (foundNode == null) {
                return 0;
            } else {
                return findLetter(foundNode, letters, i + 1);
            }
        }
    }
}