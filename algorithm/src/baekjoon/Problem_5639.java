package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();
        boolean hasRoot = false;
        int root = 0;

        while (true) {
            String input = br.readLine();
            if (input.isBlank())
                break;
            if (!hasRoot) {
                root = Integer.parseInt(input);
                hasRoot = true;
                continue;
            }
            numbers.add(Integer.parseInt(input));
        }
        Collections.sort(numbers);
        boolean[] check = new boolean[numbers.size()-1];

        boolean isUp = true;
        int idx = 0;
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(idx));
            check[idx] = true;
            if (isUp) {
                idx += 2;
                if(check[idx-1])
                    idx+=1;
                isUp = false;
            } else {
                idx -= 1;
                isUp = true;
            }
        }

        System.out.println(root);
    }
}
