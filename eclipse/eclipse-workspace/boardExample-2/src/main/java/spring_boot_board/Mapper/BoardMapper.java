package spring_boot_board.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import spring_boot_board.domain.BoardDTO;

@Mapper
public interface BoardMapper {

	void Insert(BoardDTO dto);

	List<BoardDTO> SelectAll();

	BoardDTO SelectOne(Integer boardNum);

	void Update(BoardDTO dto);

	void Delete(Integer boardNum);



}
