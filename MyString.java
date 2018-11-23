//implements the CharSequence interface
public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;

  public static void main(String[]args){
    try{
      MyString a = new MyString("honey");
      MyString b = new MyString("stardust");
      System.out.println("a: "+a);
      System.out.println("Length of a:"+a.length());
      // should print honey
      System.out.println("b: "+b);
      System.out.println("Length of b:"+b.length());
      // should print stardust
      System.out.println();

      System.out.println("Testing charAt");
      System.out.println("Char of a at index 0:"+ a.charAt(0));
      System.out.println("Char of b at index 0:"+ b.charAt(0));

      System.out.println();

      System.out.println("Testing subSequence");
      System.out.println("Subsequence of a (0,3): " + a.subSequence(0,3));
      //should be hon
      System.out.println("Subsequence of b (2,6): " + b.subSequence(2,6));
      //should be ardu

      System.out.println();

      System.out.println("Testing compareTo");
      System.out.println("a compared to b: " + a.compareTo(b));
      // should be a negative number
      System.out.println("b compared to a: " + b.compareTo(a));
      // should be a positive number opposite in sign but equal in magnitiude to a.compareTo(b)
      System.out.println("b compared to \"stardust\": " + b.compareTo("stardust"));
      // should be 0
    }catch(ClassCastException e){
      e.printStackTrace();
    }catch(IndexOutOfBoundsException e){
      e.printStackTrace();
    }
  }
  public MyString(CharSequence s){
    data = new char[s.length()];
    for (int i = 0; i < s.length(); i++){
      data[i] = s.charAt(i);
    }
  }

  public String toString(){
    String out = "";
    for (int i = 0; i < data.length; i++){
      out += data[i];
    }
    return out;
  }

  public char charAt(int index){
    if ((index < 0) || (index > data.length)) throw new IndexOutOfBoundsException("Index is out of bounds.");
    return data[index];
  }

  public int length(){
    return data.length;
  }

  public CharSequence subSequence(int start, int end){
    if (end < 0 || end > data.length || start < 0 || start > end) throw new IndexOutOfBoundsException("Index is out of bounds.");
    if (start == end) return "";
    String str = "";
    for (int i = start; i < end; i++) {
      str += data[i];
    }
    return str;
  }

  public int compareTo(CharSequence s) throws ClassCastException {
    int out = 0;
    // checks if s is null
    if (s == null) throw new NullPointerException("Cannot compare null.");
    // finds the least of the two lengths
    int len = Math.min(s.length(),data.length);
    // compares each char regardless of length
    for (int i = 0; i < len; i++) {
      if (data[i] < s.charAt(i)) {
        return -1;
      } else if (s.charAt(i) < data[i]) {
        return 1;
      }
    }
    // compares the lengths because all the for loop prior showed that the shorter is a substring of the larger
    if (data.length > s.length()) {
      return 1;
    }else if (data.length < s.length()) {
      return -1;
    }
      return 0;
    }
  }
