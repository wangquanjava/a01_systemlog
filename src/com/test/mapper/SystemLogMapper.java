package com.test.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.domain.SystemLog;

/*
 * 总结： 
 * 		1.有了spring以后mapper接口需要交给org.mybatis.spring.mapper.MapperFactoryBean创建，传入接口和sqlSessionFactory
 * 		2.有了spring以后，就是applicationContext.xml加载sqlMapConfig.xml
 *	   				sqlMapConfig.xml加载UserMapper.xml
 *      3.有了spring以后，就由spring来管理mapper和mapper配置，自己主配置文件，只有给po类起别名的作用了
 *      4.如果mapper接口和配置同包同名，在sqlMapConfig中可以省略加载mapper配置
 *      5.那么现在sqlMapConfig的价值就是，给po类起别名，然后在mapper配置中，可以简写po类
 *      6.为了批量注册某个包下的mapper类，可以使用MapperScannerConfigurer类，再把包的路径给它，就可以了。
 *      		不用给它sqlSessiongFactory,默认表现出的id是类的首字符小写的方式
 */
public interface SystemLogMapper {
	public SystemLog findSystemLogById(String id);
	
	public List<SystemLog> findSystemLogListByPage(@Param("start")int start,@Param("size")int size);

	public void deleteSystemLogById(String id);

	public List<SystemLog> findByCriteria(@Param("description")byte[] description,@Param("startTime")Date startTime,@Param("endTime")Date endTime);
}
