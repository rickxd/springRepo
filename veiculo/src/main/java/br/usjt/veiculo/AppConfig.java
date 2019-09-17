package br.usjt.veiculo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.usjt.veiculo.interceptor.LoginInterceptor;
import br.usjt.veiculo.interceptor.RequestInterceptor;
import br.usjt.veiculo.model.Calculadora;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Bean
	public Calculadora getCalculadora() {
		return new Calculadora();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/", "/fazerLogin");
		registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");
	}
}
