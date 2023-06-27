package com.onsang.onsangbe.controller;

import com.onsang.onsangbe.domain.Counselor;
import com.onsang.onsangbe.domain.CounselorDto;
import com.onsang.onsangbe.service.CounselorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequiredArgsConstructor
@RequestMapping( "/api/counselor")
public class CounselorController {

    private final CounselorService counselorService;

    @GetMapping
    public ResponseEntity allCounselors() {
        List<Counselor> counselors = counselorService.getAllCounselors();
        return ResponseEntity.ok().body(counselors);
    }

    @GetMapping("/{id}")
    public ResponseEntity findCounselor(@PathVariable Long id) {
        Counselor counselor = counselorService.getCounselorById(id);
        return ResponseEntity.ok().body(counselor);
    }

    @PostMapping
    public ResponseEntity createCounselor(@RequestBody CounselorDto counselorDto) {
        Long newCounselorId = counselorService.createCounselor(counselorDto);
        URI createdUri = linkTo(methodOn(CounselorController.class).createCounselor(counselorDto)).slash(newCounselorId).toUri();
        return ResponseEntity.created(createdUri).body(newCounselorId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable Long id, @RequestBody CounselorDto itemDto) {
        Long itemId = counselorService.updateCounselor(id, itemDto);
        return ResponseEntity.ok().body(itemId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        counselorService.deleteCounselor(id);
        return ResponseEntity.ok().body("delete success");
    }
}
