package org.example;

public class MySimpleHash {
    // 设定哈希表的大小，通常应为素数，以减少哈希冲突
    private static final int HASH_TABLE_SIZE = 997;

    public static void main(String[] args) {
        String input = "Hello, world!";
        int hashValue = 0;

        // 遍历输入字符串中的每个字符
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // 将字符的ASCII码值加到哈希值上
            hashValue += ch;

            // 乘以一个较小的素数，这有助于使哈希值更均匀分布
            hashValue *= 31;
        }

        // 对哈希值取模，以将其限制在哈希表大小范围内
        hashValue %= HASH_TABLE_SIZE;

        // 确保哈希值为非负数
        if (hashValue < 0) {
            hashValue += HASH_TABLE_SIZE;
        }

        System.out.println("The hash value of \"" + input + "\" is: " + hashValue);
    }
}
