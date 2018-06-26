package com.neuedu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.mapper.UserAccountMapper;
import com.neuedu.model.UserAccount;
import com.neuedu.service.UserAccountService;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration("classpath:config/spring-common.xml") // Spring整合JUnit4测试时，使用注解引入配置文件
public class TestUserAccountMapper {
	@Autowired
	//UserAccountService userAccountService;
	UserAccountMapper userAccountMapper;
	@Test
	public void testFindUserByAccount() {
		UserAccount userAccount = userAccountMapper.findUserByAccount("admin");
		System.out.println(userAccount.getAccounts());
	}

}
