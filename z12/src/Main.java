import java.util.HashSet;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            func(a,b);
        }
    }
    //坏键盘打字
    public static void func(String s1,String s2) {
        Set<Character> set1 = new HashSet<>();
        for (char ch:s2.toUpperCase().toCharArray()) {
            set1.add(ch);
        }
        Set<Character> set2 = new HashSet<>();
        for (char ch:s1.toUpperCase().toCharArray()) {
            if(!set1.contains(ch) && !set2.contains(ch)) {
                System.out.print(ch);
                set2.add(ch);
            }
        }
    }



    //存在重复元素
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        if(set.size() == nums.length) {
            return false;
        }else {
            return true;
        }

    }
    //存在重复元素 下标绝对值之差不超过k
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            if(map.containsKey(num) && i-map.get(num) <= k) {
                return true;
            }
            map.put(num,i);
        }
        return false;

    }
    //只出现一次的数字
    public int singleNumber(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for(char ch:jewels.toCharArray()) {
            set.add(ch);
        }
        int c = 0;
        for(char ch:stones.toCharArray()) {
            if(set.contains(ch)) {
                c++;
            }
        }
        return c;
    }


//    public Node copyRandomList(Node head) {
//        HashMap<Node,Node> map = new HashMap<>();
//        Node cur = head;
//        while(cur!=null) {
//            Node node = new Node(cur.val);
//            map.put(cur,node);
//            cur = cur.next;
//        }
//        cur = head;
//        while(cur != null) {
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        return map.get(head);
//
//    }

    //前k个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        //1.统计单词次数
        Map<String,Integer> map = new HashMap<>();
        for (String word:words) {
            if(map.get(word) == null) {
                map.put(word,1);
            }else {
                int val = map.get(word);
                map.put(word,val+1);
            }
        }
        //2.建立小根堆
        PriorityQueue<Map.Entry<String,Integer>> heap = new PriorityQueue<>
                (new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        //如果频率相同建立大根堆
                        if(o1.getValue().compareTo(o2.getValue()) == 0) {
                            return o2.getKey().compareTo(o1.getKey());
                        }
                        return o1.getValue()- o2.getValue();
                    }
                });
        //3.调整优先级队列
        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            if(heap.size() < k) {
                heap.offer(entry);
            }else {
                Map.Entry<String,Integer> top = heap.peek();
                if(top.getValue() == entry.getValue()) {
                    //频率相同 字母小的进
                    if(top.getKey().compareTo(entry.getKey()) > 0) {
                        heap.poll();
                        heap.offer(entry);
                    }
                }else if(top.getValue().compareTo(entry.getValue()) < 0){
                    heap.poll();
                    heap.offer(entry);
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<String,Integer> top = heap.poll();
            list.add(top.getKey());
        }
        Collections.reverse(list);
        return list;

    }

}