package DSExample;


import java.util.*;

class TreeNode<T extends Comparable<T>>{
    public T data;
    public ArrayList<TreeNode<T>> children;

    TreeNode(T data){
        this.data = data;
        this.children = new ArrayList<>();
    }

    public TreeNode<T> addChild(TreeNode<T> data){
        this.children.add(data);
        return data;
    }

    public List<TreeNode<T>> getChildren(){
        return this.children;
    }

}


public class TreeEx {

    public TreeNode<Integer> insertDataLevelVise(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter TreeNode data == ");
        int root = scanner.nextInt();
        TreeNode<Integer> rootNode = new TreeNode<>(root);
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(rootNode);
        while(!queue.isEmpty()){
            TreeNode<Integer> currentNode = queue.remove();
            System.out.print("Enter number of children data "+currentNode.data+" == ");
            int c = scanner.nextInt();
            for (int i = 1; i <= c; i++) {
                System.out.print("Enter "+i+" child data of "+currentNode.data+" == ");
                int d = scanner.nextInt();
                TreeNode<Integer> child = new TreeNode<>(d);
                currentNode.children.add(child);
                queue.add(child);
            }
        }

        return rootNode;
    }


    public static <T extends Comparable<T>> void printTree(TreeNode<T> TreeNode, String space){
        System.out.println(space+TreeNode.data);
        System.out.println("|");
        TreeNode.children.forEach(child-> printTree(child,space+space));
    }

    public static <T extends Comparable<T>> Long getAllNodes(TreeNode<T> node){
       if(node==null)return 0L;
        Long num = 1L;
        for (TreeNode<T> child : node.getChildren()) {
            num += getAllNodes(child);
        }
        return num;
    }

    public static <T extends Comparable<T>> Long getLargestBranch(TreeNode<T> node){
        if(node==null)return 0L;
        Long size = 0L;
        Long count = 1L;
        for (TreeNode<T> child : node.getChildren()) {
            count += getLargestBranch(child);
            if(count>size){
                size = count;
            }
        }
        return size;
    }

    public static <T extends Comparable<T>> T getLargestBranchData(TreeNode<T> node){
        if(node==null)return null;
        T data = node.data;
        for (TreeNode<T> child : node.getChildren()) {
            T  cData= getLargestBranchData(child);
            if(cData!=null && cData.compareTo(data)>0){
                data = cData;
            }
        }
        return data;
    }

    public static void main(String[] args) {

        TreeEx treeEx = new TreeEx();
//        TreeNode<Integer> TreeNode = treeEx.insertDataLevelVise();

        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> rch1 = root.addChild(new TreeNode<>(11));
        TreeNode<Integer> rch2 = root.addChild(new TreeNode<>(1234));

        TreeNode<Integer> ch1ch1 = rch1.addChild(new TreeNode<>(111));
        TreeNode<Integer> ch2ch1 = rch2.addChild(new TreeNode<>(121));
        TreeNode<Integer> ch2ch2 = rch2.addChild(new TreeNode<>(122));
        TreeNode<Integer> ch2ch3 = rch2.addChild(new TreeNode<>(123));
        
//        printTree(root,"-");

        TreeNode<String> roott = new TreeNode<>("root");

        TreeNode<String> node1 = roott.addChild(new TreeNode<String>("TreeNode 1"));

        TreeNode<String> node11 = node1.addChild(new TreeNode<String>("TreeNode 11"));
        TreeNode<String> node111 = node11.addChild(new TreeNode<String>("TreeNode 111"));
        TreeNode<String> node112 = node11.addChild(new TreeNode<String>("TreeNode 112"));

        TreeNode<String> node12 = node1.addChild(new TreeNode<String>("TreeNode 12"));

        TreeNode<String> node2 = roott.addChild(new TreeNode<String>("TreeNode 2"));

        TreeNode<String> node21 = node2.addChild(new TreeNode<String>("TreeNode 21"));
        TreeNode<String> node211 = node2.addChild(new TreeNode<String>("TreeNode 22"));

        printTree(roott, "-");

        System.out.println("Total nodes = "+getAllNodes(roott));

        System.out.println("Longest Branch = "+ getLargestBranch(roott));

        System.out.println("Longest Branch Data = "+ getLargestBranchData(root));
        System.out.println("Longest Branch Data = "+ getLargestBranchData(roott));

    }

}
