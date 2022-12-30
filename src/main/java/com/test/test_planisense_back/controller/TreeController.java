package com.test.test_planisense_back.controller;


import com.test.test_planisense_back.repository.TreeRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;
import java.util.Comparator;
import java.util.Map.Entry;

@RestController
@RequestMapping("/api")
//to allow connection with the frontend
@CrossOrigin(origins = "http://localhost:3000")

public class TreeController {
    private final TreeRepository treeRepository;
    public TreeController(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    /**
     *
     * @return list of number of trees per district sorted alphabetically
     */
    @GetMapping("/treesByArrondissement")
    private Map<String, Long> getListArrondissement(){
        //get all districts
        List<String > listArrondissement= treeRepository.getAllArrondissement();
        //get number of trees per district
        List<Long> listNbTree = treeRepository.getTreeByArrondissement();
        return sortedMap(listArrondissement, listNbTree);
    }

    /**
     *
     * @param listGenre
     * @param listNbTreeByGenre
     * @return sorted values in a map by its keys
     */
    private Map<String, Long> sortedMap(List<String> listGenre, List<Long> listNbTreeByGenre) {
        //map that contains the genres and number of trees by genre
        Map<String, Long> mapGT= new HashMap<>();
        for(int i =0 ; i< listGenre.size(); i++){
            mapGT.put(listGenre.get(i), listNbTreeByGenre.get(i));
        }
        return new TreeMap<>(mapGT);
    }


    /**
     *
     * @return list of genre
     */
    @GetMapping("/treesByGenre")
    private Map<String, Long> getListGenre(){
        //get the genres
        List<String> genres= treeRepository.getGenre();
        //get the number of trees per genre
        List<Long> treesPerGenre = treeRepository.getTreeByGenre();
        //create a Map with the genres as keys and the number of trees per genre as values
        Map<String, Long> mapGenresTrees = new HashMap<>();
        //the sorted version of that map
        LinkedHashMap<String, Long> sortedMapGT = new LinkedHashMap<>();

        for(int i =0 ; i< genres.size(); i++){
            mapGenresTrees.put(genres.get(i), treesPerGenre.get(i));
        }
        //list that will be used to sort the Map
        List<Entry<String, Long>> sortedList = new ArrayList<>(mapGenresTrees.entrySet());
        sortedList.sort(Entry.comparingByValue(Comparator.reverseOrder()));

        Map<String, Long> result = new LinkedHashMap<>();
        for (Entry<String, Long> entry : sortedList) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
