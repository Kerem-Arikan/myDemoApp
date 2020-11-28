package myDemoApp;

public class Trie
{
    private class TrieNode {
        private char element;
        
        private TrieNode[] children;
        private TrieNode parent;
    
        private int N;
        private boolean isLast;
        private int next_ptr;
    
        public TrieNode(int int_N)
        {
           this.next_ptr = 0;
           this.N = int_N;
           this.isLast = false;
           this.children = new TrieNode[int_N];
        }
    
        public TrieNode(int int_N, char new_el)
        {
            this.next_ptr = 0;
            this.element = new_el;
            this.N = int_N;
            this.isLast = false;
            this.children = new TrieNode[int_N];
        }
    
        public void setParent(TrieNode new_p)
        {
            this.parent = new_p;
        }
    
        public void setChild(char c)
        {
            this.children[this.next_ptr] = new TrieNode(this.N, c);
            this.children[this.next_ptr].setParent(this);
            this.next_ptr++;
        }
    
        public TrieNode getChild(char c)
        {
            for(int i = 0 ; i <  this.next_ptr ; i++)
            {
                if(this.children[i].getElement() == c)
                    return this.children[i];
            }
            return null;
        }
    
        public boolean isLast()
        {
            return this.isLast;
        }
    
        public char getElement()
        {
            return this.element;
        }
    
        public void setAsLast()
        {
            this.isLast = true;
        }
    }

    private TrieNode root;

    public Trie(int alphabet_count_new)
    {
        this.root = new TrieNode(alphabet_count_new);
    }

    public void insertString(String s)
    {
        s = s.toLowerCase();
        TrieNode pivot = this.root;
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            TrieNode child_temp = pivot.getChild(c);
            if(child_temp != null)
            {
                pivot = child_temp;
            }
            else 
            {
                pivot.setChild(c);
                pivot = pivot.getChild(c);
            }
            if(i == s.length()-1)
                pivot.setAsLast();
        }
    }
    public String findPrefix(String s)
    {
        s = s.toLowerCase();
        TrieNode pivot = this.root;
        String ret = "";
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            if(pivot == null)
                return "\0";
            TrieNode child_temp = pivot.getChild(c);
            if(pivot.isLast())
                return ret;
            ret += String.valueOf(c); 
            
            pivot = child_temp;
        }
        return "\0";
    }
}