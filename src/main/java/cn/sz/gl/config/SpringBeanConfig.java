package cn.sz.gl.config;

import java.io.File;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
//@ImportResource(locations= {"classpath:mybatis/mapper/pojo/Emp.xml","classpath:mybatis/mapper/pojo/Dept.xml"})
public class SpringBeanConfig {

	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
		msc.setBasePackage("cn.sz.gl.dao");
		return msc;
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		/*viewResolver.setViewClass(new InternalResourceView() {
			public boolean checkResource(java.util.Locale locale) throws Exception {
				File file = new File(this.getServletContext().getRealPath("/") + getUrl());
				return file.exists();
			}
		}.getClass());*/
		viewResolver.setOrder(1);
		return viewResolver;
	}
	
	
}
