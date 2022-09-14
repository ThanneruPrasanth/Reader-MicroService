package com.reader.service;

import java.util.List;
import java.util.Optional;

import com.reader.entity.Reader;

public interface IReaderService {

	String saveReader(Reader reader);

	public List<Reader> getAllReader();

	Optional<Reader> getReaderById(Integer id);

	public void deleteReaderById(Integer id);

	Reader updateReader(Reader reader, Integer id);
}
