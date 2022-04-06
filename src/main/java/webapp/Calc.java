package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Calc", urlPatterns="/Calc")
public class Calc extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		
		request.getRequestDispatcher("/Result.jsp").forward(request, response);
	}
	
	private static class RequestCalc {
		private final String radius_calc;
		private final String height_calc;
		private double result;
		
		public RequestCalc(String radius, String height) {
			this.radius_calc = radius;
			this.height_calc = height;
		}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("radius"),
			request.getParameter("height"));
		}
		
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			
			request.setAttribute("radius", radius_calc);
			request.setAttribute("height", height_calc);
			int radius_try = 3;
			int height_try = 5;
			try {
				radius_try= Integer.parseInt(radius_calc);
				height_try= Integer.parseInt(radius_calc);
			} catch (NumberFormatException e) {
				radius_try=0;
				height_try=0;
			}
			result=1/3*Math.PI*Math.pow(radius_try, 2)*height_try;
			request.setAttribute("result", result);
		}
	}
}
