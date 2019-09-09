package week02;

public class TreeNode { // 트리노드 선언
	private Object item;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode() { // 트리노드 생성자
		this.item = null;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode (Object item) { // 트리노드 생성자
		this.item = item;
		this.left = null;
		this.right = null;
		
	}
	
	public Object getItem() { // item getter
		return this.item;
	}
	
	public void setItem(Object item) { // item setter
		this.item = item;
	}

	public TreeNode getLeft() { // 왼쪽 노드 getter
		return this.left;
	}

	public void setLeft(TreeNode left) { // 오른쪽 노드 setter
		this.left = left;
	}

	public TreeNode getRight() { // 오른쪽 노드 getter
		return this.right;
	}

	public void setRight(TreeNode right) { // 오른쪽 노드 setter
		this.right = right;
	}
	
	

}


