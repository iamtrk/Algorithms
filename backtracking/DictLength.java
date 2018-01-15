public class DictLength {

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");

        System.out.println(ladderLength("hit", "cog", dict));
    }

    public static int ladderLength(String begin, String end, Set<String> wordDict) {
    // Queue is required as we ll be doing a BFS.
        LinkedList<wordnode> queue = new LinkedList<>();
        queue.add(new wordnode(begin, 1));

        wordDict.add(end);

        while (!queue.isEmpty()) {
            
            wordnode top = queue.remove();
            String word = top.word;

            if(word.equals(end)) {
                return top.numSteps;
            }

            char[] arr = word.toCharArray();

            for (int i=0; i<arr.length; i++) {
                for (char c='a'; c<='z'; c++) {
                    char temp = arr[i];

                    arr[i] = c;
                    String newword = new String(arr);
                    // we are generating all possible strings possible here, how ?
                    // By repeatedly replacing each character with the a char set.
                    System.out.println("new word: "+newword);

                    if(wordDict.contains(newword)) {
                        queue.add(new wordnode(newword, top.numSteps+1));
                        wordDict.remove(newword);
                    }

                    arr[i]=temp;
                }
             }
        }

        return 0;
    }
}

class wordnode {
    String word;
    int numSteps;

    public wordnode(String word, int numSteps) {
        this.word = word;
        this.numSteps = numSteps;
    }
}
