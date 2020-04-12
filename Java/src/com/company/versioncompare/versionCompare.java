package com.company.level1;

public class versionCompare{

    public static void main(String args[]){
        String a = "5.11.4";
        String b = "5.11.3";
        String c = "4.2.1";
        String d = "11.5.2";


        System.out.println(compareVersions("5.11.3", b ) > 0);
        if(compareVersions("5.11.3", a ) > 0){
            System.out.println("발송x");
        } else{
            System.out.println("발송o");
        }


        if(compareVersions("5.11.3", c ) > 0){
            System.out.println("발송x");
        } else{
            System.out.println("발송o");
        }

        if(compareVersions("5.11.3", d ) > 0){
            System.out.println("발송x");
        } else{
            System.out.println("발송o");
        }
    }

    public int compareVersions(String version1, String version2){
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for(int i=0; i <length; i++){
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }
}