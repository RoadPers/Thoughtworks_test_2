public class BowlingGame {

	public static final int NUMOFBOX = 10; //一局的格数

	//把char符号转换成相应的分数的方法
	public static int value(char pre,char w){
		if(w == 'X') {
			return 10;
		}else if (Character.isDigit(w)) {
			return Character.getNumericValue(w);
		}else if (w == '/'){
			return 10 - Character.getNumericValue(pre);
		}else{
			return 0;
		}
	}
	
    public static int getBowlingScore(String bowlingCode) {
  		char[] buff = bowlingCode.toCharArray();
  		
  		int x = 1;	//保障 x-1 >= 0,tmp[]不越界
		char[] tmp = new char[buff.length];
		//去除成绩中的‘|’
		for(int i = 0; i < buff.length; i++){
			if (buff[i] != '|') {
				tmp[x] = buff[i];
				x++;
			}
		}

		int count = 0;	//count记录tmp[]中X的数量
		for (char w:tmp ) {
			if (w == 'X') {
				count++;
				if(count >= 10) break;
			}
		}
		//开始计数加和
		int sum = 0;
		int ball_number = NUMOFBOX * 2 - count;//一局打的球数（真正计分的，不包含额外击球）
		for(int i = 1; i <= ball_number ; i++){ 
			if(tmp[i] == 'X'){
				sum += ( value(tmp[i-1],tmp[i]) + value(tmp[i], tmp[i+1]) + value(tmp[i+1], tmp[i+2]) );
			}else if (tmp[i] == '/') {
				sum += ( value(tmp[i-1], tmp[i]) + value(tmp[i], tmp[i+1]) );
			}else if (Character.isDigit(tmp[i])){
				sum += Character.getNumericValue(tmp[i]);
			}else{
				sum += 0;
			}

		}	
        return sum;
    }


}
