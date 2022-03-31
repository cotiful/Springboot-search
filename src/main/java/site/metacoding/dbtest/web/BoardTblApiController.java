package site.metacoding.dbtest.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.dbtest.domain.boardTbl.BoardTbl;
import site.metacoding.dbtest.domain.boardTbl.BoardTblRepository;
import site.metacoding.dbtest.web.dto.ResponseDto;

@RestController
public class BoardTblApiController {

    private BoardTblRepository boardTblRepository;

    public BoardTblApiController(BoardTblRepository boardTblRepository) {
        this.boardTblRepository = boardTblRepository;
    }

    @GetMapping("/api/search")

    // 와일드카드 <?>를 쓰면 return 타입을 정하기가 easy 해짐 !
    public ResponseDto<?> search(@RequestParam(defaultValue = "") String keyword) {

        // 클라이언트 사이드 렌더링(css) 할거기 때문에 모델을 사용할 필요가 없다.
        List<BoardTbl> boards = boardTblRepository.mSearch(keyword);
        return new ResponseDto<>(1, "성공", boards); // 메세지 컨버터 발동, java Object -> Json으로 변환
    }
}
