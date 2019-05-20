package RedBlackTree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        RedBlackTree redBlackTree = new RedBlackTree();
//        Set<Integer> integer = new HashSet<>();
//        for (int i = 0; i < 1000; i ++){
//            integer.add(random.nextInt(100));
//            if (integer.size() == 5){
//                break;
//            }
//        }
//        integer.forEach(integer1 -> {
//            System.out.print(integer1+",");
//        });
//        List<Integer> integers = new ArrayList<>(integer);

        //String a="12,1,9,2,0,11,7,19,4,15,18,5,14,13,10,16,6,3,8,17";
        String a = "10,40,30,60,90,70,20,50,80";
        /**
         * == 原始数据: 10 40 30 60 90 70 20 50 80
         * == 前序遍历: 30 10 20 60 40 50 80 70 90
         * == 中序遍历: 10 20 30 40 50 60 70 80 90
         * == 后序遍历: 20 10 50 40 70 90 80 60 30
         * 30(B) is root
         * 10(B) is 30's   left child
         * 20(R) is 10's  right child
         * 60(R) is 30's  right child
         * 40(B) is 60's   left child
         * 50(R) is 40's  right child
         * 80(B) is 60's  right child
         * 70(R) is 80's   left child
         * 90(R) is 80's  right child
         */
        //String a = "30,20,10,25,24";
        List<String> strings = Arrays.asList(a.split(","));
        List<Integer> integers = strings.stream().map(Integer::parseInt).collect(Collectors.toList());

        final int[] time = new int[2];
        time[0] = 0;
        for (Integer val: integers) {
            System.out.println("这是第" + (time[0]) +"次");
            redBlackTree.insert(val);
            redBlackTree.printRedBlacktree();
            System.out.println("这是第" + (time[0]) +"次结束");
            time[0]++;
        }
        redBlackTree.preOrder();
        redBlackTree.inOrder();
        redBlackTree.postOrder();
//        time[1]=0;
//        for (Integer val: integers) {
//            System.out.println("这是第" + (time[1]) +"次删除");
//            redBlackTree.remove(val);
//            avlTree.printAVLtree();
//            System.out.println("这是第" + (time[1]) +"次删除结束");
//            time[1]++;
//        }
    }
}
