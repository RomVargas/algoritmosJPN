import java.util.*;
public class GlobalMatch {

    public static void main(String[] args){
        boolean test = globalMatching2("abcdefg", "a*e?g");
        System.out.println(test);
    }
   /**
    * The function takes in a file name and a pattern and returns true if the file name matches the
    * pattern
    * 
    * @param fileName the name of the file
    * @param pattern "*a*b"
    * @return The last element in the table.
    */
    public static boolean globalMatching(String fileName, String pattern) {
    List<List<Boolean>> table = new ArrayList<List<Boolean>>();
    char star = '*';
    for(int i =0; i <= fileName.length(); i++){
      List<Boolean> row = new ArrayList<Boolean>();
      for(int j = 0; j <= pattern.length(); j++){
        row.add(false);
      }
      table.add(row);
    }
    table.get(0).set(0,true);
    for(int j = 1; j <= pattern.length(); j++) {
      if (pattern.charAt(j - 1) == '*') table.get(0).set(j, table.get(0).get(j -1));
    }
    for (int i = 1; i <= fileName.length(); i++){
      for(int j = 1; j <= pattern.length(); j++){
        if (pattern.charAt(j - 1) == '*'){
          table.get(i).set(j, table.get(i).get(j - 1) || table.get(i - 1).get(j));
        } else if (pattern.charAt(j - 1) == '?' || pattern.charAt(j - 1) == fileName.charAt(i - 1)){
          table.get(i).set(j, table.get(i - 1).get(j - 1));
          
        }
      }
    }
    return table.get(fileName.length()).get(pattern.length());
  }

  // con Java 11
 // A method that takes in a file name and a pattern and returns true if the file name matches the
 // pattern.
  public static boolean globalMatching2(String fileName, String pattern) {
    var table = new ArrayList<List<Boolean>>();
    for (var i = 0; i <= fileName.length(); i++){
      var row = new ArrayList<Boolean>();
      for (var j = 0; j <= pattern.length(); j++){
        row.add(false);
      }
      table.add(row);
    }
    table.get(0).set(0,true);
    for(var j = 1;j <= pattern.length(); j++){
      if(pattern.charAt(j - 1) == '*') table.get(0).set(j, table.get(0).get(j-1));
    }
    for (var i = 1; i <= fileName.length(); i++) {
      for( var j = 1; j <= pattern.length(); j++) {
        if (pattern.charAt(j - 1) == '*') {
          table.get(i).set(j, table.get(i).get(j - 1) || table.get(i - 1).get(j));
        } else if (pattern.charAt(j - 1) == '?'
                  || pattern.charAt(j - 1) == fileName.charAt(i - 1)) {
          table.get(i).set(j ,table.get(i - 1).get(j - 1));
                  } 
      }
    }
    return table.get(fileName.length()).get(pattern.length());
  }
}