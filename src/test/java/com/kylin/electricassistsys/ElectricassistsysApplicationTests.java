package com.kylin.electricassistsys;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElectricassistsysApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void encryptPwd() {
		StandardPBEStringEncryptor stringEncryptor = new StandardPBEStringEncryptor();
		stringEncryptor.setAlgorithm(StandardPBEByteEncryptor.DEFAULT_ALGORITHM);
		stringEncryptor.setPassword("security");
		//String result = stringEncryptor.encrypt("123");
		String result = stringEncryptor.encrypt("123456");
		System.out.println(result);
	}

}
