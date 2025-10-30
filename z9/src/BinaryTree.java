import java.util.*;

public class BinaryTree {
    static class TreeNode {
        public int val;
        public TreeNode left;//左孩子的引用
        public TreeNode right;//右孩子的引用

        public TreeNode(char val) {
            this.val = val;
        }
    }


    /**
     * 创建一棵二叉树 返回这棵树的根节点
     *
     * @return
     */
    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;

    }

    // 前序遍历
    public void preOrder(TreeNode root) {
        if(root==null) return;
        System.out.println(root.val+"");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    void inOrder(TreeNode root) {
        if(root==null) return;
        preOrder(root.left);
        System.out.println(root.val+"");
        preOrder(root.right);
    }

    // 后序遍历
    void postOrder(TreeNode root) {
        if(root==null) return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.val+"");
    }

    public static int nodeSize;

    /**
     * 获取树中节点的个数：遍历思路
     */
    void size(TreeNode root) {
        if(root ==null) return;
        nodeSize++;
        size(root.left);
        size(root.right);
    }

    /**
     * 获取节点的个数：子问题的思路
     *
     * @param root
     * @return
     */
    int size2(TreeNode root) {
        if(root==null) return 0;

        return size2(root.left)+size2(root.right)+1;
    }


    /*
     获取叶子节点的个数：遍历思路
     */
    public static int leafSize = 0;

    void getLeafNodeCount1(TreeNode root) {
        if(root==null) return;
        if(root.right==null&&root.left==null) {
            leafSize++;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
    }

    /*
     获取叶子节点的个数：子问题
     */
    int getLeafNodeCount2(TreeNode root) {
        if(root==null) return 0;
        if(root.right==null&&root.left==null) {
            return 1;
        }
        return getLeafNodeCount2(root.left)
                +getLeafNodeCount2(root.right);
    }

    /*
    获取第K层节点的个数
     */
    int getKLevelNodeCount(TreeNode root, int k) {
        if(root==null) return 0;
        if(k==1) {
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)
                +getKLevelNodeCount(root.right,k-1);
    }

    /*
     获取二叉树的高度
     时间复杂度：O(N)
     */
    int getHeight(TreeNode root) {
        if(root==null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;

    }


    // 检测值为value的元素是否存在
    boolean find(TreeNode root, char val) {
        if(root==null) {
            return false;
        }
        if(root.val==val) {
            return true;
        }
        boolean left = find(root.left,val);
        if(left==true) {
            return true;
        }
        boolean right = find(root.right,val);
        if(right==true) {
            return true;
        }
        return false;


    }

    //层序遍历
    void levelOrder1(TreeNode root) {
        if(root==null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val+" ");
            if(cur.left!=null) {
                queue.offer(cur.left);
            }
            if(cur.right!=null) {
                queue.offer(cur.right);
            }

        }

    }
    List<List<TreeNode>> levelOrder(TreeNode root) {
        List<List<TreeNode>> ret = new ArrayList<>();
        if(root==null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> tmp = new ArrayList<>();
            while (size!=0) {
                TreeNode cur = queue.poll();
                tmp.add(cur);
                size--;
                //System.out.print(cur.val + " ");
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root==null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new LinkedList<>();
            while(size!=0) {
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                size--;
                if(cur.left!=null) {
                    queue.offer(cur.left);
                }
                if(cur.right!=null) {
                    queue.offer(cur.right);
                }
            }
            //头插 最后输出为倒叙
            ret.add(0,tmp);
        }
        return ret;
    }


    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur!=null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur!=null) {
                return false;
            }
        }
        return true;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q!=null||p!=null&&q==null) {
            return false;
        }
        if(p==null&&q==null) {
            return true;
        }
        if(p.val!=q.val) {
            return false;
        }
       return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }
    public boolean isSymmetricChild(TreeNode p,TreeNode q) {
        if(p==null&&q!=null||p!=null&&q==null) {
            return false;
        }
        if(p==null&&q==null) {
            return true;
        }
        if(p.val!=q.val) {
            return false;
        }
        return isSymmetricChild(p.left,q.right)&&isSymmetricChild(p.right,q.left);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) {
            return false;
        }
        if(isSameTree(root,subRoot)) {
            return true;
        }
        if(isSubtree(root.left,subRoot)) {
            return true;
        }
        if(isSubtree(root.right,subRoot)) {
            return true;
        }
        return false;

    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) {
            return true;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        return Math.abs(leftH-rightH)<=1&&isBalanced(root.left)&&isBalanced(root.right);

    }
    public static int i = 0;
    public static TreeNode create(String str) {
        TreeNode root = null;
        if(str.charAt(i)!='#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = create(str);
            root.right = create(str);
        }else {
            i++;
        }
        return root;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tmp = new LinkedList<>();
        if(root==null) {
            return tmp;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while (cur!=null||!stack.empty()) {
            while (cur!=null) {
                stack.push(cur);
                tmp.add(cur.val);
                cur = cur.left;
            }
            top = stack.pop();
            cur = top.right;
        }
        return tmp;
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> tmp = new LinkedList<>();
        if(root==null) {
            return tmp;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while (cur!=null||!stack.empty()) {
            while (cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            tmp.add(top.val);
            cur = top.right;
        }
        return tmp;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> tmp = new LinkedList<>();
        if(root==null) {
            return tmp;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        TreeNode pre = null;
        while (cur!=null||!stack.empty()) {
            while (cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.peek();
            if(top.right==null||top.right==pre) {
                stack.pop();
                tmp.add(top.val);
                pre = top;
            }else {
                cur = top.right;
            }
        }
        return tmp;
    }
    /*
class Solution {
    public int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1;
        return buildTreeChild(postorder,inorder,0,inorder.length-1);

    }
    private TreeNode buildTreeChild(int[] postorder,int[] inorder,int inbegin,int inend) {
        //左树或右树为空
        if(inbegin > inend) {
            return null;
        }
        //创立根节点
        TreeNode root = new TreeNode(postorder[postIndex]);
        //找到中序遍历中跟节点的下标
        int rootIndex = find(inorder,inbegin,inend,postorder[postIndex]);
        if(rootIndex==-1) {
            return null;
        }
        postIndex--;
        //创建右树
        root.right = buildTreeChild(postorder,inorder,rootIndex+1,inend);
        //创建左树
        root.left = buildTreeChild(postorder,inorder,inbegin,rootIndex-1);

        return root;
    }
    private int find(int[] inorder,int inbegin,int inend,int key) {
        for(int i=inbegin;i<=inend;i++) {
            if(inorder[i]==key) {
                return i;
            }
        }
        return -1;
    }
}
 */
    /*
class Solution {
    public int priIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }

    private TreeNode buildTreeChild(int[] preorder,int[] inorder,int inbegin,int inend) {
        //左树或右树为空
        if(inbegin > inend) {
            return null;
        }

        //创立根节点
        TreeNode root = new TreeNode(preorder[priIndex]);

        //找到中序遍历中跟节点的下标
        int rootIndex = find(inorder,inbegin,inend,preorder[priIndex]);
        if(rootIndex==-1) {
            return null;
        }

        priIndex++;

        //创建左树
        root.left = buildTreeChild(preorder,inorder,inbegin,rootIndex-1);
        //创建右树
        root.right = buildTreeChild(preorder,inorder,rootIndex+1,inend);

        return root;
    }

    private int find(int[] inorder,int inbegin,int inend,int key) {
        for(int i=inbegin;i<=inend;i++) {
            if(inorder[i]==key) {
                return i;
            }
        }
        return -1;
    }

}
 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return null;
        }
        if(p==root||q==root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null) {
            return root;
        }else if (right==null) {
            return left;
        }else {
            return right;
        }
    }

    //找到从root到node路径经过的所有节点 存入栈中
    public boolean getPath(TreeNode root,TreeNode node,Stack stack) {
        if(root==null||node==null) {
            return false;
        }
        stack.push(root);
        if(root==node) {
            return true;
        }
        boolean flg = getPath(root.left,node,stack);
        if(flg) {
            return true;
        }
        boolean flg1 = getPath(root.right,node,stack);
        if(flg1) {
            return true;
        }
        stack.pop();
        return false;
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return null;
        }
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();

        getPath(root,p,stackP);
        getPath(root,q,stackQ);

        int sizeP = stackP.size();
        int sizeQ = stackQ.size();
        if(sizeP>sizeQ) {
            int size = sizeP-sizeQ;
            while (size!=0) {
                stackP.pop();
                size--;
            }
        }else {
            int size = sizeQ-sizeP;
            while (size!=0) {
                stackQ.pop();
                size--;
            }
        }
        while (!stackP.empty()&&!stackQ.empty()) {
            if(stackP.peek().equals(stackQ.peek())) {
                return stackP.peek();
            }
            stackP.pop();
            stackQ.pop();
        }
        return null;

    }
    public String tree2str(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        tree2strChild(root,stringBuilder);
        return stringBuilder.toString();

    }
    public void tree2strChild(TreeNode t,StringBuilder stringBuilder) {
        if(t==null) {
            return;
        }
        stringBuilder.append(t.val);
        if(t.left!=null) {
            stringBuilder.append("(");
            tree2strChild(t.left,stringBuilder);
            stringBuilder.append(")");
        }else {
            if(t.right==null) {
                return;
            }else {
                stringBuilder.append("()");
            }
        }
        if(t.right!=null) {
            stringBuilder.append("(");
            tree2strChild(t.right,stringBuilder);
            stringBuilder.append(")");
        }else {
            return;
        }
    }






}
