package org.project.date.user.dao.mypage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.project.date.user.vo.login.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyPageDao {
	
	@Autowired
	SqlSession sqlSessionTemplate;
	
	//마이페이지
		public List<LoginVo> myPage(String id){
			return sqlSessionTemplate.selectList("myPage",id);
		}
		
		//마이페이지 테스트
		public List<LoginVo> list(){
			return sqlSessionTemplate.selectList("list");
		}
		
		//회원 탈퇴 테스트
		public int withdraw() {
			// TODO Auto-generated method stub
			return sqlSessionTemplate.update("withdraw");
		}

		
	
}
