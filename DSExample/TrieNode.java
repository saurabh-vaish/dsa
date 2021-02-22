package DSExample;


// Trie data structure . Used for storing characters or digits , useful when we want to use autocomplete for dictionary implementation.

// It is like tree . but a node can have at most 26 childs [ in case of string a- z ]

// stores char by char and link to child node

// we can also track where our world is completing to track world is exist or not


class Trie{
    private char data;
    private Trie[] children;
    private boolean isEndingWordNode;
    private int childCount;

    Trie(Character data){
        this.data = data;
        this.children = new Trie[26];  // as in a level there could be 26 max chars
        this.isEndingWordNode = false;
    }

    public Trie[] getChildren() {
        return children;
    }

    public boolean isEndingWordNode() {
        return isEndingWordNode;
    }

    public void setEndingWordNode(boolean endingWordNode) {
        isEndingWordNode = endingWordNode;
    }

    public Trie getChildAtIndex(int index){
        return this.getChildren()[index];
    }

    public int getChildCount() {
        return childCount;
    }

    public void increaseChildCount() {
        this.childCount++;
    }

    public void decreaseChildCount() {
        this.childCount--;
    }
}


public class TrieNode {


    public Trie insert(Trie node,String word){

        if(word.length()==0){
            node.setEndingWordNode(true);
            return node;
        }
        int childIndex = word.charAt(0)-'a';
        Trie child = node.getChildAtIndex(childIndex);
        if(child==null){
            child=new Trie(word.charAt(0));
            node.getChildren()[childIndex] = child;
            node.increaseChildCount();
        }

        return insert(node.getChildren()[childIndex], word.substring(1));
    }


//    public String print(Trie node){
//
//        if(node == null){
//            return null;
//        }
//        StringBuilder sb = new StringBuilder();
//        if(node.isEndingWordNode()){
//            sb.append(" ");
//            return sb.toString();
//        }
//        for (int i = 0; i < node.getChildren().length; i++) {
//            sb.append(node.getChildAtIndex(i).getData());
//            print(node.getChildAtIndex(i));
//        }
//        return sb.toString();
//    }


    public boolean searchWholeWord(Trie node , String word){
        if(word==null)return false;
        if(word.length()==0){
            return node.isEndingWordNode();
        }
        int index = word.charAt(0)-'a';
        Trie child = node.getChildAtIndex(index);
        if(child==null){
            return false;
        }
        return searchWholeWord(child,word.substring(1));
    }

    public boolean searchPartOfWord(Trie node , String word){
        if(word == null)return false;
        if(word.length()==0){
            return true;
        }
        int index = word.charAt(0)-'a';
        Trie child = node.getChildAtIndex(index);
        if(child==null){
            return false;
        }
        return searchPartOfWord(child,word.substring(1));
    }


    public boolean deleteWord(Trie node , String word){
        if(word==null)return false;
        if(word.length()==0){
            node.setEndingWordNode(false);
            return true;
        }
        int index = word.charAt(0)-'a';
        Trie child = node.getChildAtIndex(index);
        if(child==null){
            return false;
        }
        deleteWord(child,word.substring(1));

        // remove node only if is non ending and has no other child
        if(!child.isEndingWordNode() && child.getChildCount()==0){
            child = null;
            node.getChildren()[index]=null;
            node.decreaseChildCount();
        }
        return true;
    }


    public static void main(String[] args) {
        TrieNode trieNode = new TrieNode();

        String str = "node note bote apple news are as now none at";

        Trie root = new Trie('/');

        for (String w : str.split(" ")){
            trieNode.insert(root, w);
        }

        System.out.println(trieNode.searchWholeWord(root,"none"));
        System.out.println(trieNode.searchWholeWord(root,"atttt"));
        System.out.println(trieNode.searchWholeWord(root,"aal"));
        System.out.println(trieNode.searchWholeWord(root,"node"));

        System.out.println("--------------------------------------------");

        System.out.println(trieNode.searchPartOfWord(root,"none"));
        System.out.println(trieNode.searchPartOfWord(root,"no"));
        System.out.println(trieNode.searchPartOfWord(root,"app"));
        System.out.println(trieNode.searchPartOfWord(root,"at"));
        System.out.println(trieNode.searchPartOfWord(root,"rf"));
        System.out.println(trieNode.searchPartOfWord(root,"be"));

        System.out.println("--------------------------------------------");
        System.out.println(trieNode.deleteWord(root, "new"));
        System.out.println(trieNode.deleteWord(root, "not"));
        System.out.println(trieNode.deleteWord(root, "ton"));
        System.out.println(trieNode.deleteWord(root, "apple"));
        System.out.println(trieNode.deleteWord(root, "node"));
        System.out.println(trieNode.deleteWord(root, "note"));
        System.out.println(trieNode.deleteWord(root, "bote"));
        System.out.println(trieNode.deleteWord(root, "news"));
        System.out.println(trieNode.deleteWord(root, "are"));
        System.out.println(trieNode.deleteWord(root, "as"));
        System.out.println(trieNode.deleteWord(root, "none"));

        System.out.println("--------------------------------------------");
        System.out.println(trieNode.searchWholeWord(root,"news"));
        System.out.println(trieNode.searchWholeWord(root,"new"));
        System.out.println(trieNode.searchWholeWord(root,"note"));
        System.out.println(trieNode.searchWholeWord(root,"not"));

    }


}
