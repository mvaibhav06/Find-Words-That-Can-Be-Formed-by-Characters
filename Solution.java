class Solution {
    public int countCharacters(String[] words, String chars) {
        int out = 0;

        Map<Character, Integer> temp = new HashMap<>();
        for(int i=0; i<chars.length(); i++){
            char ch = chars.charAt(i);
            temp.put(ch, temp.getOrDefault(ch,0)+1);
        }

        for(int i=0; i<words.length; i++){

            Map<Character, Integer> temp1 = new HashMap<>();
            for(int j=0; j<words[i].length(); j++){
                char ch = words[i].charAt(j);
                temp1.put(ch, temp1.getOrDefault(ch,0)+1);
            }

            List<Character> list1 = new ArrayList<>();

            for(char ch : temp1.keySet()){
                list1.add(ch);
            }

            int k = 0;
            for(k=0; k<list1.size(); k++){
                if(temp.containsKey(list1.get(k))){
                    if(temp.get(list1.get(k)) < temp1.get(list1.get(k))){
                        break;
                    }
                }else{
                    break;
                }
            }
            if(k == list1.size()){
                out += words[i].length();
            }
            
        }
        return out;
    }
}
