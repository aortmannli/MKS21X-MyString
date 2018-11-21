//implements the CharSequence interface
public class MyString implements CharSequence{
  private char[] data;

  public MyString(CharSequence s){
    data = new char[s.length()];
    for (int i = 0; i < s.length(); i++){
      data[i] = s.charAt();
    }
  }

  public String toString(){
    return "";
  }

  public char charAt(int index){
    if ((index < 0) || (index > data.length)) throw new IndexOutOfBoundsException("Index is out of bounds.");
    return data[index];
  }

  public int length(){
    return data.length;
  }

  public CharSequence subSequence(int start, int end){
    return "";
  }
}
