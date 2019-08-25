package cn.sz.gl.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import cn.sz.gl.dao.IEmpDAO;

@Configuration
@PropertySource(value= {"classpath:conn.properties"})
//@ImportResource(locations= {"classpath:mybatis_cfg.xml"})
public class MyBatisConfig {

	@Value("${mydriver}")
	private String driver;
	@Value("${myurl}")
	private String url;
	@Value("${myuser}")
	private String username;
	@Value("${mypwd}")
	private String pwd;
	
	@Autowired
	private BasicDataSource dataSource;
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(pwd);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/pojo/*.xml"));
		return sqlSessionFactory.getObject();
	}
}
