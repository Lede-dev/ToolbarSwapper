package me.lede.toolbarswapper.Json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JsonFormat<T extends JsonData> {

	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private String path;
	private File file;
	private String json;
	private T data;
	
	public Gson getGson() {
		return gson;
	}
	
	public String getPath() {
		return path;
	}
	
	public File getFile() {
		return file;
	}
	
	public String getJson() {
		return json;
	}
	
	public T getData() {
		return data;
	}
	
	public void init(String path, T data) {
		this.path = path;
		this.data = data;
		this.file  = new File(this.path);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
			create().write();
		}
	}
	
	public JsonFormat<T> update(T data) {
		this.data = data;
		return this;
	}
	
	public JsonFormat<T> create() {
		this.json = gson.toJson(data);
		return this;
	}
	
	public JsonFormat<T> write() {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(path));
			writer.write(json);
		} catch (IOException ex) { 
			ex.printStackTrace(); 
		} finally { 
			try { 
				writer.close(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
		}	
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public JsonFormat<T> read() {
		BufferedReader reader = null;
		try {
			JsonParser jsonParser = new JsonParser();
			reader = new BufferedReader(new FileReader(path));
			JsonElement element = jsonParser.parse(reader);
			T data = gson.fromJson(element, (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
			this.data = data;
		} catch (FileNotFoundException e) {
			write();
		} catch (JsonIOException | JsonSyntaxException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return this;
	}
}












