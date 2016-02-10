
public class CatNode {
    Object element;
    CatNode up;
    CatNode down;
	
	CatNode(Object theElement, CatNode upNode, CatNode downNode){
		element = theElement;
		up = upNode;
		down = downNode;
	}
}
