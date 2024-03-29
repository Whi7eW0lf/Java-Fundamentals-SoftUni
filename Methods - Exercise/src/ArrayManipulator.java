import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayManipulator {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Arrays.stream(read.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String input;

        while (!"end".equals(input = read.readLine())) {
            String[] data = input.split("\\s+");

            switch (data[0]) {
                case "exchange":
                    nums=exchangeList(nums,data[1]);
                    break;
                case "max":
                    System.out.println(maxElement(nums,data[1]));
                    break;
                case "min":
                    System.out.println(minElement(nums, data[1]));
                    break;
                case "first":
                    System.out.println(firstElement(nums, Integer.parseInt(data[1]), data[2]));
                    break;
                case "last":
                    System.out.println(lastElement(nums, Integer.parseInt(data[1]), data[2]));
                    break;
            }
        }
        System.out.println(nums);
    }

    private static String lastElement (List<Integer>nums , int count , String com){
        String result;
        if (validateLengthElements(nums,count)){
            if (checkEvenOrOdd(com)){
                result=lastOddElements(nums,count);
            }else {
                result=lastEvenElements(nums,count);
            }
        }else {
            result="Invalid count";
        }
        return result;
    }

    private static String lastEvenElements(List<Integer> nums, int count) {
        List<Integer>elements = new ArrayList<>();
        for (int i = nums.size()-1; i >=0 ; i--) {
            if (nums.get(i)%2==0){
                elements.add(nums.get(i));
            }
            if (elements.size()==count){
                break;
            }
        }
        return elements.toString();
    }

    private static String lastOddElements(List<Integer> nums, int count) {
        List<Integer>elements = new ArrayList<>();
        for (int i = nums.size()-1; i >=0 ; i--) {
            if (nums.get(i)%2!=0){
                elements.add(nums.get(i));
            }
            if (elements.size()==count){
                break;
            }
        }
        Collections.reverse(elements);
        return elements.toString();
    }

    private static String firstElement (List<Integer> nums,int count,String com){
        String result;
        if (validateLengthElements(nums,count)){
            if (checkEvenOrOdd(com)){
                result=firstOddElements(nums,count);
            }else {
                result=firstEvenElements(nums,count);
            }
        }else {
            result="Invalid count";
        }
        return result;
    }
    private static String firstEvenElements(List<Integer> nums, int count) {
        List<Integer> elements = new ArrayList<>();
        for (Integer num : nums) {
            if (num % 2 == 0) {
                elements.add(num);
            }
            if (elements.size() == count) {
                break;
            }
        }
        return elements.toString();
    }
    private static String firstOddElements(List<Integer> nums, int count) {
        List<Integer> elements = new ArrayList<>();
        for (Integer num : nums) {
            if (num % 2 != 0) {
                elements.add(num);
            }
            if (elements.size() == count) {
                break;
            }
        }
        return elements.toString();
    }


    private static String minElement(List<Integer>nums,String com) {
        String result;
        if (checkEvenOrOdd(com)){
            result=findMinOdd(nums);
        }else {
            result=findMinEven(nums);
        }
        return result;
    }

    private static String maxElement(List<Integer> nums,String com){
        String result;
        if (checkEvenOrOdd(com)){
            result=findMaxOdd(nums);
        }else {
            result=findMaxEven(nums);
        }
        return result;
    }

    private static String findMaxOdd(List<Integer> nums) {
        int index = -1;
        int foundMaxNum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i)%2!=0){
                if(nums.get(i)>=foundMaxNum){
                    foundMaxNum = nums.get(i);//8
                    index=i;
                }
            }
        }
        if (index!=-1){
            return index+"";
        }else {
            return "No matches";
        }
    }

    private static String findMinOdd(List<Integer> nums) {

        int index = -1;
        int foundMinNum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i)%2!=0){
                if(nums.get(i)<=foundMinNum){
                    foundMinNum = nums.get(i);//8
                    index=i;
                }
            }
        }
        if (index!=-1){
            return index+"";
        }else {
            return "No matches";
        }
    }

    private static String findMaxEven(List<Integer> nums) {
        int index = -1;
        int foundMaxNum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i)%2==0){
                if(nums.get(i)>=foundMaxNum){
                    foundMaxNum = nums.get(i);//8
                    index=i;
                }
            }
        }
        if (index!=-1){
            return index+"";
        }else {
            return "No matches";
        }
    }

    private static String findMinEven(List<Integer> nums) {

        int index = -1;
        int foundMinNum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i)%2==0){
                if(nums.get(i)<=foundMinNum){
                    foundMinNum = nums.get(i);//8
                    index=i;
                }
            }
        }
        if (index!=-1){
            return index+"";
        }else {
            return "No matches";
        }
    }

    private static List<Integer> exchangeList(List<Integer> nums, String inputIndex) {

        int index=Integer.parseInt(inputIndex);

        List<Integer> result = new ArrayList<>();

        if (validateIndex(nums,index)){
            result.addAll(nums.subList(index+1,nums.size()));
            result.addAll(nums.subList(0,index+1));
        }else {
            return nums;
        }
        return result;
    }


    private static boolean checkEvenOrOdd(String data1){
        return data1.equals("odd");
    }
    private static boolean validateIndex(List<Integer>nums,int index){
        if (index>=0&&index<nums.size()) {
            return true;
        }else {
            System.out.println("Invalid index");
            return false;
        }
    }
    private static boolean validateLengthElements(List<Integer> nums, int count){
        if (count>0&&count<=nums.size()){
            return true;
        }else if (count==0){
            System.out.println("[]");
            return false;
        }
        return false;
    }
}
