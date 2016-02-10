
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HuffmanTree {
	public HuffmanNode root;
	public static BinaryHeap<HuffmanNode> binaryheap;
	
	public HuffmanTree(HuffmanNode huff){
		this.root = huff;
	}
	public void printLegend(){
		printLegend(root, "");
	}
	private void printLegend(HuffmanNode t, String s){
		if(t.letter.length() > 1){
			while(t.left != null || t.right != null){
				printLegend(t.left, s + "0");
				printLegend(t.right, s + "1");
			}
			System.out.println(t.letter + "=" + s);
		}
		else if(t.letter.length() == 1){
			System.out.println(t.letter + "=" + s);
		}
	}
	public static BinaryHeap<HuffmanNode> fileToHeap(String filename){
		Double frequency = 0.0;
		String letter = "";
		try{
			File file = new File(filename);
			Scanner in = new Scanner(file);
			while(in.hasNext()){
				letter = in.next();
				frequency = in.nextDouble();
				HuffmanNode h = new HuffmanNode(letter, frequency);
				binaryheap.insert(h);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File not found");
		}
		return binaryheap;
	}
	public static HuffmanTree createFromHeap(BinaryHeap<HuffmanNode> heap) throws UnderflowException{
		HuffmanNode t = null;
		HuffmanNode zeroth = null;
		heap.insert(zeroth);
		while(heap.currentSize > 1){
			HuffmanNode huff1 = heap.deleteMin();
			HuffmanNode huff2 = heap.deleteMin();
			String l = huff1.letter + huff2.letter;
			Double f = huff1.frequency + huff2.frequency;
			HuffmanNode huff3 = new HuffmanNode(l, f);
			heap.insert(huff3);
		}
		if(heap.currentSize == 1){
			t = heap.deleteMin();
		}
		HuffmanTree thuff = new HuffmanTree(t);
		return thuff;
	}
	public static void main(String args[]) throws UnderflowException{
		BinaryHeap<HuffmanNode> bheap = fileToHeap(args[0]);
		bheap.printHeap();
		HuffmanTree htree = createFromHeap(bheap);
		htree.printLegend();	
	}
	
}
