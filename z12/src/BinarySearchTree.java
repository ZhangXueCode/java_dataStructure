public class BinarySearchTree {
    static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int key) {
                this.key = key;
        }
    }

    public TreeNode root;
    //插入
    public boolean insert(int key) {
        TreeNode node = new TreeNode(key);
        if(root == null) {
            root = node;
            return true;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if(cur.key < key) {
                parent = cur;
                cur = cur.right;
            }else if (cur.key > key) {
                parent = cur;
                cur = cur.left;
            }else {
                return false;
            }
        }
        if(parent.key > key) {
            parent.left = node;
        }else {
            parent.right = node;
        }
        return true;
    }
        //查找key是否存在
    public TreeNode search(int key) {
        TreeNode cur = root;
        while (cur != null) {
            if(cur.key > key) {
                cur = cur.left;
            }else if(cur.key < key) {
                cur = cur.right;
            }else {
                return cur;
            }
        }
        return null;
    }
        //删除key的值
    public boolean remove(int key) {
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if(cur.key > key) {
                parent = cur;
                cur = cur.left;
            }else if(cur.key < key) {
                parent = cur;
                cur = cur.right;
            }else {
                removeNode(parent,cur);
                return true;
            }
        }
        return false;
    }

    private void removeNode(TreeNode parent, TreeNode cur) {
        if(cur.left == null) {
            if (cur == root) {
                root = root.right;
            }
            if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = root.left;
            }
            if(cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            TreeNode target = cur.right;
            TreeNode targetParent = cur;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.key = target.key;
            if(target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }

    }
}
