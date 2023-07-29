package core.application.interfaces;

import core.application.dto.PageDTO;
import core.application.dto.PaginationDTO;
import core.domain.entities.BaseEntityModel;

import java.util.List;
import java.util.UUID;

public interface IBaseRepository<T extends BaseEntityModel> {
    T getById(UUID id);
    void create(T entity);
    void update(T entity);
    void delete(UUID id);
    List<T> getAll();
    PageDTO<T> getPage(PaginationDTO dto);

}
