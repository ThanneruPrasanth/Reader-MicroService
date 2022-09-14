package com.reader.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reader.entity.Reader;

@Service
public class ReaderServiceImpl implements IReaderService {

	@Autowired
	IReaderRepository iReaderRepository;

	@Override
	public String saveReader(Reader reader) {
		Reader savedReader = iReaderRepository.save(reader);
		return "Data Inserted successfully";
	}

	@Override
	public List<Reader> getAllReader() {
		return iReaderRepository.findAll();
	}

	@Override
	public Optional<Reader> getReaderById(Integer id) {

		return iReaderRepository.findById(id);
	}

	@Override
	public void deleteReaderById(Integer id) {
		iReaderRepository.deleteById(id);

	}

	@Override
	public Reader updateReader(Reader reader, Integer id) {
		Reader existingauthor = iReaderRepository.findById(id)
				.orElseThrow(() -> new com.reader.exception.ResouceNotFoundException("Author", "id", id));

		existingauthor.setTitle(reader.getTitle());
		existingauthor.setAuthor(reader.getAuthor());
		existingauthor.setPublisher(reader.getPublisher());
		existingauthor.setReleased_date(reader.getReleased_date());

		iReaderRepository.save(existingauthor);

		return existingauthor;

	}

}
