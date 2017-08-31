package com.exam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.TestDAO;
import com.exam.dao.impl.TestDAOImpl;
import com.exam.entity.Question;
import com.exam.utils.Code;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/servlet/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String action = null;
	private String paper = null;
	private Integer number = null;
	private Integer[] mark = new Integer[60];
	
	private TestDAO testDAO = new TestDAOImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");
		switch (action){
			case "test":
				startTest(request, response);
				break;
			case "check":
				break;
		}
	}

/*---------------------------------------------------------------------------------------------------*/	
	public void startTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		paper = request.getParameter("paper");
		number = Integer.parseInt(request.getParameter("number"));
		
		Question question = new Question();
		question.setPaper(paper);
		question.setNumber(number);
		String[] choicesCode = null;

		try {
			question = testDAO.getAll(question);
			choicesCode = new String[question.getChoice().size()];
			for(int i = 0; i < question.getChoice().size(); i++){
				choicesCode[i] = Code.CODE[i];
				System.out.println(choicesCode[i]);
			}
			request.getSession().setAttribute("question", question);
			request.getSession().setAttribute("choicesCode", choicesCode);
			request.getSession().setAttribute("mark", mark);
			response.sendRedirect(request.getContextPath()+"/exam.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

/*---------------------------------------------------------------------------------------------------*/	
 //to do: server side cookie
/*---------------------------------------------------------------------------------------------------*/	
	
}
