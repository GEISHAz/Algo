class p스킬트리 {
    boolean[] learn;
    public boolean checkTree(int size){
        boolean check = true;
        for(boolean b : learn){
            if(check && !b)
                check=false;
            else if(!check && b)
                return false;
        }
        return true;
    }
    public int solution(String skill, String[] skill_trees) {
        int answer = 0, where;
        for(String str : skill_trees){
            int length = skill.length()-1;
            int down = Integer.MAX_VALUE;
            boolean isVaild = true;
            learn = new boolean[skill.length()];
            while(length!=-1){
                char now = skill.charAt(length);
                if(str.indexOf(String.valueOf(now))!=-1){
                    where = str.indexOf(String.valueOf(now));
                    learn[length] = true;
                    if(where < down)
                        down = where;
                    else {
                        isVaild = false;
                        break;
                    }
                }
                length--;
            }
            if(isVaild && checkTree(skill.length()))
                answer++;
        }
        return answer;
    }
}
