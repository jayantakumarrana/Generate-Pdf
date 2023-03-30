package com.jayit.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jayit.entity.BookEntity;
import com.jayit.repository.BookRepository;
import com.jayit.service.DatabasePDFService;

@Controller
public class PDFExportController {
	@Autowired
	BookRepository bookrepository;
	@GetMapping(value="/pdf" , produces=MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReport() throws IOException {
		List<BookEntity> book = (List<BookEntity>) bookrepository.findAll();
		ByteArrayInputStream bis = DatabasePDFService.playerPDFReport(book);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=playersf.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));

	}
}
