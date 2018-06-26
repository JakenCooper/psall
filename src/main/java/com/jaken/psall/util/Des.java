package com.jaken.psall.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class Des {
    private Des() {
    }
    
    private static final String PASSWORD_KEY="95880288";
    //测试
    public static void main(String args[]) throws Exception {
         //待加密内容
         String str = "jaken123";
         //密码，长度要是8的倍数
         String password = "95880288";

        /* byte[] result = Des.encrypt(str.getBytes(),password);
         String finalResult = parseByte2HexStr(result);
         System.out.println("加密后："+finalResult);
         //直接将如上内容解密
         try {
                 byte[] decryResult = decrypt(parseHexStr2Byte(finalResult),PASSWORD_KEY);
                 System.out.println("解密后："+new String(decryResult));
         } catch (Exception e1) {
                 e1.printStackTrace();
         }*/
         
         String encryStr = Des.encrypt(str);
         System.out.println(encryStr);
         String descryStr = Des.decrypt(encryStr);
         System.out.println(descryStr);
    }
    
    public synchronized static String encrypt(String target){
    	byte[] binaryByteArr = encrypt(target.getBytes(),PASSWORD_KEY);
    	return parseByte2HexStr(binaryByteArr);
    }
    
    public synchronized static String decrypt(String target){
    	try {
    		byte[] decryByteArr = decrypt(parseHexStr2Byte(target),PASSWORD_KEY);
			return new String(decryByteArr);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("content decrypt failed");
		}
    }
    
    
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
    
    
    
    
    /**
     * 加密
     * @param datasource byte[]
     * @param password String
     * @return byte[]
     */
    private static  byte[] encrypt(byte[] datasource, String password) {            
        try{
        SecureRandom random = new SecureRandom();
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        //创建一个密匙工厂，然后用它把DESKeySpec转换成
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(desKey);
        //Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES");
        //用密匙初始化Cipher对象,ENCRYPT_MODE用于将 Cipher 初始化为加密模式的常量
        cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
        //现在，获取数据并加密
        //正式执行加密操作
        return cipher.doFinal(datasource); //按单部分操作加密或解密数据，或者结束一个多部分操作
        }catch(Throwable e){
                e.printStackTrace();
        }
        return null;
}
    /**
     * 解密
     * @param src byte[]
     * @param password String
     * @return byte[]
     * @throws Exception
     */
    private static byte[] decrypt(byte[] src, String password) throws Exception {
            // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");//返回实现指定转换的 Cipher 对象
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 真正开始解密操作
            return cipher.doFinal(src);
        }
}