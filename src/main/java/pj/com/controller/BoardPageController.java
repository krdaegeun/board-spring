package pj.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pj.com.model.Board;
import pj.com.repository.BoardRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardPageController {
    private final BoardRepository boardRepository;

    @GetMapping("board/p")
    public List<Board> get(Pageable pageable){
        return boardRepository.findAllByOrderByIdDesc(pageable).getContent();
    }
}
