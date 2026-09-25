class Solution {
    public List<String> braceExpansionII(String expression) {
        Stack<Object[]> stack=new Stack<>();
        List<Set<String>> groups=new ArrayList<>();
        groups.add(new HashSet<>());
        Set<String> cur=new HashSet<>();
        cur.add("");
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if (Character.isLetter(c)) {
                Set<String> nextCur = new HashSet<>();
                for (String str : cur) {
                    nextCur.add(str + c);
                }
                cur = nextCur;
                
            } else if (c == '{') {
                stack.push(new Object[]{groups, cur});
                
                groups = new ArrayList<>();
                groups.add(new HashSet<>());
                
                cur = new HashSet<>();
                cur.add("");
                
            } else if (c == ',') {
                groups.get(groups.size() - 1).addAll(cur);
                groups.add(new HashSet<>());
                
                cur = new HashSet<>();
                cur.add("");
                
            } else if (c == '}') {
                groups.get(groups.size() - 1).addAll(cur);
                
                Set<String> combinedGroup = new HashSet<>();
                for (Set<String> g : groups) {
                    combinedGroup.addAll(g);
                }
                
                Object[] prev = stack.pop();
                groups = (List<Set<String>>) prev[0];
                Set<String> prevCur = (Set<String>) prev[1];
                
                Set<String> nextCur = new HashSet<>();
                for (String p : prevCur) {
                    for (String g : combinedGroup) {
                        nextCur.add(p + g);
                    }
                }
                cur = nextCur;
            }
        }
        
        groups.get(groups.size() - 1).addAll(cur);
        
        Set<String> resultSet = new HashSet<>();
        for (Set<String> g : groups) {
            resultSet.addAll(g);
        }
        
        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;

    }
}