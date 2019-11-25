package filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class ErrorFilter extends ZuulFilter {
	public String filterType() {
		return "error";
	}
	public int filterOrder() {
		return 1;
	}
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		System.out.println("Inside Route Filter");
		return null;
	}
	
	

}
