package pj.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pj.com.model.Board;
import pj.com.service.BoardCRUDService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardPageController {
    @Autowired
    private final BoardCRUDService boardCRUDService;

    @GetMapping("board/p")
    public List<Board> get(Pageable pageable){
        List<Board> boards = boardCRUDService.getAll(pageable);
        return boards;
    }
}


