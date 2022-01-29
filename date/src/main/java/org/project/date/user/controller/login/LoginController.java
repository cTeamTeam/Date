package org.project.date.user.controller.login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.project.date.user.mapper.login.LoginService;
import org.project.date.user.vo.login.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String home() throws Exception{
		return "member/mainPage";
	}
	
	
	//�α��� �� �̵�
	@RequestMapping(value = "/loginForm" , method = RequestMethod.GET)
	public String login_form() throws Exception{
		return "login/loginForm";
	}
	
	
	//로그인 성공 요청
	   @RequestMapping(value = "/login" , method = RequestMethod.POST)
	   public String checkId(@ModelAttribute LoginVo loginVo, HttpSession session, Model model) throws Exception{
	      
	      String page = "";
	      
	      //해당 입력된 아이디로 암호화된 비밀번호 가져오기
	      String pwEncryption = loginService.pwTranslator(loginVo.getId());
	      System.out.println("암호화된 비밀번호 : " +pwEncryption);
	      System.out.println(loginVo.getPassword());   
	      
	      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	      //암호화된 비밀번호랑 입력한 비밀번호가 같은지 확인
	      boolean check = encoder.matches(loginVo.getPassword(), pwEncryption);
	      
	      System.out.println(check);
	      
	      if(!check) {
	         page = "login/loginFalse"; //    н   ̵              
	         
	      } else {
	         loginVo = loginService.checkId(pwEncryption);
	         System.out.println("!!!");
	         System.out.println(loginVo.getNickname());
	         page = "login/loginSuccess"; //         ̵              
	         
	         model.addAttribute("loginVo", loginVo);
	         
	         session.setAttribute("loginVo", loginVo);
	      }
	      
	      
	      
	      return page;
	   }
	
	
	//---------------------- īī�� �α���---------------------------
	@RequestMapping(value = "/login/getKakaoAuthUrl")
	public @ResponseBody String getKakaoAuthUrl(
			HttpServletRequest request) throws Exception {
		String reqUrl = 
				"https://kauth.kakao.com/oauth/authorize"
				+ "?client_id=daf2661729b71cd6f6cb9dd95d756f70"
				+ "&redirect_uri=http://localhost8080/login"
				+ "&response_type=code";
		
		return reqUrl;
	}
	
	// īī�� �������� ��ȸ
	@RequestMapping(value = "/login/oauth_kakao")
	public String oauthKakao(
			@RequestParam(value = "code", required = false) String code
			, Model model) throws Exception {

		System.out.println("#########" + code);
        String access_Token = getAccessToken(code);
        System.out.println("###access_Token#### : " + access_Token);
        
        
        HashMap<String, Object> userInfo = getUserInfo(access_Token);
        System.out.println("###access_Token#### : " + access_Token);
        System.out.println("###userInfo#### : " + userInfo.get("email"));
        System.out.println("###nickname#### : " + userInfo.get("nickname"));
       
        JSONObject kakaoInfo =  new JSONObject(userInfo);
        model.addAttribute("kakaoInfo", kakaoInfo);
        
        return "/index"; //���� ���ϴ� ��� ����
	}
	
    //��ū�߱�
	@SuppressWarnings("deprecation")
	public String getAccessToken (String authorize_code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //  URL������ ����¿� ��� �� �� �ְ�, POST Ȥ�� PUT ��û�� �Ϸ��� setDoOutput�� true�� �����ؾ���.
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //	POST ��û�� �ʿ�� �䱸�ϴ� �Ķ���� ��Ʈ���� ���� ����
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=daf2661729b71cd6f6cb9dd95d756f70");  //������ �߱޹��� key
            sb.append("&redirect_uri=http://localhost8080/login"); // ������ ������ ���� ���
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();

            //    ��� �ڵ尡 200�̶�� ����
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //    ��û�� ���� ���� JSONŸ���� Response �޼��� �о����
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //    Gson ���̺귯���� ���Ե� Ŭ������ JSON�Ľ� ��ü ����
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return access_Token;
    }
	
    //����������ȸ
    @SuppressWarnings("deprecation")
	public HashMap<String, Object> getUserInfo (String access_Token) {

        //    ��û�ϴ� Ŭ���̾�Ʈ���� ���� ������ �ٸ� �� �ֱ⿡ HashMapŸ������ ����
        HashMap<String, Object> userInfo = new HashMap<String, Object>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //    ��û�� �ʿ��� Header�� ���Ե� ����
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();
            
            userInfo.put("accessToken", access_Token);
            userInfo.put("nickname", nickname);
            userInfo.put("email", email);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userInfo;
    }
	
    
    
	//--------------------�α׾ƿ�----------------------------------
	@RequestMapping(value = "/logout" , method = RequestMethod.GET)
	public String logOutPage(HttpServletRequest request) throws Exception{
		
		 HttpSession session = request.getSession();
		 
		 session.invalidate();
		
		return "login/logout";
	}
	
	//logOut.jsp ���� Ȯ�� ��ư �������� �ε����� �̵��ϴ� ���
	@RequestMapping(value = "/logoutMain" , method = RequestMethod.GET)
	public String logoutMain() throws Exception{
		return "/";
	}
	
	
	//--------------------���̵� / �н����� ã�� ����------------------------------
	
	//���̵� / �н����� ã��� �̵�
	@RequestMapping(value = "/forGotPage" , method = RequestMethod.GET)
	public String forGotPage() throws Exception{
		return "login/forGotPage";
	}
	//���̵� ã��� �̵�
	@RequestMapping(value = "/idSearch" , method = RequestMethod.GET)
	public String idSearch() throws Exception{
		return "login/idSearch";
		}
	//�н����� ã��� �̵�
	@RequestMapping(value = "/pwSearch" , method = RequestMethod.GET)
	public String pwSearch() throws Exception{
		return "login/pwSearch";
		}	
	
	//���̵� ã��
	@RequestMapping(value = "/idForGot" , method = RequestMethod.POST)
	public String forGot(@ModelAttribute LoginVo idSearchOk, HttpSession session, Model model) throws Exception{
	
	
		
		idSearchOk = loginService.forGot(idSearchOk);
		
		String page = "";
		
		
		
		if(idSearchOk == null) {
			
			page = "login/idSearch"; // ���н� �̵��� ������ ���
			
		} else {
			
			System.out.println(idSearchOk.getId());
			
			page = "login/idSearch"; // ������ �̵��� ������ ���
			
			model.addAttribute("idSearchOk", idSearchOk);
			
			session.setAttribute("loginVo", idSearchOk);
		}
		
		
		
		return page;	
	}
	
	//�н����� ã��
	
	@RequestMapping(value = "/pwForGot" , method = RequestMethod.POST)
	public String forGotPw(@ModelAttribute LoginVo pwSearchOk, HttpSession session, Model model) throws Exception{
	
		pwSearchOk = loginService.forGotPw(pwSearchOk);
		
		String page ="";
		
		if(pwSearchOk == null) {
			
			page = "login/pwSearch";
			
		}else {
			
			page = "login/pwSearch";
			
			
			model.addAttribute("pwSearchOk", pwSearchOk);
			
			session.setAttribute("loginVo", pwSearchOk);
		}
		return page;
	}
	
}