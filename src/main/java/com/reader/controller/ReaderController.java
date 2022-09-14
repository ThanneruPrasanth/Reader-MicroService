package com.reader.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reader.entity.Reader;
import com.reader.service.IReaderService;

@RestController
@RequestMapping("/reader")
public class ReaderController {

	@Autowired
	IReaderService iReaderService;

	@PostMapping("/save")
	String createReader(@RequestBody Reader reader) {
		String saveReader = iReaderService.saveReader(reader);
		return "Data Inserted successfully";
	}

	@GetMapping("/getallreader")
	public List<Reader> getAllReader() {

		return iReaderService.getAllReader();
	}

	@GetMapping("/reader/{id}")
	public Optional<Reader> getReaderById(@PathVariable Integer id) {
		Optional<Reader> reader = iReaderService.getReaderById(id);
		return reader;
	}

	@DeleteMapping("/reader/{id}")
	public ResponseEntity<Reader> deleteReaderById(@PathVariable Integer id) {
		System.out.println(id);
		ResponseEntity<Reader> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			iReaderService.deleteReaderById(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Reader> updateReader(@PathVariable("id") Integer id, @RequestBody Reader reader) {
		return new ResponseEntity<Reader>(iReaderService.updateReader(reader, id), HttpStatus.OK);
	}

}
