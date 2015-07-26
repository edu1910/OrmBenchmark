package com.sebbia.ormbenchmark.ormlite;


import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sebbia.ormbenchmark.BenchmarkEntity;
import com.sebbia.ormbenchmark.Blob;
import com.sebbia.ormbenchmark.utils.Utils;

@DatabaseTable(tableName = "entity")
public class OrmLiteEntity implements BenchmarkEntity {
	@DatabaseField(columnName = "id", generatedId = true)
	private long id;
	@DatabaseField(columnName = "field1")
	private String field1;
	@DatabaseField(columnName = "field2")
	private String field2;
	@DatabaseField(columnName = "blob", dataType = DataType.BYTE_ARRAY)
	private byte[] blobArray;
	@DatabaseField(columnName = "date", dataType = DataType.DATE)
	private Date date;
	
	private Blob blob;

	public OrmLiteEntity() {

	}

	@Override
	public void setField1(String field1) {
		this.field1 = field1;
	}

	@Override
	public void setField2(String field2) {
		this.field2 = field2;
	}

	@Override
	public void setBlob(Blob blob) {
		this.blob = blob;
		this.blobArray = Utils.serialize(blob);
	}

	@Override
	public String getField1() {
		return field1;
	}

	@Override
	public String getField2() {
		return field2;
	}

	@Override
	public Blob getBlob() {
		if (blob == null)
			blob = Utils.deserialize(blobArray);
		return blob;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Date getDate() {
		return date;
	}

}
