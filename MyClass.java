class MyClass{ 
	public static void main(String[] args){
		String wordSet = "1abccba1myymasdffdsa";
		char[] array = wordSet.toCharArray();
		
		for(int a = 2; a< array.length-3; a++){
			
			int backward = a;
			int forward = a+1;
						
			int count = 0;
			while(array[backward] == array[forward]){
				count++;
				backward--;
				forward++;
				if (backward < 0 || forward > array.length-1){
					break;
				}
			}
			if(count> 2){ 
				
				int highValue = a + count;
				System.out.println(count);
				for(int j = a +1; j<= highValue;System.out.print(array[j++]));
					
				System.out.println("");
			}
			
		}
		
	}
	
}