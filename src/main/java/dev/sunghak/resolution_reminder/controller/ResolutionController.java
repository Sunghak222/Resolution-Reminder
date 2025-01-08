package dev.sunghak.resolution_reminder.controller;

import dev.sunghak.resolution_reminder.model.Resolution;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.sunghak.resolution_reminder.service.ResolutionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resolutions")
public class ResolutionController {
    ResolutionService resolutionService;

    public ResolutionController(ResolutionService resolutionService) {
        this.resolutionService = resolutionService;
    }

    @PostMapping
    public ResponseEntity<Resolution> createResolution(@RequestBody Resolution resolution) {
        try {
            Resolution createdResolution = resolutionService.createResolution(resolution);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdResolution);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // 404 Bad Request.
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resolution> getResolutionById(@PathVariable Long id) {
        Optional<Resolution> res = resolutionService.getResolutionById(id);
        return res.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); //if Optional is empty, return 404
    }
    @GetMapping("/author/{userId}")
    public ResponseEntity<List<Resolution>> getResolutionsByAuthor(@PathVariable Long id) {
        List<Resolution> resolutions = resolutionService.getResolutionsByAuthorId(id);

        if (resolutions.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(resolutions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resolution> updateResolution(@PathVariable Long id, @RequestBody Resolution updatedResolution) {
        try {
            Resolution resolution = resolutionService.updateResolution(updatedResolution);
            return ResponseEntity.ok(updatedResolution);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Resolution> deleteResolution(@PathVariable Long id) {
        try {
            resolutionService.deleteResolution(id);
            return ResponseEntity.noContent().build();
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
