package com.date.jum5.user.login.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.date.jum5.user.login.mapper.LoginService;
import com.date.jum5.user.login.vo.LoginVo;
import com.date.jum5.user.member.mapper.MemberMapper;
import com.date.jum5.user.member.vo.MemberVo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class LoginController {
	
	//private MemberMapper memberService;
	private LoginService loginService;
	private JavaMailSender mailSender;
	private MemberMapper memberMapper;
	
	@Autowired
	public LoginController(LoginService loginService, JavaMailSender mailSender, MemberMapper memberMapper) {
		this.mailSender=mailSender;
		this.loginService=loginService;
		this.memberMapper=memberMapper;
		//this.memberService = memberService;
	}
	
	//로그인 폼 요청 (o)
	@RequestMapping(value = "/loginForm" , method = RequestMethod.GET)
	public String login_form() throws Exception{
		return "/user/login/loginForm";
	}
	
	//로그인 성공 요청
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String checkId(@ModelAttribute LoginVo loginVo, HttpSession session, Model model) throws Exception{
		
		String page = "";
		
		//해당 입력된 아이디로 암호화된 비밀번호 가져오기
		String pwEncryption = loginService.pwTranslator(loginVo.getId());
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//암호화된 비밀번호랑 입력한 비밀번호가 같은지 확인
		boolean check = encoder.matches(loginVo.getPassword(), pwEncryption);
		
		
		if(!check) {
			page = "/user/login/loginFalse"; 
			return page;
			
		} else {
			loginVo = loginService.checkId(pwEncryption);
			page = "mainPage"; 
			
			//로그인 성공시 세션값 부여
			session.setAttribute("loginVo", loginVo.getNickname());

		}
		
		return "redirect:/";
	}
	
	//카카오 로그인 서비스 요청
	@RequestMapping(value = "/login/getKakaoAuthUrl")
	public @ResponseBody String getKakaoAuthUrl(
			HttpServletRequest request) throws Exception {
		String reqUrl = 
				"https://kauth.kakao.com/oauth/authorize"
				+ "?client_id=4ce3789c43e59a00faf9d8115fab8b56"
				+ "&redirect_uri=http://localhost:8080/date/login/oauth_kakao"
				+ "&response_type=code";
		
		return reqUrl;
	}
	
	// 카카오 연동정보 조회 
	@RequestMapping(value = "/login/oauth_kakao")
	public String oauthKakao(
			@RequestParam(value = "code", required = false) String code
			, Model model, HttpSession session) throws Exception {
		
		MemberVo kakaoMember = new MemberVo();
		
        String access_Token = getAccessToken(code);
        
        HashMap<String, Object> userInfo = getUserInfo(access_Token);
     
        String uuid = UUID.randomUUID().toString();
        
        kakaoMember.setPassword(uuid);
        kakaoMember.setId((String) userInfo.get("id"));
        kakaoMember.setNickName((String) userInfo.get("nickname"));
        
        if (userInfo.get("gender").equals("male")) {
        	kakaoMember.setGender("남자");
        } else if (userInfo.get("gender").equals("female")) {
        	kakaoMember.setGender("여자");
        }
        
        kakaoMember.setBirth((String) userInfo.get("birthday"));
        kakaoMember.setEmail((String) userInfo.get("email"));
        kakaoMember.setName((String) userInfo.get("name"));
        
        int kakaoMemberExist = memberMapper.kakaoMemberCheck((String) userInfo.get("id"));
        
        System.out.println(kakaoMemberExist);
        
        if (kakaoMemberExist!=1) {
        	memberMapper.registMember(kakaoMember);
        }
        
        //카카오에 연동된 정보의 이메일이 null 값이 아닐면 세션에 토큰이랑 사이트 내에서 사용할 이름 저장
        if (userInfo.get("email") != null) {
        	
        	//카카오 로그인시 마이페이지에서 사용할 유저정보 세션에 저장
        	session.setAttribute("userInfo", userInfo);
        	
        	session.setAttribute("loginVo", userInfo.get("nickname"));
        	session.setAttribute("access_Token", access_Token);
        	
        	JSONObject kakaoInfo =  new JSONObject(userInfo);
            
        	//연동된 유저정보 model로 저장
        	model.addAttribute("kakaoInfo", kakaoInfo);
        }
        
        
        return "redirect:/";
	}

	//토큰 발급 (토큰 발급하여 카카오 유저정보 얻어옴)
	@SuppressWarnings("deprecation")
	public String getAccessToken (String authorize_code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //URL연결은 입출력에 사용 될 수 있고, POST 혹은 PUT 요청을 하려면 setDoOutput을 true로 설정해야함.
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //	POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=4ce3789c43e59a00faf9d8115fab8b56"); 
            sb.append("&redirect_uri=http://localhost:8080/date/login/oauth_kakao"); 
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();

            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();

            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }

            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return access_Token;
    }
	
	//유저정보조회
    @SuppressWarnings("deprecation")
	public HashMap<String, Object> getUserInfo (String access_Token) {

//      요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
        HashMap<String, Object> userInfo = new HashMap<String, Object>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String name = properties.getAsJsonObject().get("nickname").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();
            String gender = kakao_account.getAsJsonObject().get("gender").getAsString();
            String birthday = kakao_account.getAsJsonObject().get("birthday").getAsString();
          
            userInfo.put("accessToken", access_Token);
            userInfo.put("nickname", nickname);
            userInfo.put("email", email);
            userInfo.put("gender", gender);
            userInfo.put("birthday", birthday);
            userInfo.put("name", name);
            userInfo.put("id", email);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userInfo;
    }
	
    //기존에 발급된 access token을 바로 만료시키게 서버에 요청
  	public void kakaoLogout(String access_Token) {
  		System.out.println("hello");
  	    String reqURL = "https://kapi.kakao.com/v1/user/logout";
  	    try {
  	        URL url = new URL(reqURL);
  	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
  	        conn.setRequestMethod("POST");
  	        conn.setRequestProperty("Authorization", "Bearer " + access_Token);
  	        
  	        int responseCode = conn.getResponseCode();
  	        System.out.println("responseCode : " + responseCode);
  	        
  	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
  	        
  	        String result = "";
  	        String line = "";
  	        
  	        while ((line = br.readLine()) != null) {
  	            result += line;
  	        }
  	    } catch (IOException e) {
  	        // TODO Auto-generated catch block
  	        e.printStackTrace();
  	    }
  	}
  	
  	//카카오 로그아웃 버튼 클릭했을 떄 
  	@RequestMapping(value="/kakaologout")
    public String logout(HttpSession session) {
  		String access_Token = (String)session.getAttribute("access_Token");
  	
  	    //session에 저장되있던 토큰이 null값이 아닐때 제거
          if(access_Token != null && !"".equals(access_Token)){
              kakaoLogout(access_Token);
              session.invalidate();
              
          //이미 null값일때
          }else{
              System.out.println("access_Token is null");
              //return "redirect:/";
          }
          //return "index";
          return "/user/login/logout";
      }
    
  //로그아웃 요청
  	@RequestMapping(value = "/logout" , method = RequestMethod.GET)
  	public String logOutPage(HttpServletRequest request, Model model) throws Exception{
  		
  		 HttpSession session = request.getSession();
  		 
  		 session.invalidate();
  
  		return "/user/login/logout";
  	}
	
	
	//logOut.jsp ���� Ȯ�� ��ư �������� �ε����� �̵��ϴ� ���
	@RequestMapping(value = "/logoutMain" , method = RequestMethod.GET)
	public	 String logoutMain() throws Exception{
		return "/";
	}
	
	
	//아이디, 비밀번호 찾기
	@RequestMapping(value = "/forGotPage" , method = RequestMethod.GET)
	public String forGotPage() throws Exception{
		return "/user/login/forGotPage";
	}
	
	//아이디 찾는 페이지 요청
	@RequestMapping(value = "/idSearch" , method = RequestMethod.GET)
	public String idSearch() throws Exception{
		return "/user/login/idSearch";
	}

	//비밀번호 찾는 페이지 요청
	@RequestMapping(value = "/pwSearch" , method = RequestMethod.GET)
	public String pwSearch() throws Exception{
		return "/user/login/pwSearch";
	}	
	
	//아이디 찾기 로직
	@RequestMapping(value = "/idForGot" , method = RequestMethod.POST)
	public String forGot(@ModelAttribute LoginVo idSearchOk, HttpSession session, Model model) throws Exception{
	
		idSearchOk = loginService.forGot(idSearchOk);
		
		String page = "";
		
		if(idSearchOk == null) {
			
			page = "/user/login/idSearch"; 
			
		} else {			
			page = "/user/login/idSearch"; 		
			model.addAttribute("idSearchOk", idSearchOk);			
			session.setAttribute("loginVo", idSearchOk);
		}
		return page;	
	}
	
	//비밀번호 찾기 폼 요청
	@RequestMapping(value = "/pwForGot" , method = RequestMethod.GET)
	public String forGotPw(@ModelAttribute LoginVo pwSearchOk,
		Model model, HttpServletRequest request) throws Exception{
		
		
		return "/user/login/pwSearch" ;
		
	}
	
	//찾는 비밀번호 아이디 존재여부 확인
	@RequestMapping(value="/pwForGot", method=RequestMethod.POST)
	public String pwFind(@RequestParam("id") String id,
			Model model, HttpSession session) {
		
		int idExist = loginService.idExist(id);
		if (idExist!=1) {
			model.addAttribute("idExist", idExist);
			return "/user/login/pwSearch";
		} else {
			session.setAttribute("changeId", id);

			return "/user/login/changePw";
		}		
	}
	
	//비밀번호 변경 로직
	@RequestMapping(value="/changePw", method=RequestMethod.POST)
	public String pwChange(@RequestParam("newPw") String newPw,
			@RequestParam("newPwCheck") String pwCheck,
			Model model, HttpSession session) {
		boolean check = true;
		
		if (!newPw.equals(pwCheck)) {
			check = false;
			model.addAttribute("pwCheck", check);
			return "/user/login/changePw";
		} else {
			String id = (String)session.getAttribute("changeId");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String securePw = encoder.encode(newPw);
			Map<String, String> change = new HashMap<>();
			change.put("id", id);
			change.put("pw", securePw);
			System.out.println(id);
			System.out.println(securePw);
			
			loginService.changePw(change);
			
			check = true;
			model.addAttribute("pwCheck", check);
			return "/user/login/changePw";
		}
	}
	
	@RequestMapping(value="/kakaoSignUp")
	public void kakaoSignUp() {
		System.out.println("hello");
	}
}

























