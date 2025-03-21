package springBootMVCShopping.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springBootMVCShopping.domain.InquireDTO;

@Repository
public class InquireRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "inquireMapperSql";
	String statement;
	public Integer inquireInsert(InquireDTO dto) {
		statement = namespace + ".inquireInsert";
		return sqlSession.insert(statement,dto);
	}
	public List<InquireDTO> inquireList(String goodsNum, Integer inquireNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodsNum", goodsNum);
		map.put("inquireNum", inquireNum);
		statement = namespace + ".inquireList";
		return sqlSession.selectList(statement,map);
	}
	public Integer inquireDelete(Integer inquireNum) {
		statement = namespace + ".inquireDelete";
		return sqlSession.delete(statement,inquireNum);
		
	}
	public Integer inquireUpdate(InquireDTO inquireDTO) {
		statement = namespace + ".inquireUpdate";
		return sqlSession.update(statement,inquireDTO);
		
	}
	public Integer inquireAnswerUpdate(InquireDTO dto) {
		statement = namespace + ".inquireAnswerUpdate";
		return sqlSession.update(statement,dto);	
	}
	
	
}
