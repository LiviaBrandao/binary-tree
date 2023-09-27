package com.company;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Huffman {

    public static void encode(String receivedFilePath, String encodedFileName) throws Exception {
        String fileText = translateFilePathToFileText(receivedFilePath);
        MyOrderedLinkedList<TreeNode> occurrencesTable = generateOccurrencyTable(fileText);
        TreeNode tree = plantATree(occurrencesTable);

        //generate binary table by occurrences table
        //MyOrderedLinkedList<com.company.TreeNode> binaryTable = generateOccurrencyTable(fileText);

        //
    }

    private static MyOrderedLinkedList<TreeNode> generateOccurrencyTable(String fileText) throws Exception {
        int vetCount[] = new int[10000];
        MyOrderedLinkedList<TreeNode> tableOccurrency = new MyOrderedLinkedList();

        for (char c : fileText.toCharArray())
            vetCount[(int) c]++;

        for (int i = 0; i < vetCount.length; i++) {
            if (vetCount[i] != 0)
                tableOccurrency.removeFromTheTop(
                        new TreeNode(new Occurrency((char) i, vetCount[i]))
                );
        }

        return tableOccurrency;
    }


    public static String translateFilePathToFileText(String filePath) throws Exception {
        FileInputStream fileInput = new FileInputStream(filePath);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInput);
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);

        byte byteArray[];
        byteArray = new byte[fileInput.available()];
        dataInputStream.read(byteArray);

        dataInputStream.close();

        return new String(byteArray);
    }

    private static TreeNode plantATree(MyOrderedLinkedList<TreeNode> occurrencesTable) throws Exception {

        while (occurrencesTable.getCount() > 1) {
            TreeNode A = occurrencesTable.removeFromTheTop();
            TreeNode B = occurrencesTable.removeFromTheTop();

            Occurrency newOccurrency = new Occurrency('\0', A.getVal().getHowMany() + B.getVal().getHowMany());
            TreeNode newRoot = new TreeNode(newOccurrency, A, B);
            occurrencesTable.removeFromTheTop(newRoot);
        }

        return occurrencesTable.getFromTheTop();
    }
}
