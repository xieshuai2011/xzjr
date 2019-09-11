package com.springcloud.provider.common.utils;

import com.springcloud.provider.common.enums.ReturnCodeEnum;
import com.springcloud.provider.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串帮助类
 *
 */
public class StringUtil {

	public static boolean isEmpty(Object pObj) {
		if (pObj == null) {
			return true;
		}
		if (pObj == "") {
			return true;
		}
		if ((pObj instanceof String)) {
			if (((String) pObj).length() == 0) {
				return true;
			}
		} else if ((pObj instanceof Collection)) {
			if (((Collection<?>) pObj).size() == 0) {
				return true;
			}
		} else if (((pObj instanceof Map)) && (((Map<?, ?>) pObj).size() == 0)) {
			return true;
		}

		return false;
	}

	public static boolean isNotEmpty(Object pObj) {
		if (pObj == null) {
			return false;
		}
		if (pObj == "") {
			return false;
		}
		if ((pObj instanceof String)) {
			if (((String) pObj).length() == 0) {
				return false;
			}
		} else if ((pObj instanceof Collection)) {
			if (((Collection<?>) pObj).size() == 0) {
				return false;
			}
		} else if (((pObj instanceof Map)) && (((Map<?, ?>) pObj).size() == 0)) {
			return false;
		}

		return true;
	}

	public static String capitalize(String str) {
		int strLen;
		if ((str == null) || ((strLen = str.length()) == 0)) {
			return str;
		}
		int firstCodepoint = str.codePointAt(0);
		int newCodePoint = Character.toTitleCase(firstCodepoint);
		if (firstCodepoint == newCodePoint) {
			return str;
		}

		int[] newCodePoints = new int[strLen];
		int outOffset = 0;
		newCodePoints[(outOffset++)] = newCodePoint;
		for (int inOffset = Character.charCount(firstCodepoint); inOffset < strLen;) {
			int codepoint = str.codePointAt(inOffset);
			newCodePoints[(outOffset++)] = codepoint;
			inOffset += Character.charCount(codepoint);
		}
		return new String(newCodePoints, 0, outOffset);
	}

	/**
	 * 正则匹配
	 * 
	 * @param regex
	 * @param str
	 * @return
	 */
	public static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	public static List<String> toList(String str, String split){
		List<String> list = new ArrayList<>();
		if(isNotEmpty(str)) {
			String[] part = str.split(split);
			for(int i = 0; i < part.length; i++) {
				list.add(part[i]);
			}
		}
		return list;
	}
	/**
	 * 替换空白字符和转义字符
	 * @param str
	 * @return
	 */
	public static String replaceSpecialStr(String str){
		return str==null?null:str.replaceAll("\\s+", "").replaceAll("\\\\", "");
	}

	/**
	 * 字符串MD5加密
	 * @param str
	 * @return
	 */
	public String makeMD5(String str) {
		MessageDigest md;
		try {
			// 生成一个MD5加密计算摘要
			md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(str.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			String strMD5 = new BigInteger(1, md.digest()).toString(16);
			return str;
		} catch (Exception e) {
			throw new BusinessException(ReturnCodeEnum.ERROR,"字符加密异常");
		}
	}

	//随机密码的位数
	private static final Integer RANDOMSIZE = 6;
	/**
	 * 随机生成密码
	 * @return 最终生成的密码
	 */
	public static String generatePassword () {
		// 最终生成的密码
		String password = "";
		Random random = new Random();
		for (int i = 0; i < RANDOMSIZE; i ++) {
			// 随机生成0或1，用来确定是当前使用数字还是字母 (0则输出数字，1则输出字母)
			int charOrNum = random.nextInt(2);
			if (charOrNum == 1) {
				// 随机生成0或1，用来判断是大写字母还是小写字母 (0则输出小写字母，1则输出大写字母)
				int temp = random.nextInt(2) == 1 ? 65 : 97;
				password += (char) (random.nextInt(26) + temp);
			} else {
				// 生成随机数字
				password += random.nextInt(10);
			}
		}
		return password;
	}
}
