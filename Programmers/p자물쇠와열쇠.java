package Programmers;

class p자물쇠와열쇠 {
	public boolean solution(int[][] key, int[][] lock) {
		int point = key.length - 1;
		for(int x = 0 ; x < point + lock.length; x++){
			for(int y = 0 ; y < point + lock.length; y++){
				for(int r = 0 ; r < 4; r++){
					int size = lock.length+(key.length*2);
					int[][] checkLock = new int[size][size];
					for(int i = point ; i < point+lock.length; i++){
						for(int j = point ; j < point+lock.length; j++){
							checkLock[i][j] = lock[i-point][j-point];
						}
					}
					check(checkLock,key,r,x,y);
					if(isVaild(checkLock,point,lock.length)) return true;
				}
			}
		}
		return false;
	}
	public void check(int[][] checkLock,int[][] key, int r, int x, int y){
		int len = key.length;
		for(int i = 0 ; i < len ; i++){
			for(int j = 0 ; j < len ; j++){
				if(r == 0){
					checkLock[x+i][y+j] += key[i][j];
				}else if(r==1){
					checkLock[x+i][y+j] += key[len-j-1][i];
				}else if(r==2){
					checkLock[x+i][y+j] += key[len-i-1][len-j-1];
				}else if(r==3){
					checkLock[x+i][y+j] += key[j][len-i-1];
				}
			}
		}
	}
	public boolean isVaild(int[][] checkLock,int point, int len ){
		for(int i = point ; i < point+len ; i++ ){
			for(int j = point ; j < point+len ; j++ ){
				if(checkLock[i][j] != 1) return false;
			}
		}
		return true;
	}

}




