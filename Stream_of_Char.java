// Time Complexity : O(nk): insert, O(k): find // k: avg length of word
// Space Complexity : O(nk) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class StreamChecker {
    class TrieNode{
        TrieNode []children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    
    TrieNode root;
    StringBuilder sb;

    private void insert(String word){
        TrieNode curr = root;
        for(int i = word.length()-1; i>=0; i--){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    boolean find(String word){
        TrieNode curr = root;
        for(int i = word.length()-1; i>=0; i--){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
            if(curr.isEnd == true){
                return true;
            }
           

        }
        return false;
    }

    public StreamChecker(String[] words) {
        if(words == null || words.length ==0){
            return;
        } 
        root = new TrieNode();
        sb = new StringBuilder(); 
        for(String word :words){
            insert(word);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        return find(sb.toString());
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */