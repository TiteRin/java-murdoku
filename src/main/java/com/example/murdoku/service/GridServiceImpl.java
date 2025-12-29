package com.example.murdoku.service;

import com.example.murdoku.model.Grid;
import org.springframework.stereotype.Service;

@Service
public class GridServiceImpl implements GridService {

    @Override
    public Grid createEmptyGrid(int size) {
        return new Grid(size);
    }
}
