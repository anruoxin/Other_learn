import java.util.*;

public class Demo {
    public static void main(String[] args) {
//        BinaryTreeNode root = new BinaryTreeNode();
//        root.setData(100);
//        BinaryTree binaryTree = new BinaryTree(root);
//        BinaryTreeNode left1 = new BinaryTreeNode();
//        left1.setData(50);
//        binaryTree.insertLeft(root, left1);
//        BinaryTreeNode right1 = new BinaryTreeNode();
//        right1.setData(150);
//        binaryTree.insertRight(root, right1);
//        System.out.println("先序遍历");
//        binaryTree.preOrder(root);
//        System.out.println("中序遍历");
//        binaryTree.inOrder(root);
//        System.out.println("后序遍历");
//        binaryTree.postOrder(root);
        Random random = new Random();

//        BinaryTreeNode root = new BinaryTreeNode();
//        root.setData(random.nextInt(1000201));
//        BinarySearchingTree binarySearchingTree = new BinarySearchingTree(root);
//        for (int i = 0; i < 100; i ++){
//            binarySearchingTree.insert(random.nextInt(1000201));
//        }
//        System.out.println("先序遍历");
//        binarySearchingTree.preOrder(root);
//        System.out.println("中序遍历");
//        binarySearchingTree.inOrder(root);
//        System.out.println("后序遍历");
//        binarySearchingTree.postOrder(root);
        Set<Integer> integer = new HashSet<>();
        for (int i = 0; i < 1000; i ++){
            integer.add(random.nextInt(100));
            if (integer.size() == 25){
                break;
            }
        }
        integer.forEach(integer1 -> {
            System.out.print(integer1+",");
        });
        List<Integer> integers = new ArrayList<>(integer);
//        String a = "17,51,53,57,31";
//        List<String> strings = Arrays.asList(a.split(","));
//        List<Integer> integers = strings.stream().map(Integer::parseInt).collect(Collectors.toList());

        AVLTree avlTree = new AVLTree();
        final int[] time = new int[2];
        time[0] = 0;
        for (Integer val: integers) {
            System.out.println("这是第" + (time[0]) +"次");
            avlTree.insert(val);
            avlTree.printAVLtree();
            System.out.println("这是第" + (time[0]) +"次结束");
            time[0]++;
        }
        time[1]=0;
        for (Integer val: integers) {
            System.out.println("这是第" + (time[1]) +"次删除");
            avlTree.remove(val);
            avlTree.printAVLtree();
            System.out.println("这是第" + (time[1]) +"次删除结束");
            time[1]++;
        }

//        System.out.println("先序遍历");
//        avlTree.preOrder(root);
//        System.out.println("中序遍历");
//        avlTree.inOrder(root);
//        System.out.println("后序遍历");
//        avlTree.postOrder(root);


    }
}
