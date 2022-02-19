package com.mtb.ex;

/**
 * @author MithileshB
 * @created 17/02/2022 - 11:45 PM
 * @project interviewex
 */
public class CoronaVaccine {

    private static int numberOfVaccines=0;
    public static int supplyVaccine(TreeNode root){

        String result=needsVaccine(root);
        if(result.equals("need")){ numberOfVaccines++;
        }
        return numberOfVaccines;
    }
    private static String needsVaccine(TreeNode root){

        if(root==null){
            return "NOT_REQUIRED";
        }
        String left=needsVaccine(root.left);
        String right=needsVaccine(root.right);

        if(left.equals("need") || right.equals("need")){
            numberOfVaccines++;
            return "provided";
        }else if(left.equals("provided") || right.equals("provided")){
            return "NOT_REQUIRED";
        }
        return "need";
    }

    public static void main(String[] args) {
  /*      System.out.println(supplyVaccine(new TreeNode(1,new TreeNode(2,null,null),
                new TreeNode(3,null,new TreeNode(4,null,new TreeNode(5,null,new TreeNode(6,null,null)))))));
  */      System.out.println(supplyVaccine(new TreeNode(1,null,new TreeNode(2,null,new TreeNode(3,null,null)))));
    }
}
