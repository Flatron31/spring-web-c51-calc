package by.tms.config;

import by.tms.config.WebConfiguration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[0];
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		registerHiddenFieldFilter(servletContext);
	}

	private void registerHiddenFieldFilter(ServletContext aContext) {
		aContext.addFilter("hiddenHttpMethodFilter",
				new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
	}
}
