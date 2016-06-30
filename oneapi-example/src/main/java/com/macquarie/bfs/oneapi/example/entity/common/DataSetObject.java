package com.macquarie.bfs.oneapi.example.entity.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"baseURI"})
public class DataSetObject {
	
	public DataSetObject(int offset, int limit, int size) {
		setOffset(offset);
		setLimit(limit);
		setSize(size);
	}
	
	public DataSetObject(int offset, int limit, int size, String baseURI) {
		setOffset(offset);
		setLimit(limit);
		setSize(size);
		setBaseURI(baseURI);
	}
	
	public String getBaseURI() {
		return baseURI;
	}
	public void setBaseURI(String baseURI) {
		this.baseURI = baseURI;
	}

	int offset;
	int limit;
	String prev;
	String next;
	String first;
	String last;
	String baseURI = "";
	int size;
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getPrev() {
		int prevOffset;
		if((offset - limit) < 0) prevOffset = 0;
		else prevOffset = offset - limit; 
		return getBaseURI() + "?offset=" + prevOffset + "&limit=" + limit;
	}
	public void setPrev(String prev) {
		this.prev = prev;
	}
	public String getNext() {
		int nextOffset = offset + limit; 
		return getBaseURI() + "?offset=" + nextOffset + "&limit=" + limit;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getFirst() {
		return getBaseURI() + "?offset=" + 0 + "&limit=" + limit;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		int lastOffset = size - limit;
		return getBaseURI() + "?offset=" + lastOffset + "&limit=" + limit;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
