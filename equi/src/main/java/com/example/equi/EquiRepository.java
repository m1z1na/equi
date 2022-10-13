package com.example.equi;


import com.example.equi.model.Equi;
import org.hibernate.hql.internal.ast.tree.IdentNode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface EquiRepository extends CrudRepository<Equi, Integer> {


//    Optional<Equi> findById(IdentNode id);
}
