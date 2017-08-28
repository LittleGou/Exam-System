package com.exam.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
	private String code = null;
	private Integer number = null;
	
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
			case "check":
				checkAnswer(request, response);
		}
	}

/*---------------------------------------------------------------------------------------------------*/	
	public void startTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		code = request.getParameter("code");
		number = Integer.parseInt(request.getParameter("number"));
		
		Question question = new Question();
		question.setCode(code);
		question.setNumber(number);
		String content = null;
		ArrayList<String> choices = null;
		Integer quantity = null;
		String[] choicesCode = null;
		try {
			content = testDAO.getQuestion(question);
			choices = testDAO.getChoice(question);
			quantity = testDAO.getQuantity(question);
			choicesCode = new String[choices.size()];
			for(int i = 0; i < choices.size(); i++){
				choicesCode[i] = Code.CODE[i];
				System.out.println(choicesCode[i]);
			}
			for(String each:choices){
				System.out.println(each);
			}
			
			if(content != null && choices != null){
				request.getSession().setAttribute("question", question);
				request.getSession().setAttribute("questionContent", content);
				request.getSession().setAttribute("choices", choices);
				request.getSession().setAttribute("quantity", quantity);
				request.getSession().setAttribute("choicesCode", choicesCode);
				response.sendRedirect(request.getContextPath()+"/exam.jsp");
				//request.getRequestDispatcher("/exam.jsp").forward(request, response);
			}else {
				System.out.println("No Content ...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/*---------------------------------------------------------------------------------------------------*/	
	public void checkAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
}
