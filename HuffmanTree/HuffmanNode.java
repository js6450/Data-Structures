
class HuffmanNode implements Comparable<HuffmanNode>{
	public String letter;
	public Double frequency;
	public HuffmanNode left, right;
	
	public HuffmanNode(String letter, Double frequency){
		this.letter = letter;
		this.frequency = frequency;
		this.left = null;
		this.right = null;
	}
	public HuffmanNode(HuffmanNode left, HuffmanNode right){
		String l;
		Double f;
		this.left = left;
		this.right = right;
		l = left.letter + right.letter;
		f = left.frequency + right.frequency;
		HuffmanNode huff = new HuffmanNode(l, f);
		huff.left = left;
		huff.right = right;
	}
	public String toString(){
		return "<" + this.letter + "," + this.frequency + ">";
	}
	public int compareTo(HuffmanNode huff){
		return this.frequency.compareTo(huff.frequency);
	}

}
