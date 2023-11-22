public class commonCharacters {
    public String[] commonCharacters(String[] strings) {
    // Write your code here.
    String smallestString = getSmallestString(strings);
    HashSet<Character> potentialCommonCharacters = new HashSet<Character>();
    for (int i = 0; i < smallestString.length(); i++) {
      potentialCommonCharacters.add(smallestString.charAt(i));
    }

    for(String string : strings) {
      removeNonexistentCharacters(string, potentialCommonCharacters);
    }

    String[] output = new String[potentialCommonCharacters.size()];
    int i = 0;
    for (Character character : potentialCommonCharacters) {
      output[i] = character.toString();
      i++;
    }
    return output;
  }

  private String getSmallestString(String[] strings) {
    String smallestString = strings[0];
    for (String string : strings){
      if (string.length() < smallestString.length()){
        smallestString = string;
      }
    }
    return smallestString;
  }

  private void removeNonexistentCharacters(String string, HashSet<Character> potentialCommonCharacters) {
     HashSet<Character> uniqueStringCharacters = new HashSet<Character>();
    for(int i = 0; i < string.length(); i++){
      uniqueStringCharacters.add(string.charAt(i));
    }

    HashSet<Character> charactersToRemove = new HashSet<Character>();
    for (char character : potentialCommonCharacters) {
      if(!uniqueStringCharacters.contains(character)) {
        charactersToRemove.add(character);
      } 
    }
    for (char character : charactersToRemove) {
      potentialCommonCharacters.remove(character);
    }
  }
}

class ProgramTest {
  @Test
  public void TestCase1() {
    String[] input = new String[] {"abc", "bcd", "cbad"};
    String[] expected = new String[] {"b", "c"};
    String[] actual = new Program().commonCharacters(input);
    Arrays.sort(actual);
    Utils.assertTrue(expected.length == actual.length);
    for (int i = 0; i < actual.length; i++) {
      Utils.assertTrue(expected[i].equals(actual[i]));
    }
  }
}
