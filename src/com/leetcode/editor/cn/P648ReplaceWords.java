package com.leetcode.editor.cn;
//在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词
//根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。 
//
// 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继
//承词有许多可以形成它的词根，则用最短的词根替换它。 
//
// 你需要输出替换之后的句子。 
//
// 
//
// 示例 1： 
//
// 
//输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the
// battery"
//输出："the cat was rat by the bat"
// 
//
// 示例 2： 
//
// 
//输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//输出："a a b c"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写字母组成。 
// 1 <= sentence.length <= 10^6 
// sentence 仅由小写字母和空格组成。 
// sentence 中单词的总量在范围 [1, 1000] 内。 
// sentence 中每个单词的长度在范围 [1, 1000] 内。 
// sentence 中单词之间由一个空格隔开。 
// sentence 没有前导或尾随空格。 
// 
//
// 
// Related Topics 字典树 数组 哈希表 字符串 
// 👍 201 👎 0

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P648ReplaceWords{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary){
            //put each word to the trie
            Trie temp_node = trie;
            for(int i = 0; i < word.length(); i++){
                temp_node.children.putIfAbsent(word.charAt(i), new Trie());
                temp_node = temp_node.children.get(word.charAt(i));
            }

            //set the "." as the end signal
            temp_node.children.put('.', new Trie());
        }

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++){
            words[i] = TrieContainWord(trie, words[i]);
        }
        return String.join(" ", words);
    }
    public String TrieContainWord(Trie root, String word){
        StringBuffer result = new StringBuffer();
        Trie temp_root = root;
        for (int i = 0; i < word.length(); i++){
            if (!temp_root.children.containsKey(word.charAt(i))){
                return word;
            }
            temp_root = temp_root.children.get(word.charAt(i));
            result.append(word.charAt(i));
            if (temp_root.children.containsKey('.')){
                return result.toString();
            }
        }
        return word;
    }

}
class Trie{
    Map<Character, Trie> children;
    public Trie(){
        children = new HashMap<Character, Trie>();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}