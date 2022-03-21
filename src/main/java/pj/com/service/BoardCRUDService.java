package pj.com.service;

import org.springframework.data.domain.Pageable;
import pj.com.model.Board;

import java.util.List;

public interface BoardCRUDService {
    List<Board> getAll(Pageable pageable);
    List<Board> getAll();
    Board saveBoard(Board board);
    Board findBoard(long id);
    void deleteBoard(long id);
}
