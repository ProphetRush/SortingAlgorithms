package com.sortAlgorithms.Algorithms;

import java.io.*;

public class ExternalSort {
    private static final int MAX_ARRAY_SIZE = 100000;
    private static final int BUFFER_SIZE = 100000;



    public static void externalSort(String sourceFile, String outputFile) throws IOException {
        int fragmentCount = initTmpFile(MAX_ARRAY_SIZE, sourceFile, "../tmp1.dat");
        merge(fragmentCount, MAX_ARRAY_SIZE, "../tmp1.dat","../tmp2.dat","../tmp3.dat", outputFile);
        System.out.println("Sort Success! The first 100 number of sorted File is:");
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(outputFile)));
        for (int i = 0; i < 100 && input.available()>0; i++) {
            System.out.print(input.readInt() + "  ");
        }
        System.out.println(" ");
        input.close();
    }

    public static void externalSort(String sourceFile, String outputFile, boolean deleteOriginFile) throws IOException {
        externalSort(sourceFile, outputFile);
        if(deleteOriginFile){
            File f = new File(sourceFile);
            if(f.delete()) System.out.println(" origin file successfully deleted.");
            else System.out.println("delete origin file failed.");
        }
    }

    private static int initTmpFile(int fragmentSize, String sourceFile, String tmpFile1) throws IOException {
        int[] list = new int[fragmentSize];
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(sourceFile)));
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(tmpFile1)));
        int fragmentCount = 0;
        while (input.available()>0){
            fragmentCount++;
            int len=0;
            for (; input.available()>0 && len < fragmentSize; len++) {
                list[len] = input.readInt();
            }
            QuickSort.optimizedQuickSortForDuplicate(list, 0, len-1);

            for (int i = 0; i < len; i++) {
                output.writeInt(list[i]);
            }

        }
        input.close();
        output.close();
        return fragmentCount;
    }

    private static void merge(int fragmentCount, int fragmentSize, String tmpFile1, String tmpFile2, String tmpFile3, String outputFile) throws IOException {
        if(fragmentCount>1){
            DataInputStream tmp1Input = new DataInputStream(new BufferedInputStream(new FileInputStream(tmpFile1), BUFFER_SIZE));
            DataOutputStream tmp2Output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(tmpFile2), BUFFER_SIZE));
            for (int i = 0; i < (fragmentCount/2)*fragmentSize; i++) {                      //Copy the half of tmp1 into tmp2
                tmp2Output.writeInt(tmp1Input.readInt());
            }
            tmp2Output.close();
            DataInputStream tmp2Input = new DataInputStream(new BufferedInputStream(new FileInputStream(tmpFile2), BUFFER_SIZE));
            DataOutputStream tmp3Output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(tmpFile3), BUFFER_SIZE));
            for (int i = 0; i < fragmentCount/2; i++) {
                int tmp1Data = tmp1Input.readInt();
                int tmp2Data = tmp2Input.readInt();
                int count1 = 1;
                int count2 = 1;
                while(true){
                    if(tmp1Data<tmp2Data){
                        tmp3Output.writeInt(tmp1Data);
                        if(tmp1Input.available() == 0 || count1++ >= fragmentSize){
                            tmp3Output.writeInt(tmp2Data);
                            break;
                        }else{
                            tmp1Data = tmp1Input.readInt();
                        }
                    }else{
                        tmp3Output.writeInt(tmp2Data);
                        if(tmp2Input.available() == 0 || count2++ >= fragmentSize){
                            tmp3Output.writeInt(tmp1Data);
                            break;
                        }else{
                            tmp2Data = tmp2Input.readInt();
                        }
                    }
                }
                while(tmp1Input.available() > 0 && count1++ < fragmentSize){
                    tmp3Output.writeInt(tmp1Input.readInt());
                }
                while(tmp2Input.available() > 0 && count2++ < fragmentSize){
                    tmp3Output.writeInt(tmp2Input.readInt());
                }



            }

            while (tmp1Input.available() > 0){
                tmp3Output.writeInt(tmp1Input.readInt());
            }

            tmp1Input.close();
            tmp2Input.close();
            tmp3Output.close();

            merge((fragmentCount+1)>>>1, fragmentSize*2, tmpFile3, tmpFile1, tmpFile2, outputFile);


        }else{
            File outFile = new File(outputFile);
            if(outFile.exists()) outFile.delete();
            new File(tmpFile1).renameTo(outFile);
            new File(tmpFile2).delete();
            new File(tmpFile3).delete();
        }
    }










}
