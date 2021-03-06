package com.misiontic.library.web;

import com.misiontic.library.model.Library;
import com.misiontic.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Lib")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/all")
    public List<Library> getLibraries(){
        return libraryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Library> getLibrary(@PathVariable("id") Integer id){
        return libraryService.getLibrary(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Library save(@RequestBody Library library){
        return libraryService.save(library);
    }
}
