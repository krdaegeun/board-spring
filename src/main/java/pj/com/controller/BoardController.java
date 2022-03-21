package pj.com.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pj.com.model.Board;
import pj.com.repository.BoardRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final Logger LOGGER = LoggerFactory.getLogger(BoardController.class.getName());
    private final BoardRepository boardRepository;

    @PostMapping("create")
    public Board create(@RequestBody Board board){
        LOGGER.info(board.toString());
        return boardRepository.save(board);
    }

    @GetMapping("get")
    public Board getBoard(@RequestParam long id){
        LOGGER.info("GET BY ID : " + id);
        return boardRepository.findById(id).get();
    }

    @GetMapping("getAll")
    public List<Board> getBoardList(){
        return boardRepository.findAll();
    }

    @DeleteMapping("delete")
    public void deleteBoard(@RequestParam long id){
        LOGGER.info("DELETE BY ID : " + id);
        boardRepository.deleteById(id);
    }
}
