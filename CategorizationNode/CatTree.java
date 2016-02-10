
public class CatTree {
	private CatNode root;
	
	public CatTree(){
		root = null;
	}
	public void insert(ListNode x){
		new CatNode(x.returnElement(), root, (CatNode)null);
	}
	public void sort(){
		
	}
}
