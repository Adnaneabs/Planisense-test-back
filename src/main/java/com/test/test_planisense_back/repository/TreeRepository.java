package com.test.test_planisense_back.repository;

import com.test.test_planisense_back.model.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {

    //pour les arrondissements

    //get all districts sorted alphabetically
    @Query("select distinct a.arrondissement from Tree as a order by a.arrondissement")
    List<String> getAllArrondissement();
    //get the number of trees per district
    @Query(value = "select count (*)  from Tree  as a group by a.arrondissement order by a.arrondissement")
    List<Long> getTreeByArrondissement();

    //pour les genres

    //get all genres
    @Query("select distinct a.genre from Tree as a order by a.genre")
    List<String> getGenre();

    //get all trees per genre
    @Query("select count (*) from Tree as a group by a.genre order by a.genre ")
    List<Long> getTreeByGenre();
}
