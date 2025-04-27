package basic.array;

public class Array1 {
    public static void main(String[] args) {
        // #1. 주어진 배열의 원소들 중 제시된 규칙과 다른 항목이 몇 건?
        // 맨 앞부터 3개씩 묶어서 곱셈 결과가 맞으면 통과 틀리면 wrongCnt 증가
//        {
//            int[] intArray = {3,2,6, 3,4,4, 1,4,2, 2,3,6, 1,3,5, 1,5,1, 1,1,1, 2,4,2, 2,2,4};
//            int wrongCnt = 0;
//            // 구현
//            for(int i=0;i<intArray.length;i+=3){
//                int secondValue = i +1;
//                int answer = secondValue+1;
//
//                int realAnswer = intArray[i]*intArray[secondValue];
//                if(realAnswer!=intArray[answer])
//                    wrongCnt++;
//            }
//
//
//            System.out.println(wrongCnt);
//        }

        // #2. 양 끝에서 출발해서 안쪽으로 이동하면서 각 대칭 항목이 다른 것들 몇 건?
        // 맨 앞부터 3개씩 묶어서 곱셈 결과가 맞으면 통과 틀리면 wrongCnt 증가
//        {
//            char[] charArray = "XYZEBFFGQOVVPWGFFCEAYX".toCharArray();
//            int wrongCnt = 0;
//            // 구현
//            int start = 0;
//            int end = charArray.length-1;
//            while (start< end){
//                if(charArray[start]!=charArray[end])
//                    wrongCnt++;
//
//                start++;
//                end--;
//            }
//
//            System.out.println(wrongCnt);
//        }

        // #3. 문자열에 포함된 알파벳의 빈도수 출력, 0인 항목도 출력
        // 맨 앞부터 3개씩 묶어서 곱셈 결과가 맞으면 통과 틀리면 wrongCnt 증가
        {
            String str = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
            char[] charArray = str.toCharArray();
            int[] alphabets = new int[26];

            for(int i=0;i<charArray.length;i++){
                int currentAlphabet = charArray[i]-'a';
                alphabets[currentAlphabet]++;
            }

            for(int i=0;i<alphabets.length;i++)
                System.out.println((char)(i+'a')+":"+alphabets[i]);
        }


    }
}
