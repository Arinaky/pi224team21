package webapp;

@WebServlet(name="Calc" urlPatterns="/JavaCalc")
public class Calc extend HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		
		request.getRequestDispatcher("/Result.jsp").forward(request, response)
	}
	
	private static class RequestCalc {
		private final String radius_calc;
		private final String height_calc;
		private int result;
		
		public RequestCalc(String radius, String height) {
			this.radius_calc = radius;
			this.height_calc = height;
		}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("radius");
			request.getParameter("height"));
		}
		
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute(radius_calc);
			request.setAttribute(height_calc);
			int radius_try;
			int height_try;
			try {
				radius_try=Integer.parseInt(radius_calc);
				height_try=Integer.parseInt(height_calc);
			} catch (NumberFormatException e) {
				radius_try=0;
				height_try=0;
			}
			result=1/3*Math.PI*Math,pow(radius_try, 2)*height_try
		}
	}
}
