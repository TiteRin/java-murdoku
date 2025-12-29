package com.example.murdoku.controller;

import com.example.murdoku.model.Grid;
import com.example.murdoku.service.GridService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grid")
public class GridController {

    private final GridService gridService;

    public GridController(GridService gridService) {
        this.gridService = gridService;
    }

    @GetMapping("/{size}")
    public ResponseEntity<Grid> emptyGrid(@PathVariable int size) {
        try {
            Grid grid = gridService.createEmptyGrid(size);
            return ResponseEntity.ok(grid);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
