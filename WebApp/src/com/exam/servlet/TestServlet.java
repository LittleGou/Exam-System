package com.exam.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

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
	private String choices = null;
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
			case "submit":
				submitMark((Question)request.getSession().getAttribute("question"), request, response);
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
			// Choice Code
			choicesCode = new String[question.getChoice().size()];
			for(int i = 0; i < question.getChoice().size(); i++){
				choicesCode[i] = Code.CODE[i];
			}
			// Mark Map
			if(request.getSession().getAttribute("markMap") == null){
				Map<Integer,Integer> markMap = makeMap();
				request.getSession().setAttribute("markMap", markMap);
			}
			// Correct Map
			if(request.getSession().getAttribute("correctMap") == null){
				Map<Integer,Integer> correctMap = makeMap();
				request.getSession().setAttribute("correctMap", correctMap);
			}
			request.getSession().setAttribute("question", question);
			request.getSession().setAttribute("choicesCode", choicesCode);
			response.sendRedirect(request.getContextPath()+"/exam.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

/*---------------------------------------------------------------------------------------------------*/	
	public void submitMark(Question question, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		paper = question.getPaper();
		number = question.getNumber();
		System.out.println(paper);
		System.out.println(number);
		choices = request.getParameter("choices");
		
		// Modify Mark Map
		@SuppressWarnings("unchecked")
		Map<Integer,Integer> markMap = (Map<Integer, Integer>) request.getSession().getAttribute("markMap");
		markMap.put(number, 1);
		request.getSession().setAttribute("markMap", markMap);
		// Modify Correct Map
		@SuppressWarnings("unchecked")
		Map<Integer,Integer> correctMap = (Map<Integer, Integer>) request.getSession().getAttribute("correctMap");
		if(choices.equals(question.getAnswers())){
			correctMap.put(number, 1);
			request.getSession().setAttribute("correctMap", correctMap);
		}
		
		response.sendRedirect(request.getContextPath()+"/servlet/TestServlet?action=test&paper="+paper+"&number="+number);
	}
/*---------------------------------------------------------------------------------------------------*/	
	// Make Map
	private Map<Integer,Integer> makeMap(){
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		for (int i = 1; i <= 60; i++){
			map.put(i, 0);
		}
		return map;
	}
	
	// Iterate Map function
	@SuppressWarnings("rawtypes")
	private void iterateMap(Map map){
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
}
